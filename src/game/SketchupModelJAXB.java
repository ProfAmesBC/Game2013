package game;
// Google Sketchup model reader
// Can be used to read models at run time, or as a compiler to generate a class
// that is the model.
// Ames Fall 2012

// TODO normals untested

import jaxb.*;
import jaxb.CommonColorOrTextureType.Color;
import jaxb.ProfileCOMMON.Technique.Lambert;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.xml.bind.*;
import com.jogamp.opengl.util.GLBuffers;
import game.Building;

public class SketchupModelJAXB {

    private String fileName = null;
    private String filePath = null;
    private int displayList = -1;
    private LinkedList<String> delayedMethods = new LinkedList<String>();
    private String textureSetups = "";

    private jaxb.COLLADA      model         = null;
    private List<Object>      components    = null;
    private List<VisualScene> visualScenes  = null;
    private List<Geometry>    geometries    = null;
    private List<Material>    materials     = null;
    private List<Effect>      effects       = null;
    private List<Image>       images        = null;
    private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures

    private PrintWriter outFile=null; // used by compiler
    private boolean compiling;
    private boolean enableNormals = false; // may be shut off to reduce size, if lighting not needed

    // Constructor used by game to read in model at run time
    public SketchupModelJAXB(String model_dae_filename, GL2 gl, GLU glu) {
        fileName = model_dae_filename;
        filePath = "sketchupModels";
        compiling = false;
        generate(gl, glu);
    }
    
    // Alternate constructor, to specify whether surface normals are desired
    public SketchupModelJAXB(String model_dae_filename, GL2 gl, GLU glu, boolean enableNormals) {
        this(model_dae_filename, gl, glu);
        this.enableNormals = enableNormals;
    }

    // Constructor used by compiler
    public SketchupModelJAXB(File model_dae_file, File outfile, String baseName) {
        fileName = model_dae_file.getName();
        filePath = model_dae_file.getParent();
        try {
            outFile = new PrintWriter(new BufferedOutputStream(new FileOutputStream(outfile), 100000), false);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to open output file: " + outfile);
            e.printStackTrace();
            System.exit(1);
        }
        
        // decide whether to use normals or not (turn off for smaller size, if no lighting)
        int ret = JOptionPane.showConfirmDialog(null, "Enable Surface Normals?", "Surface Normals", JOptionPane.YES_NO_OPTION);
        enableNormals = ret == JOptionPane.YES_OPTION;
        System.out.println("Normals enabled: " + enableNormals);
        
        compiling = true;
        emitHeader(baseName);
        generate(null, null);
        emitTrailer();

        outFile.close();
    }

    // convenience method for compiler
    private void emit(String outputString) {
        outFile.println(outputString);
    }
    private void emitNoNewline(String outputString) {
        outFile.print(outputString);
    }

    // convenience method for compiler
    private void delayEmit(String outputString) {
        delayedMethods.add(outputString+'\n');
    }
    private void delayEmitNoNewline(String outputString) {
        delayedMethods.add(outputString);
    }


     // not used when compiling
    public void draw(GL2 gl, GLU glu) {
        gl.glCallList(displayList);
    }

    private int matrixLevel = 0, maxMat = 0;

    public void generate(GL2 gl, GLU glu) {
        if (model==null) {
            System.out.println("reading " + fileName);
            try {
                JAXBContext jc = JAXBContext.newInstance("jaxb");
                Unmarshaller unmarshaller = jc.createUnmarshaller();
                String prefix = "";
                if (!compiling)
                    prefix = "src/";
                model = (jaxb.COLLADA) unmarshaller.unmarshal(new File(prefix + filePath + "/" + fileName));
            } catch (JAXBException e) {
                System.out.println("Unable to unmarshal xml file: " + e);
                e.printStackTrace();
                System.exit(1);
            }
            System.out.println("read " + fileName);
        }

        components   = model.getLibraryAnimationsAndLibraryAnimationClipsAndLibraryCameras();
        for (Object component: components) {
            if (component instanceof LibraryVisualScenes)
                visualScenes = ((LibraryVisualScenes)component).getVisualScenes();
            else if (component instanceof LibraryGeometries)
                geometries = ((LibraryGeometries)component).getGeometries();
            else if (component instanceof LibraryMaterials)
                materials = ((LibraryMaterials)component).getMaterials();
            else if (component instanceof LibraryEffects)
                effects = ((LibraryEffects)component).getEffects();
            else if(component instanceof LibraryImages) {
            	images = ((LibraryImages)component).getImages();
            }
        }

        setupImages(gl); // instance vars, declared before generate method, set inside generate
        
        if (compiling) emit("private void generate(GL2 gl, GLU glu){");
        if (compiling) emit(textureSetups);
        
	    if (compiling) emit("displayList = gl.glGenLists(1);");            else displayList = gl.glGenLists(1);
	    if (compiling) emit("gl.glNewList(displayList, GL2.GL_COMPILE);"); else gl.glNewList(displayList, GL2.GL_COMPILE);
        if (compiling) emit("  gl.glPushAttrib(GL2.GL_POLYGON_BIT);");     else   gl.glPushAttrib(GL2.GL_POLYGON_BIT);
        if (compiling) emit("    gl.glFrontFace(GL2.GL_CCW);");            else     gl.glFrontFace(GL2.GL_CCW);
        if (compiling) emit("    gl.glCullFace(GL2.GL_BACK);");            else     gl.glCullFace(GL2.GL_BACK);
        if (compiling) emit("    gl.glEnable(GL2.GL_CULL_FACE);");         else     gl.glEnable(GL2.GL_CULL_FACE);
    	        System.out.print("drawing model ... ");

    	        if (compiling) emit("gl.glPushMatrix();"); else gl.glPushMatrix();
    	            double convertToFeet = model.getAsset().getUnit().getMeter();
    	            convertToFeet = convertToFeet /0.0254 /12.; // model units converted to feet
    	            if (compiling) emit("gl.glScaled("+convertToFeet+", "+convertToFeet+", "+convertToFeet+");"); else gl.glScaled(convertToFeet, convertToFeet, convertToFeet);
                    if (compiling) emit("gl.glRotatef(-90,1,0,0);");                                              else gl.glRotatef(-90,1,0,0);
    	            for (VisualScene visualScene: visualScenes) {
    	                List<Node> nodes = visualScene.getNodes();
    	                for (Node node: nodes) {
    	                   procNode(node, gl);
    	                }
    	            }
    	if (compiling) emit("       gl.glPopMatrix();");  else     gl.glPopMatrix();
        if (compiling) emit("   gl.glPopAttrib();");      else   gl.glPopAttrib();
        if (compiling) emit("gl.glEndList();");           else  gl.glEndList();


        // allow garbage collection
        components   = null;
        visualScenes = null;
        geometries   = null;
        materials    = null;
        effects      = null;
        model        = null;
        images       = null;
      //imageMap     = null; // must keep to prevent texture reclamation
        System.out.println("done, matrix level = " + matrixLevel + ",  max=" + maxMat);
    }

    private String sanitizeTextureFileName(String fileName) {
    	// some file names have %20 where a space should be
    	String trouble = "%20";
    	fileName = fileName.replaceAll(trouble, " ");
    	return fileName;
    }
    
    private static String sanitizeClassName(String className) {
        className = className.replaceAll(" ", "_"); // spaces to underscore
        className = className.substring(0, 1).toUpperCase() + className.substring(1); // first letter cap
        return className;
    }

    private void setupImages(GL2 gl) {
    	if (images != null) {
    		for (Image image: images) {
    			String imageID = image.getId();
    			String filename = image.getInitFrom();
    			filename = sanitizeTextureFileName(filename);
    			// TODO: texture might not be a power of two.  Should dynamically resize it.
    			if (compiling) {
    			    emit("private com.jogamp.opengl.util.texture.Texture " + imageID + ";");
    			    textureSetups += imageID + " = Building.setupTexture(gl, \""+  filename.replaceAll("\\\\", "\\\\\\\\")  +"\", \""+  "sketchupModels"  +"\");\n";
    			    //emit("imageMap.put(\""+imageID+"\", "+imageID+");"); // need to keep it, so it doesn't get gc'd
    			} else {
    	            com.jogamp.opengl.util.texture.Texture texture = Building.setupTexture(gl, filePath + File.separator + filename); // "textures" + File.separator + filename
    	            imageMap.put(imageID, texture);
    			}
    			System.out.println("read texture " + filename + ", using ID " + imageID);
    		}
    	}
    }

	// recursive, nodes can contain other nodes
    private void procNode(Node node, GL2 gl) {
        boolean hasMatrix = false;
        List<Object> matrices = node.getLookatsAndMatrixesAndRotates();
        for (Object potentialMatrix: matrices) {
            if (potentialMatrix instanceof Matrix) {
                List<Double> values = ((Matrix)potentialMatrix).getValues();
                hasMatrix = true;
                if (compiling) emit("{gl.glPushMatrix();"); else gl.glPushMatrix();
                matrixLevel++;
                if (matrixLevel>maxMat)
                    maxMat=matrixLevel;
                System.out.println("+");
                // convert row major to c-style column major
                if (compiling) {
                    emit("double[] darr = {"+values.get(0) +", "+values.get(4) + ", " + values.get(8) + ",  "+values.get(12)+",");
                    emit("        "+values.get(1) +", "+values.get(5) +", "+values.get(9) +", "+values.get(13)+",");
                    emit("        "+values.get(2) +", "+values.get(6) +", "+values.get(10) +", "+values.get(14)+",");
                    emit("        "+values.get(3) +", "+values.get(7) +", "+values.get(11) +", "+values.get(15)+" };");
                    emit("gl.glMultMatrixd(darr, 0);}");
                } else {
                    double[] darr = {values.get(0), values.get(4), values.get(8),  values.get(12),
                                     values.get(1), values.get(5), values.get(9),  values.get(13),
                                     values.get(2), values.get(6), values.get(10), values.get(14),
                                     values.get(3), values.get(7), values.get(11), values.get(15) };
                    gl.glMultMatrixd(darr, 0);
                }
            }
        }
        List<Node> level2nodes = node.getNodes();
        if (level2nodes != null && level2nodes.size()>0) {
            for (Node node2: level2nodes) {
                procNode(node2, gl);
            }
        }
        List<InstanceGeometry> instanceGeometries = node.getInstanceGeometries();
        for (InstanceGeometry instanceGeometry: instanceGeometries) {
            String geometryUrl = instanceGeometry.getUrl();
            if (geometryUrl.charAt(0) != '#')
                System.exit(1);
            geometryUrl = geometryUrl.substring(1);
            List<InstanceMaterial> instanceMaterials = instanceGeometry.getBindMaterial().getTechniqueCommon().getInstanceMaterials();
            processGeometry(geometryUrl, instanceMaterials, gl);
        }
        if (hasMatrix) {
            if (compiling) emit("gl.glPopMatrix();"); else gl.glPopMatrix();
            System.out.println("-");
            matrixLevel--;
        }
    }

    private void processGeometry(String geometryUrl, List<InstanceMaterial> instanceMaterials, GL2 gl) {
        for (Geometry geometry: geometries) {
            if (!geometryUrl.equals(geometry.getId())) {
                continue;
            }
            if (compiling) emit(geometryUrl + "(gl);");
            if (compiling) delayEmit("private void "+ geometryUrl +"(GL2 gl){");
            // OLD if (compiling) emit("{"); // because of duplicate local variables, the arrays mostly
            Mesh mesh = geometry.getMesh();

            List<Double> firstSource = null, secondSource = null, thirdSource = null;
            String firstSourceId=null, secondSourceId=null, thirdSourceId=null;
            List<Source> sources = mesh.getSources();
            if (sources.size() >= 1) {
                firstSource  = sources.get(0).getFloatArray().getValues();
                firstSourceId = sources.get(0).getId();
            }
            if (sources.size() >= 2) {
                secondSource = sources.get(1).getFloatArray().getValues();
                secondSourceId = sources.get(1).getId();
            }
            if (sources.size() >= 3) {
                thirdSource = sources.get(2).getFloatArray().getValues();
                thirdSourceId = sources.get(2).getId();
            }
            List<Double> positions = null; // will be set to first or second source, below
            List<Double> normals = null;   // will be set to first or second source, below

            List<InputLocal> inputs = mesh.getVertices().getInputs();
            for (InputLocal input: inputs) {
                String source = input.getSource();
                if (source.charAt(0)!='#')
                    System.exit(1);
                source = source.substring(1);
                String symantic = input.getSemantic();
                if (symantic.equals("POSITION"))
                    if (firstSourceId.equals(source))
                        positions = firstSource;
                    else if (secondSourceId.equals(source))
                        positions = secondSource;
                if (enableNormals && symantic.equals("NORMAL"))
                    if (firstSourceId.equals(source))
                        normals = firstSource;
                    else if(secondSourceId.equals(source))
                        normals = secondSource;
            }

            float[] positionsArray = new float[positions.size()]; // using floats not doubles, for smaller complied size.
            for (int i=0; i<positions.size(); ++i)
                positionsArray[i] = positions.get(i).floatValue();
            if (compiling) {
                delayEmit("float[] positionsArray = {");
                    for (double pos: positionsArray)
                        delayEmitNoNewline((float)pos + "f,"); // cast is to reduce digit count, for size
                delayEmit("};");
                delayEmit("FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);");
                delayEmit("gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);");
                delayEmit("gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);");
            } else {
                FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
                gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
                gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);             
            }

            float[] normalsArray = null; // using floats not doubles, for smaller complied size.
            FloatBuffer fbn = null; // whether compiling or not
            if (compiling) {
                delayEmit("FloatBuffer fbn = null;");
            }
            if (normals != null) {
                normalsArray = new float[normals.size()];
                for (int i=0; i<normals.size(); ++i)
                    normalsArray[i] = normals.get(i).floatValue();
                if (compiling) {
                    delayEmit("float[] normalsArray = {");
                    for (double norm: normalsArray) {
                        delayEmitNoNewline((float)norm + "f,");
                    }
                    delayEmit("};");
                    delayEmit("fbn = GLBuffers.newDirectFloatBuffer(normalsArray, 0);");
                    delayEmit("gl.glNormalPointer(GL2.GL_FLOAT, 0, fbn);");
                    delayEmit("gl.glEnableClientState(GL2.GL_NORMAL_ARRAY);");
                } else {
                    fbn = GLBuffers.newDirectFloatBuffer(normalsArray, 0);
                    gl.glNormalPointer(GL2.GL_FLOAT, 0, fbn);
                    gl.glEnableClientState(GL2.GL_NORMAL_ARRAY);
                }
            }

            FloatBuffer fbt = null;
            if (compiling)
                delayEmit("FloatBuffer fbt = null;");
            float[] texcoordArray = null; // jogl requires that texture coords be floats, doubles not allowed.
            if (compiling)
                delayEmit("float[] texcoordArray = null;");
            List<Object> linesAndJunk = mesh.getLinesAndLinestripsAndPolygons();
            for (Object junk: linesAndJunk) {
              delayEmit("{");
                if (junk instanceof Triangles) {
                    // code duplicated from lines
                    Triangles triangles = (Triangles)junk;
                    String material = triangles.getMaterial();
                    setColorFromMaterial(material, gl, instanceMaterials); // might enable texturing

                    int vertexOffset=0, texcoordOffset=0;
                    List<InputLocalOffset> localOffsets = triangles.getInputs();
                    for (InputLocalOffset localOffset: localOffsets) {
                    	int offset = localOffset.getOffset().intValue();
                    	String src = localOffset.getSource();
                    	if (src.charAt(0)!='#') {
                    		System.err.println("trouble");
                    	}
                    	src = src.substring(1);
                    	if (localOffset.getSemantic().equals("VERTEX")) {
                    		vertexOffset = offset; /////////////////////////////////////////////////////
                    	}
                    	if (localOffset.getSemantic().equals("TEXCOORD")) {
                    		texcoordOffset = offset; ///////////////////////////////////////////
                    		List<Double> texcoordSource = null;
                    		if (src.equals(firstSourceId)) {
                    			texcoordSource = firstSource;
                    		} else if (src.equals(secondSourceId)) {
                    			texcoordSource = secondSource;
                    		} else if (src.equals(thirdSourceId)) {
                    			texcoordSource = thirdSource;
                    		}
                    		if (texcoordSource != null) {
                    			texcoordArray = new float[texcoordSource.size()];
                                for (int i=0; i<texcoordSource.size(); ++i)
                                	texcoordArray[i] = texcoordSource.get(i).floatValue();
                                if (compiling) {
                                    fbt = GLBuffers.newDirectFloatBuffer(texcoordArray); // need non-null
                                    delayEmit("texcoordArray = new float[] {");
                                    for (float fl: texcoordArray) {
                                        delayEmitNoNewline(fl + "f,");
                                    }
                                    delayEmit("};");
                                    delayEmit("fbt = GLBuffers.newDirectFloatBuffer(texcoordArray);");
                                    delayEmit("gl.glTexCoordPointer(2, GL2.GL_FLOAT, 0, fbt);");
                                    delayEmit("gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);");
                                } else {
                                    fbt = GLBuffers.newDirectFloatBuffer(texcoordArray);
                                    gl.glTexCoordPointer(2, GL2.GL_FLOAT, 0, fbt);
                                    gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);                                    
                                }
                    		}
                    	}
                    }

                    List<BigInteger> ps = triangles.getP();
                    int[] indices = new int[ps.size()];
                    for (int i=0; i<ps.size(); ++i)
                        indices[i] = ps.get(i).intValue();
                    if (compiling) {
                        delayEmit("int[] indices = {");
                        for (int ind:indices)
                            delayEmitNoNewline(ind+",");
                        delayEmit("};");
                    }
                    IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
                    if (compiling)
                        delayEmit("IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);");

                    if (fbt == null || texcoordOffset==0) { // texcoordOffset==0 is new.  Happens in archway.dae; some triangles have texture coords and some don't.
                    	// no texture mapping
                        if (compiling) {
                    	    delayEmit("gl.glDrawElements(GL2.GL_TRIANGLES, "+indices.length+", GL2.GL_UNSIGNED_INT, fbi);");
                        } else {
                            gl.glDrawElements(GL2.GL_TRIANGLES, indices.length, GL2.GL_UNSIGNED_INT, fbi);                            
                        }
                    } else { // doing texture mapping; must do it manually!
                        if (compiling) {
                        	delayEmit("gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);");
                        	delayEmit("gl.glBegin(GL2.GL_TRIANGLES);");
    	                    delayEmit("	for (int i=0; i<indices.length-1; i+=2) {");
    	                    delayEmit("		int vertexIndex = indices[i];");
    	                    delayEmit("		int textureIndex = indices[i+1];");
    	                    delayEmit("		try {");
     	                    delayEmit("		gl.glTexCoord2f(texcoordArray[textureIndex*2], -(texcoordArray[textureIndex*2+1]));");
    	                    delayEmit("		} catch (ArrayIndexOutOfBoundsException e) {");
    	                    delayEmit("			System.out.println(e);");
    	                    delayEmit("		}");
    	                    delayEmit("		gl.glArrayElement(vertexIndex);");
    	                    delayEmit("	}");
                        	delayEmit("gl.glEnd();");
                        } else {
                            gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
                            gl.glBegin(GL2.GL_TRIANGLES);
                                //System.out.println("starting triangle with indices ");
                                //for (int i=0; i<Math.min(indices.length-1, 10); i++)
                                //  System.out.print(indices[i] + " ");
                                //System.out.println();
                                for (int i=0; i<indices.length-1; i+=2) {
                                    int vertexIndex = indices[i];
                                    int textureIndex = indices[i+1];
                                    try {
                                    //System.out.println("i="+i+",  Using texture coord["+textureIndex*2+","+(textureIndex*2+1)+"]  (" + texcoordArray[textureIndex*2] + "," + texcoordArray[textureIndex*2+1]+")");
                                    gl.glTexCoord2f(texcoordArray[textureIndex*2], -(texcoordArray[textureIndex*2+1]));
                                    } catch (ArrayIndexOutOfBoundsException e) {
                                        System.out.println(e);
                                    }
                                    gl.glArrayElement(vertexIndex);
                                }
                            gl.glEnd(); 
                        }
                    }
                    if (compiling) {
                        delayEmit("gl.glDisable(GL2.GL_TEXTURE_2D);"); 
                        delayEmit("gl.glDisable(GL2.GL_BLEND);"); // might have been turned on in setColor
                    } else { 
                        gl.glDisable(GL2.GL_TEXTURE_2D);
                        gl.glDisable(GL2.GL_BLEND); // might have been turned on in setColor
                    }
                } else if (junk instanceof Lines) {
                    // code duplicated from triangles
                    Lines lines = (Lines)junk;
                    String material = lines.getMaterial();
                    //if (compiling) delayEmit("setColorFromMaterial("+material+", gl, instanceMaterials);"); else setColorFromMaterial(material, gl, instanceMaterials);
                    setColorFromMaterial(material, gl, instanceMaterials); // if compiling, emits are in here

                    List<BigInteger> ps = lines.getP();
                    int[] indices = new int[ps.size()];
                    for (int i=0; i<ps.size(); ++i)
                        indices[i] = ps.get(i).intValue();
                    if (compiling) {
                        delayEmit("int[] indices = {");
                        for (int ind: indices)
                            delayEmit(ind+",");
                        delayEmit("};");
                        delayEmit("IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices);");
                        delayEmit("gl.glDrawElements(GL2.GL_LINES, indices.length, GL2.GL_UNSIGNED_INT, fbi);");
                        delayEmit("gl.glDisable(GL2.GL_BLEND);"); // might have been turned on in setColor
                    } else {
                        IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices);
                        gl.glDrawElements(GL2.GL_LINES, indices.length, GL2.GL_UNSIGNED_INT, fbi);
                        gl.glDisable(GL2.GL_BLEND); // might have been turned on in setColor
                    }
                }
              if (compiling) delayEmit("}");
            }
            if (compiling) {
                delayEmit("gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);");
                delayEmit("gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);");
                delayEmit("gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);");
            } else {
                gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
                gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
                gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
            }
          if (compiling) delayEmit("}");
        }
    }

    private void setColorFromMaterial(String desiredMaterialName, GL2 gl, List<InstanceMaterial> instanceMaterials) {
        for (InstanceMaterial instanceMaterial: instanceMaterials) {
            String symbol = instanceMaterial.getSymbol();
            if (symbol.equals(desiredMaterialName)) {
                // !! found the name.  Now go get the color.
                String target = instanceMaterial.getTarget();
                if (target.charAt(0) != '#')
                    System.exit(1);
                target = target.substring(1);
                // search the materials
                for (Material material:materials) {
                    if (material.getId().equals(target)) {
                        // found material, now need effect
                        String url = material.getInstanceEffect().getUrl();
                        if (url.charAt(0) != '#')
                            System.exit(1);
                        url = url.substring(1);
                        for (Effect effect: effects) {
                            if (effect.getId().equals(url)) {
                                List<JAXBElement<?>> fxProfileAbstracts = effect.getFxProfileAbstracts();
                                for (JAXBElement<?> fxProfileAbstract: fxProfileAbstracts) {
                                    ProfileCOMMON value = (ProfileCOMMON)fxProfileAbstract.getValue();
                                    List<Object> imagesAndParams = value.getImagesAndNewparams();
                                    for (Object obj: imagesAndParams) {
                                    	if (obj instanceof Image) {
                                    		continue;
                                    		/*
                                    		// All wrong!!!!!!!!!!
                                    		jaxb.Image image = (jaxb.Image)obj;
                                    		String textureName = image.getInitFrom();
                                           	com.jogamp.opengl.util.texture.Texture tex = imageMap.get(textureName);
                                        	tex.bind();
                                        	return;
                                        	*/
                                    	}
                                    	if (obj instanceof CommonNewparamType) {
                                    		CommonNewparamType commonNewparamType = (CommonNewparamType)obj;
                                    		FxSurfaceCommon surface = commonNewparamType.getSurface();
                                    		List<FxSurfaceInitFromCommon> initFroms = surface.getInitFroms(); // why are there multiples of these?
                                    		for (FxSurfaceInitFromCommon initFrom: initFroms) {
                                    			Object val = initFrom.getValue();
                                    			if (val instanceof jaxb.Image) {
                                            		jaxb.Image image = (jaxb.Image)val;
                                            		String textureID = image.getId();
                                            		if (compiling) {
                                            		    delayEmit("gl.glEnable(GL2.GL_TEXTURE_2D);");
                                                        delayEmit("gl.glEnable(GL2.GL_BLEND);");
                                                        delayEmit("gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);");
                                                        delayEmit(textureID + ".bind(gl);");
                                            		} else {
                                                       	com.jogamp.opengl.util.texture.Texture tex = imageMap.get(textureID);
                                                       	gl.glEnable(GL2.GL_TEXTURE_2D);
                                                       	gl.glEnable(GL2.GL_BLEND);
                                                       	gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
                                                    	tex.bind(gl);
                                            		}
                                                	return;
                                    			}
                                    		}
                                    	}
                                    }
                                    Lambert lambert = value.getTechnique().getLambert();
                                    if (lambert != null) {
                                    	CommonColorOrTextureType diffuse = value.getTechnique().getLambert().getDiffuse();
                                    	Color color = diffuse.getColor();
                                    	if (color != null) {
                                    		List<Double> colors = value.getTechnique().getLambert().getDiffuse().getColor().getValues();
                                    		if (compiling) {
                                    		    delayEmit("gl.glColor4d("+colors.get(0)+", "+colors.get(1)+", "+colors.get(2)+", "+colors.get(3)+");");
                                    		} else {
                                                gl.glColor4d(colors.get(0), colors.get(1), colors.get(2), colors.get(3));                                    		    
                                    		}
                                    		return;
                                    	}
                                    } else {
                                        CommonTransparentType transparent = value.getTechnique().getConstant().getTransparent();
                                        double transparencyValue = 1.0f;
                                        CommonFloatOrParamType transparency = value.getTechnique().getConstant().getTransparency();
                                        if (transparency != null)
                                            transparencyValue = transparency.getFloat().getValue();
                                        if (transparent != null) {
                                            List<Double> color = transparent.getColor().getValues();
                                            
                                            double r = color.get(0);
                                            double g = color.get(1);
                                            double b = color.get(2);
                                            double a = color.get(3);
                                            if (transparent.getOpaque().name().equals("A_ONE")) {
                                                if (compiling) {
                                                    delayEmit("gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);");
                                                } else {
                                                    gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
                                                }
                                            } else if (transparent.getOpaque().name().equals("RGB_ZERO")) {
                                                if (compiling) {
                                                    System.out.println("TODO-RGB_ZERO transparency");
                                                } else {
                                                    System.out.println("TODO-RGB_ZERO transparency");
                                                }
                                            }
                                            if (compiling) {
                                                delayEmit("gl.glEnable(GL2.GL_BLEND);");
                                                delayEmit("gl.glColor4d("+r+", "+g+", "+b+", "+a*transparencyValue+");");
                                            } else {
                                                gl.glEnable(GL2.GL_BLEND);
                                                gl.glColor4d(r, g, b, a*transparencyValue);
                                                //gl.glDisable(GL2.GL_BLEND); // turn off after the call to this method, somewhere
                                            }
                                            return;
                                        }
                                    } 
                                	// Hopefully we won't come here, I don't know why we would.
                                	System.out.println("Unknown draw technique encountered, using random color.");
                                	if (compiling) {
                                        delayEmit("gl.glColor4d(Math.random(), Math.random(), Math.random(), 1);");
                                	} else {
                                        gl.glColor4d(Math.random(), Math.random(), Math.random(), 1);
                                	}
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    // used by compiler only
    private void emitHeader(String baseName) {
        emit("//Compiled from "+baseName+" by SketchupModelJAXB\n");
        emit("package sketchupModels;");
        emit("import javax.media.opengl.GL2;");
        emit("import javax.media.opengl.glu.GLU;");
        emit("import game.Building;");
        emit("import java.nio.DoubleBuffer;");
        emit("import java.nio.FloatBuffer;");
        emit("import java.nio.IntBuffer;");
        emit("import com.jogamp.opengl.util.GLBuffers;");
        emit("import java.util.HashMap;");
        emit("import java.util.Map;");
        emit("public class " + baseName);
        emit("{");
        emit("private int displayList = -1;");
        emit("private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures");
        emit("public "+baseName+"(GL2 gl, GLU glu) {");
        emit("    generate(gl, glu);");
        emit("}");
        
        emit("public void draw(GL2 gl, GLU glu) {");
        emit("  gl.glCallList(displayList);");
        emit("}");
    }

    // used by compiler only
    private void emitTrailer() {
        emit("}"); // close of generate
        emit("//Trailer\n\n");
        for (String str:delayedMethods)
            emitNoNewline(str);
        emit("}");
        
    }

    /*
     * This main exists in case you want to COMPILE a sketchup model, instead of reading it at run time.
     * To COMPILE a model means to generate a java source file for it.  It's an additional stop, but means that
     * startup will be faster because the whole sketchup parse/convert step can be skipped.
     *
     * EXPERIMENTAL for now ...
     */
    public static void main(String[] args) {
        // choose the sketchup model
        File daeFile = selectModel();
        if (daeFile!=null) {
            String baseName = daeFile.getName().substring(0,daeFile.getName().lastIndexOf('.'));
            baseName = sanitizeClassName(baseName);
            File outputFile = new File(daeFile.getParent(), baseName+".java");
            new SketchupModelJAXB(daeFile, outputFile, baseName);
        }
    }

    private static File selectModel() {
        JFileChooser chooser = new JFileChooser(".");
        chooser.setFileFilter(new FileNameExtensionFilter("Sketchup dae file", "dae"));
        int retval = chooser.showOpenDialog(null);
        if (retval == JFileChooser.APPROVE_OPTION) {
            return chooser.getSelectedFile();
        }
        return null; // no dae file chosen
    }
}