//Compiled from Oar by SketchupModelJAXB

package weapons;
import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;
import game.Building;
import java.nio.DoubleBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import com.jogamp.opengl.util.GLBuffers;
import java.util.HashMap;
import java.util.Map;
public class OarWeapon extends BludgeoningWeapon{
private int displayList = -1;
private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures

public OarWeapon() {
	super();
}

public void init(GL2 gl, GLU glu){
	initialize(gl, glu);
	generate(gl, glu);
}

public void draw(GL2 gl, GLU glu) {
  gl.glCallList(displayList);
}
private com.jogamp.opengl.util.texture.Texture ID5;
private void generate(GL2 gl, GLU glu){
ID5 = Building.setupTexture(gl, "oar/Wood_Bamboo_Medium.jpg", "sketchupModels");

displayList = gl.glGenLists(1);
gl.glNewList(displayList, GL2.GL_COMPILE);
  gl.glPushAttrib(GL2.GL_POLYGON_BIT);
    gl.glFrontFace(GL2.GL_CCW);
    gl.glCullFace(GL2.GL_BACK);
    gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
gl.glScaled(0.08333333333333333, 0.08333333333333333, 0.08333333333333333);
gl.glRotatef(-90,1,0,0);
ID2(gl);
       gl.glPopMatrix();
   gl.glPopAttrib();
gl.glEndList();
}
//Trailer


private void ID2(GL2 gl){
float[] positionsArray = {
-2.4114575f,67.44095f,0.9574302f,-4.8720875f,64.980316f,-1.0110738f,-4.8720875f,64.980316f,0.9574302f,-2.4114575f,67.44095f,-1.0110738f,-2.4114575f,67.44095f,-1.0110738f,-4.8720875f,64.980316f,-1.0110738f,-4.8720875f,64.980316f,0.9574302f,-2.4114575f,67.44095f,0.9574302f,-4.8720875f,57.598427f,-1.0110738f,-1.6240559f,47.755905f,-1.0110738f,2.5098023f,67.44095f,-1.0110738f,0.0491724f,47.755905f,-1.0110738f,1.7224008f,47.755905f,-1.0110738f,4.9704323f,57.598427f,-1.0110738f,4.9704323f,64.980316f,-1.0110738f,-1.6240559f,47.755905f,-1.0110738f,0.0491724f,47.755905f,-1.0110738f,-4.8720875f,57.598427f,-1.0110738f,2.5098023f,67.44095f,-1.0110738f,4.9704323f,64.980316f,-1.0110738f,4.9704323f,57.598427f,-1.0110738f,1.7224008f,47.755905f,-1.0110738f,-4.8720875f,57.598427f,0.9574302f,-4.8720875f,57.598427f,0.9574302f,-1.6240559f,47.755905f,0.9574302f,2.5098023f,67.44095f,0.9574302f,0.0491724f,47.755905f,0.9574302f,1.7224008f,47.755905f,0.9574302f,4.9704323f,57.598427f,0.9574302f,4.9704323f,64.980316f,0.9574302f,-1.6240559f,47.755905f,0.9574302f,0.0491724f,47.755905f,0.9574302f,1.7224008f,47.755905f,0.9574302f,4.9704323f,57.598427f,0.9574302f,4.9704323f,64.980316f,0.9574302f,2.5098023f,67.44095f,0.9574302f,-0.2947308f,47.755905f,-0.9775362f,-0.6151977f,47.755905f,-0.879209f,-0.8903888f,47.755905f,-0.722793f,-1.1015503f,47.755905f,-0.5189478f,-1.234292f,47.755905f,-0.281565f,-1.2795677f,47.755905f,-0.0268218f,-1.234292f,47.755905f,0.2279214f,-1.1015503f,47.755905f,0.4653042f,-0.8903888f,47.755905f,0.6691494f,-0.6151977f,47.755905f,0.8255654f,-0.2947308f,47.755905f,0.9238926f,-0.2947308f,47.755905f,-0.9775362f,-0.6151977f,47.755905f,-0.879209f,-0.8903888f,47.755905f,-0.722793f,-1.1015503f,47.755905f,-0.5189478f,-1.234292f,47.755905f,-0.281565f,-1.2795677f,47.755905f,-0.0268218f,-1.234292f,47.755905f,0.2279214f,-1.1015503f,47.755905f,0.4653042f,-0.8903888f,47.755905f,0.6691494f,-0.6151977f,47.755905f,0.8255654f,-0.2947308f,47.755905f,0.9238926f,0.3930757f,47.755905f,-0.9775362f,0.7135425f,47.755905f,-0.879209f,0.9887336f,47.755905f,-0.722793f,1.1998951f,47.755905f,-0.5189478f,1.3326368f,47.755905f,-0.281565f,1.3779126f,47.755905f,-0.0268218f,1.3326368f,47.755905f,0.2279214f,1.1998951f,47.755905f,0.4653042f,0.9887336f,47.755905f,0.6691494f,0.7135425f,47.755905f,0.8255654f,0.3930757f,47.755905f,0.9238926f,0.3930757f,47.755905f,0.9238926f,0.7135425f,47.755905f,0.8255654f,0.9887336f,47.755905f,0.6691494f,1.1998951f,47.755905f,0.4653042f,1.3326368f,47.755905f,0.2279214f,1.3779126f,47.755905f,-0.0268218f,1.3326368f,47.755905f,-0.281565f,1.1998951f,47.755905f,-0.5189478f,0.9887336f,47.755905f,-0.722793f,0.7135425f,47.755905f,-0.879209f,0.3930757f,47.755905f,-0.9775362f,0.0491724f,47.755905f,-1.0110738f,-0.2947308f,-11.299212f,-0.9775362f,-0.2947308f,47.755905f,-0.9775362f,0.0491724f,-11.299212f,-1.0110738f,0.0491724f,-11.299212f,-1.0110738f,-0.2947308f,-11.299212f,-0.9775362f,-0.6151977f,-11.299212f,-0.879209f,-0.6151977f,47.755905f,-0.879209f,-0.6151977f,-11.299212f,-0.879209f,-0.8903888f,-11.299212f,-0.722793f,-0.8903888f,47.755905f,-0.722793f,-0.8903888f,-11.299212f,-0.722793f,-1.1015503f,47.755905f,-0.5189478f,-1.1015503f,-11.299212f,-0.5189478f,-1.1015503f,-11.299212f,-0.5189478f,-1.234292f,47.755905f,-0.281565f,-1.234292f,-11.299212f,-0.281565f,-1.234292f,-11.299212f,-0.281565f,-1.2795677f,-11.299212f,-0.0268218f,-1.2795677f,47.755905f,-0.0268218f,-1.2795677f,-11.299212f,-0.0268218f,-1.234292f,47.755905f,0.2279214f,-1.234292f,-11.299212f,0.2279214f,-1.234292f,-11.299212f,0.2279214f,-1.1015503f,-11.299212f,0.4653042f,-1.1015503f,47.755905f,0.4653042f,-1.1015503f,-11.299212f,0.4653042f,-0.8903888f,47.755905f,0.6691494f,-0.8903888f,-11.299212f,0.6691494f,-0.8903888f,-11.299212f,0.6691494f,-0.6151977f,-11.299212f,0.8255654f,-0.6151977f,47.755905f,0.8255654f,-0.6151977f,-11.299212f,0.8255654f,-0.2947308f,-11.299212f,0.9238926f,-0.2947308f,47.755905f,0.9238926f,-0.2947308f,-11.299212f,0.9238926f,0.0491724f,-11.299212f,0.9574302f,0.0491724f,47.755905f,0.9574302f,0.0491724f,-11.299212f,0.9574302f,0.3930757f,47.755905f,0.9238926f,0.3930757f,-11.299212f,0.9238926f,0.3930757f,-11.299212f,0.9238926f,0.7135425f,-11.299212f,0.8255654f,0.7135425f,47.755905f,0.8255654f,0.7135425f,-11.299212f,0.8255654f,0.9887336f,47.755905f,0.6691494f,0.9887336f,-11.299212f,0.6691494f,0.9887336f,-11.299212f,0.6691494f,1.1998951f,-11.299212f,0.4653042f,1.1998951f,47.755905f,0.4653042f,1.1998951f,-11.299212f,0.4653042f,1.3326368f,47.755905f,0.2279214f,1.3326368f,-11.299212f,0.2279214f,1.3326368f,-11.299212f,0.2279214f,1.3779126f,-11.299212f,-0.0268218f,1.3779126f,47.755905f,-0.0268218f,1.3779126f,-11.299212f,-0.0268218f,1.3326368f,47.755905f,-0.281565f,1.3326368f,-11.299212f,-0.281565f,1.3326368f,-11.299212f,-0.281565f,1.1998951f,47.755905f,-0.5189478f,1.1998951f,-11.299212f,-0.5189478f,1.1998951f,-11.299212f,-0.5189478f,0.9887336f,-11.299212f,-0.722793f,0.9887336f,47.755905f,-0.722793f,0.9887336f,-11.299212f,-0.722793f,0.7135425f,47.755905f,-0.879209f,0.7135425f,-11.299212f,-0.879209f,0.7135425f,-11.299212f,-0.879209f,0.3930757f,-11.299212f,-0.9775362f,0.3930757f,47.755905f,-0.9775362f,0.3930757f,-11.299212f,-0.9775362f,-0.2947308f,47.755905f,-0.9775362f,0.3930757f,47.755905f,-0.9775362f,0.0491724f,47.755905f,-1.0110738f,-0.6151977f,47.755905f,-0.879209f,0.7135425f,47.755905f,-0.879209f,-0.8903888f,47.755905f,-0.722793f,0.9887336f,47.755905f,-0.722793f,1.1998951f,47.755905f,-0.5189478f,-1.1015503f,47.755905f,-0.5189478f,-1.234292f,47.755905f,-0.281565f,1.3326368f,47.755905f,-0.281565f,1.3779126f,47.755905f,-0.0268218f,-1.2795677f,47.755905f,-0.0268218f,-1.234292f,47.755905f,0.2279214f,1.3326368f,47.755905f,0.2279214f,-1.1015503f,47.755905f,0.4653042f,1.1998951f,47.755905f,0.4653042f,-0.8903888f,47.755905f,0.6691494f,0.9887336f,47.755905f,0.6691494f,0.7135425f,47.755905f,0.8255654f,-0.6151977f,47.755905f,0.8255654f,-0.2947308f,47.755905f,0.9238926f,0.3930757f,47.755905f,0.9238926f,0.0491724f,47.755905f,0.9574302f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glEnable(GL2.GL_TEXTURE_2D);
gl.glEnable(GL2.GL_BLEND);
gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
ID5.bind(gl);
texcoordArray = new float[] {
-1.9159496f,0.0398929f,-1.7709556f,-0.0421281f,-1.7709556f,0.0398929f,-1.9159496f,-0.0421281f,0.1004774f,2.8100393f,0.2030036f,2.3999343f,0.2030036f,2.707513f,0.067669f,1.9898294f,-0.1045751f,2.8100393f,-0.0020489f,1.9898294f,-0.0717667f,1.9898294f,-0.2071013f,2.3999343f,-0.2071013f,2.707513f,-2.707513f,0.0398929f,-2.3999343f,-0.0421281f,-2.3999343f,0.0398929f,-2.707513f,-0.0421281f,-0.2030036f,2.3999343f,-0.1004774f,2.8100393f,-0.2030036f,2.707513f,-0.067669f,1.9898294f,0.1045751f,2.8100393f,0.0020489f,1.9898294f,0.0717667f,1.9898294f,0.2071013f,2.3999343f,0.2071013f,2.707513f,0.1004774f,0.0398929f,-0.1045751f,-0.0421281f,0.1004774f,-0.0421281f,-0.1045751f,0.0398929f,-0.0122805f,-0.0407307f,-0.067669f,-0.0421281f,0.0020489f,-0.0421281f,-0.0256332f,-0.0366337f,-0.0370995f,-0.0301164f,-0.0458979f,-0.0216228f,-0.0514288f,-0.0117319f,-0.067669f,0.0398929f,-0.0533153f,-0.0011176f,-0.0514288f,0.0094967f,-0.0458979f,0.0193877f,-0.0370995f,0.0278812f,-0.0256332f,0.0343986f,-0.0122805f,0.0384955f,0.0020489f,0.0398929f,-2.3426633f,0.0398929f,-1.9108049f,-0.0421281f,-1.9108049f,0.0398929f,-2.3426633f,-0.0421281f,1.7680581f,-0.0421281f,1.9130521f,0.0398929f,1.7680581f,0.0398929f,1.9130521f,-0.0421281f,2.3999343f,-0.0421281f,2.707513f,0.0398929f,2.3999343f,0.0398929f,2.707513f,-0.0421281f,2.3439474f,-0.0421281f,1.9120891f,0.0398929f,1.9120891f,-0.0421281f,2.3439474f,0.0398929f,0.0717667f,-0.0421281f,0.0163782f,-0.0407307f,0.0020489f,-0.0421281f,0.0297309f,-0.0366337f,0.0411972f,-0.0301164f,0.0499956f,-0.0216228f,0.0555265f,-0.0117319f,0.0717667f,0.0398929f,0.057413f,-0.0011176f,0.0555265f,0.0094967f,0.0499956f,0.0193877f,0.0411972f,0.0278812f,0.0297309f,0.0343986f,0.0163782f,0.0384955f,0.0020489f,0.0398929f,-1.9898294f,-0.0061281f,0.4708005f,0.0082692f,-1.9898294f,0.0082692f,0.4708005f,-0.0061281f,-1.9898294f,-2.072E-4f,0.4708005f,0.01376f,-1.9898294f,0.01376f,0.4708005f,-2.072E-4f,-1.9898294f,0.0041826f,0.4708005f,0.0173716f,-1.9898294f,0.0173716f,0.4708005f,0.0041826f,-1.9898294f,0.018004f,0.4708005f,0.0057748f,0.4708005f,0.018004f,-1.9898294f,0.0057748f,-1.9898294f,0.0148609f,0.4708005f,0.0035286f,0.4708005f,0.0148609f,-1.9898294f,0.0035286f,0.4708005f,0.0082292f,-1.9898294f,-0.0025514f,0.4708005f,-0.0025514f,-1.9898294f,0.0082292f,-1.9898294f,3.507E-4f,0.4708005f,-0.0104299f,0.4708005f,3.507E-4f,-1.9898294f,-0.0104299f,0.4708005f,-0.0054794f,-1.9898294f,-0.0168117f,0.4708005f,-0.0168117f,-1.9898294f,-0.0054794f,0.4708005f,-0.0195564f,-1.9898294f,-0.0073272f,-1.9898294f,-0.0195564f,0.4708005f,-0.0073272f,0.4708005f,-0.0052871f,-1.9898294f,-0.0184761f,0.4708005f,-0.0184761f,-1.9898294f,-0.0052871f,0.4708005f,-4.484E-4f,-1.9898294f,-0.0144156f,0.4708005f,-0.0144156f,-1.9898294f,-4.484E-4f,0.4708005f,0.0059112f,-1.9898294f,-0.0084861f,0.4708005f,-0.0084861f,-1.9898294f,0.0059112f,-0.4708005f,0.0018328f,1.9898294f,-0.0125645f,1.9898294f,0.0018328f,-0.4708005f,-0.0125645f,-0.4708005f,-0.0183331f,1.9898294f,-0.0043659f,-0.4708005f,-0.0043659f,1.9898294f,-0.0183331f,-0.4708005f,-0.0088495f,1.9898294f,-0.0220386f,1.9898294f,-0.0088495f,-0.4708005f,-0.0220386f,-0.4708005f,-0.0225045f,1.9898294f,-0.0102754f,-0.4708005f,-0.0102754f,1.9898294f,-0.0225045f,1.9898294f,-0.0188117f,-0.4708005f,-0.0074794f,-0.4708005f,-0.0188117f,1.9898294f,-0.0074794f,-0.4708005f,-0.011147f,1.9898294f,-3.663E-4f,-0.4708005f,-3.663E-4f,1.9898294f,-0.011147f,1.9898294f,-0.0018343f,-0.4708005f,0.0089463f,-0.4708005f,-0.0018343f,1.9898294f,0.0089463f,1.9898294f,0.0055285f,-0.4708005f,0.0168608f,-0.4708005f,0.0055285f,1.9898294f,0.0168608f,1.9898294f,0.0209521f,-0.4708005f,0.008723f,1.9898294f,0.008723f,-0.4708005f,0.0209521f,1.9898294f,0.007745f,-0.4708005f,0.0209341f,-0.4708005f,0.007745f,1.9898294f,0.0209341f,1.9898294f,0.0176774f,-0.4708005f,0.0037103f,1.9898294f,0.0037103f,-0.4708005f,0.0176774f,1.9898294f,-0.0020498f,-0.4708005f,0.0123475f,-0.4708005f,-0.0020498f,1.9898294f,0.0123475f,0.0122805f,-0.0407307f,-0.0163782f,-0.0407307f,-0.0020489f,-0.0421281f,0.0256332f,-0.0366337f,-0.0297309f,-0.0366337f,0.0370995f,-0.0301164f,-0.0411972f,-0.0301164f,-0.0499956f,-0.0216228f,0.0458979f,-0.0216228f,0.0514288f,-0.0117319f,-0.0555265f,-0.0117319f,-0.057413f,-0.0011176f,0.0533153f,-0.0011176f,0.0514288f,0.0094967f,-0.0555265f,0.0094967f,0.0458979f,0.0193877f,-0.0499956f,0.0193877f,0.0370995f,0.0278812f,-0.0411972f,0.0278812f,-0.0297309f,0.0343986f,0.0256332f,0.0343986f,0.0122805f,0.0384955f,-0.0163782f,0.0384955f,-0.0020489f,0.0398929f,0.0163782f,-0.0407307f,-0.0122805f,-0.0407307f,0.0020489f,-0.0421281f,-0.0256332f,-0.0366337f,0.0297309f,-0.0366337f,0.0411972f,-0.0301164f,-0.0370995f,-0.0301164f,0.0499956f,-0.0216228f,-0.0458979f,-0.0216228f,-0.0514288f,-0.0117319f,0.0555265f,-0.0117319f,0.057413f,-0.0011176f,-0.0533153f,-0.0011176f,-0.0514288f,0.0094967f,0.0555265f,0.0094967f,0.0499956f,0.0193877f,-0.0458979f,0.0193877f,0.0411972f,0.0278812f,-0.0370995f,0.0278812f,-0.0256332f,0.0343986f,0.0297309f,0.0343986f,0.0163782f,0.0384955f,-0.0122805f,0.0384955f,0.0020489f,0.0398929f,};
fbt = GLBuffers.newDirectFloatBuffer(texcoordArray);
gl.glTexCoordPointer(2, GL2.GL_FLOAT, 0, fbt);
gl.glEnableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
int[] indices = {
0,0,1,1,2,2,1,1,0,0,3,3,3,4,8,5,1,6,8,5,3,4,9,7,9,7,3,4,10,8,9,7,10,8,11,9,11,9,10,8,12,10,12,10,10,8,13,11,13,11,10,8,14,12,2,13,8,14,22,15,8,14,2,13,1,16,22,17,0,18,2,19,0,18,22,17,24,20,0,18,24,20,25,21,25,21,24,20,26,22,25,21,26,22,27,23,25,21,27,23,28,24,25,21,28,24,29,25,0,26,10,27,3,28,10,27,0,26,25,29,36,30,9,31,11,32,9,31,36,30,37,33,9,31,37,33,38,34,9,31,38,34,39,35,9,31,39,35,40,36,9,31,40,36,24,37,24,37,40,36,41,38,24,37,41,38,42,39,24,37,42,39,43,40,24,37,43,40,44,41,24,37,44,41,45,42,24,37,45,42,46,43,24,37,46,43,26,44,22,45,9,46,24,47,9,46,22,45,8,48,14,49,25,50,29,51,25,50,14,49,10,52,13,53,29,54,28,55,29,54,13,53,14,56,13,57,27,58,12,59,27,58,13,57,28,60,12,61,58,62,11,63,58,62,12,61,59,64,59,64,12,61,60,65,60,65,12,61,61,66,61,66,12,61,62,67,62,67,12,61,27,68,62,67,27,68,63,69,63,69,27,68,64,70,64,70,27,68,65,71,65,71,27,68,66,72,66,72,27,68,67,73,67,73,27,68,68,74,68,74,27,68,26,75,80,76,81,77,82,78,81,77,80,76,83,79,82,80,86,81,87,82,86,81,82,80,81,83,87,84,89,85,90,86,89,85,87,84,86,87,92,88,89,89,93,90,89,89,92,88,90,91,95,92,93,93,96,94,93,93,95,92,92,95,98,96,95,97,96,98,95,97,98,96,99,99,101,100,98,101,102,102,98,101,101,100,99,103,104,104,101,105,102,106,101,105,104,104,105,107,104,108,107,109,105,110,107,109,104,108,108,111,110,112,107,113,108,114,107,113,110,112,111,115,113,116,111,117,110,118,111,117,113,116,114,119,116,120,114,121,113,122,114,121,116,120,117,123,116,124,119,125,117,126,119,125,116,124,120,127,122,128,119,129,120,130,119,129,122,128,123,131,122,132,125,133,123,134,125,133,122,132,126,135,128,136,125,137,126,138,125,137,128,136,129,139,131,140,128,141,132,142,128,141,131,140,129,143,134,144,131,145,132,146,131,145,134,144,135,147,137,148,134,149,138,150,134,149,137,148,135,151,140,152,138,153,141,154,138,153,140,152,137,155,140,156,143,157,144,158,143,157,140,156,141,159,146,160,143,161,147,162,143,161,146,160,144,163,146,164,149,165,150,166,149,165,146,164,147,167,80,168,149,169,83,170,149,169,80,168,150,171,152,172,153,173,154,174,153,173,152,172,155,175,153,173,155,175,156,176,156,176,155,175,157,177,156,176,157,177,158,178,158,178,157,177,159,179,159,179,157,177,160,180,159,179,160,180,161,181,159,179,161,181,162,182,162,182,161,181,163,183,163,183,161,181,164,184,163,183,164,184,165,185,163,183,165,185,166,186,166,186,165,185,167,187,166,186,167,187,168,188,168,188,167,187,169,189,168,188,169,189,170,190,170,190,169,189,171,191,171,191,169,189,172,192,171,191,172,192,173,193,171,191,173,193,174,194,174,194,173,193,175,195,149,196,81,197,83,198,81,197,149,196,86,199,86,199,149,196,147,200,86,199,147,200,143,201,86,199,143,201,89,202,89,202,143,201,141,203,89,202,141,203,93,204,93,204,141,203,96,205,96,205,141,203,138,206,96,205,138,206,134,207,96,205,134,207,98,208,98,208,134,207,102,209,102,209,134,207,132,210,102,209,132,210,128,211,102,209,128,211,104,212,104,212,128,211,126,213,104,212,126,213,108,214,108,214,126,213,110,215,110,215,126,213,122,216,110,215,122,216,120,217,110,215,120,217,113,218,113,218,120,217,116,219,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
gl.glBegin(GL2.GL_TRIANGLES);
	for (int i=0; i<indices.length-1; i+=2) {
		int vertexIndex = indices[i];
		int textureIndex = indices[i+1];
		try {
		gl.glTexCoord2f(texcoordArray[textureIndex*2], -(texcoordArray[textureIndex*2+1]));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		gl.glArrayElement(vertexIndex);
	}
gl.glEnd();
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glBlendFunc(GL2.GL_SRC_ALPHA, GL2.GL_ONE_MINUS_SRC_ALPHA);
gl.glEnable(GL2.GL_BLEND);
gl.glColor4d(0.0, 0.0, 0.0, 1.0);
int[] indices = {
};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices);
gl.glDrawElements(GL2.GL_LINES, indices.length, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
}
