//Compiled from Flamethrower by SketchupModelJAXB

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
public class FlamethrowerWeapon
{
private int displayList = -1;
private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures
public FlamethrowerWeapon(GL2 gl, GLU glu) {
    generate(gl, glu);
}
public void draw(GL2 gl, GLU glu) {
  gl.glCallList(displayList);
}
private void generate(GL2 gl, GLU glu){

displayList = gl.glGenLists(1);
gl.glNewList(displayList, GL2.GL_COMPILE);
  gl.glPushAttrib(GL2.GL_POLYGON_BIT);
    gl.glFrontFace(GL2.GL_CCW);
    gl.glCullFace(GL2.GL_BACK);
    gl.glEnable(GL2.GL_CULL_FACE);
gl.glPushMatrix();
gl.glScaled(0.08333333333333333, 0.08333333333333333, 0.08333333333333333);
gl.glRotatef(-90,1,0,0);
{gl.glPushMatrix();
double[] darr = {0.3931207, 0.9194869, -0.0,  0.0,
        -0.9194869, 0.3931207, 0.0, 0.0,
        0.0, 0.0, 1.0, 0.0,
        18.4226725, 14.4186011, -0.0, 1.0 };
gl.glMultMatrixd(darr, 0);}
gl.glPopMatrix();
ID184(gl);
ID192(gl);
ID202(gl);
ID208(gl);
ID214(gl);
ID220(gl);
ID228(gl);
ID236(gl);
ID242(gl);
ID248(gl);
ID254(gl);
ID260(gl);
ID266(gl);
       gl.glPopMatrix();
   gl.glPopAttrib();
gl.glEndList();
}
//Trailer


private void ID184(GL2 gl){
float[] positionsArray = {
121.73063f,0.0f,69.5467f,115.118935f,0.0f,69.02512f,118.459114f,0.0f,68.850685f,111.93771f,0.0f,70.05812f,124.710526f,0.0f,71.06572f,109.13225f,0.0f,71.87928f,127.19574f,0.0f,73.304245f,106.89372f,0.0f,74.36449f,129.01689f,0.0f,76.10971f,105.3747f,0.0f,77.34439f,130.0499f,0.0f,79.290924f,104.67869f,0.0f,80.615906f,130.22433f,0.0f,82.63111f,104.85313f,0.0f,83.956085f,129.52832f,0.0f,85.902626f,105.88612f,0.0f,87.13731f,128.0093f,0.0f,88.88252f,107.70728f,0.0f,89.94277f,125.770775f,0.0f,91.36774f,110.19249f,0.0f,92.18129f,122.96531f,0.0f,93.188896f,113.17239f,0.0f,93.70032f,119.78409f,0.0f,94.221886f,116.44391f,0.0f,94.396324f,134.5143f,141.53314f,73.48882f,130.0499f,0.0f,79.290924f,129.01689f,0.0f,76.10971f,136.03831f,141.53314f,78.182175f,130.22433f,0.0f,82.63111f,136.29565f,141.53314f,83.110054f,129.52832f,0.0f,85.902626f,135.26881f,141.53314f,87.93663f,128.0093f,0.0f,88.88252f,133.02774f,141.53314f,92.33297f,125.770775f,0.0f,91.36774f,129.72519f,141.53314f,95.99948f,125.5862f,141.53314f,98.686295f,122.96531f,0.0f,93.188896f,120.89284f,141.53314f,100.210304f,119.78409f,0.0f,94.221886f,116.44391f,0.0f,94.396324f,115.96496f,141.53314f,100.46766f,113.17239f,0.0f,93.70032f,111.13839f,141.53314f,99.44081f,110.19249f,0.0f,92.18129f,106.74204f,141.53314f,97.199745f,107.70728f,0.0f,89.94277f,103.07553f,141.53314f,93.89719f,105.88612f,0.0f,87.13731f,100.388725f,141.53314f,89.758194f,104.85313f,0.0f,83.956085f,98.86471f,141.53314f,85.064835f,104.67869f,0.0f,80.615906f,98.60736f,141.53314f,80.136955f,105.3747f,0.0f,77.34439f,99.63421f,141.53314f,75.31039f,106.89372f,0.0f,74.36449f,101.875275f,141.53314f,70.91404f,109.13225f,0.0f,71.87928f,105.17783f,141.53314f,67.24753f,109.316826f,141.53314f,64.56072f,111.93771f,0.0f,70.05812f,109.445816f,141.53314f,64.51883f,113.296585f,141.53314f,63.268425f,115.118935f,0.0f,69.02512f,114.010185f,141.53314f,63.03671f,114.02976f,141.53314f,63.035686f,118.93806f,141.53314f,62.779354f,118.459114f,0.0f,68.850685f,121.73063f,0.0f,69.5467f,123.76463f,141.53314f,63.806202f,124.710526f,0.0f,71.06572f,128.16098f,141.53314f,66.04727f,127.19574f,0.0f,73.304245f,131.82748f,141.53314f,69.34983f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.227451, 0.054902, 1.0);
int[] indices = {
0,1,2,1,0,3,3,0,4,3,4,5,5,4,6,5,6,7,7,6,8,7,8,9,9,8,10,9,10,11,11,10,12,11,12,13,13,12,14,13,14,15,15,14,16,15,16,17,17,16,18,17,18,19,19,18,20,19,20,21,21,20,22,21,22,23,24,25,26,25,24,27,27,28,25,28,27,29,29,30,28,30,29,31,31,32,30,32,31,33,33,34,32,34,33,35,34,36,37,36,34,35,37,38,39,38,37,36,40,38,41,38,40,39,42,41,43,41,42,40,44,43,45,43,44,42,46,45,47,45,46,44,47,48,46,48,47,49,49,50,48,50,49,51,51,52,50,52,51,53,53,54,52,54,53,55,55,56,54,56,55,57,57,58,56,58,57,59,60,58,59,58,60,61,62,61,60,61,62,63,61,63,64,64,63,65,66,64,65,64,66,67,64,67,68,67,69,68,69,67,70,70,71,69,71,70,72,72,73,71,73,72,74,74,26,73,26,74,24,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 219, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID192(GL2 gl){
float[] positionsArray = {
109.445816f,141.53314f,64.51883f,113.296585f,141.53314f,63.268425f,109.53273f,141.53314f,64.46323f,109.53273f,141.53314f,64.46323f,113.296585f,141.53314f,63.268425f,109.445816f,141.53314f,64.51883f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 3, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
3,4,5,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 3, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID202(GL2 gl){
float[] positionsArray = {
113.296585f,141.53314f,63.268425f,114.02976f,141.53314f,63.035686f,114.010185f,141.53314f,63.03671f,114.010185f,141.53314f,63.03671f,114.02976f,141.53314f,63.035686f,113.296585f,141.53314f,63.268425f,114.02976f,166.03314f,63.035686f,113.296585f,141.53314f,63.268425f,113.296585f,166.03314f,63.268425f,114.02976f,141.53314f,63.035686f,114.02976f,141.53314f,63.035686f,114.02976f,166.03314f,63.035686f,113.296585f,141.53314f,63.268425f,113.296585f,166.03314f,63.268425f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,6,7,8,7,6,9,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 9, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
3,4,5,10,11,12,13,12,11,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 9, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID208(GL2 gl){
float[] positionsArray = {
114.345505f,141.53314f,62.935455f,118.93806f,141.53314f,62.779354f,119.3897f,141.53314f,62.70538f,114.02976f,141.53314f,63.035686f,99.55242f,141.53314f,75.39748f,99.63421f,141.53314f,75.31039f,101.875275f,141.53314f,70.91404f,98.60736f,141.53314f,80.136955f,98.469124f,141.53314f,80.329346f,98.86471f,141.53314f,85.064835f,98.699196f,141.53314f,85.37354f,100.388725f,141.53314f,89.758194f,100.22697f,141.53314f,90.18631f,103.07553f,141.53314f,93.89719f,102.94831f,141.53314f,94.439674f,106.74204f,141.53314f,97.199745f,106.67779f,141.53314f,97.84377f,111.13839f,141.53314f,99.44081f,111.161224f,141.53314f,100.16662f,115.96496f,141.53314f,100.46766f,116.09309f,141.53314f,101.24992f,121.13728f,141.53314f,101.019844f,124.32156f,141.53314f,63.78868f,123.76463f,141.53314f,63.806202f,128.80501f,141.53314f,66.11153f,128.16098f,141.53314f,66.04727f,131.82748f,141.53314f,69.34983f,132.53447f,141.53314f,69.515625f,134.5143f,141.53314f,73.48882f,135.25583f,141.53314f,73.76899f,136.03831f,141.53314f,78.182175f,136.78358f,141.53314f,78.581764f,136.29565f,141.53314f,83.110054f,137.01366f,141.53314f,83.62595f,135.26881f,141.53314f,87.93663f,135.93036f,141.53314f,88.55782f,133.02774f,141.53314f,92.33297f,133.60751f,141.53314f,93.04126f,129.72519f,141.53314f,95.99948f,130.20341f,141.53314f,96.77073f,125.5862f,141.53314f,98.686295f,125.95006f,141.53314f,99.49208f,120.89284f,141.53314f,100.210304f,115.96496f,141.53314f,100.46766f,120.89284f,141.53314f,100.210304f,121.13728f,141.53314f,101.019844f,125.95006f,141.53314f,99.49208f,125.5862f,141.53314f,98.686295f,130.20341f,141.53314f,96.77073f,129.72519f,141.53314f,95.99948f,133.60751f,141.53314f,93.04126f,133.02774f,141.53314f,92.33297f,135.93036f,141.53314f,88.55782f,135.26881f,141.53314f,87.93663f,137.01366f,141.53314f,83.62595f,136.29565f,141.53314f,83.110054f,136.78358f,141.53314f,78.581764f,136.03831f,141.53314f,78.182175f,135.25583f,141.53314f,73.76899f,134.5143f,141.53314f,73.48882f,132.53447f,141.53314f,69.515625f,131.82748f,141.53314f,69.34983f,128.80501f,141.53314f,66.11153f,128.16098f,141.53314f,66.04727f,123.76463f,141.53314f,63.806202f,124.32156f,141.53314f,63.78868f,118.93806f,141.53314f,62.779354f,119.3897f,141.53314f,62.70538f,116.09309f,141.53314f,101.24992f,111.161224f,141.53314f,100.16662f,111.13839f,141.53314f,99.44081f,106.67779f,141.53314f,97.84377f,106.74204f,141.53314f,97.199745f,102.94831f,141.53314f,94.439674f,103.07553f,141.53314f,93.89719f,100.22697f,141.53314f,90.18631f,100.388725f,141.53314f,89.758194f,98.699196f,141.53314f,85.37354f,98.86471f,141.53314f,85.064835f,98.469124f,141.53314f,80.329346f,98.60736f,141.53314f,80.136955f,99.55242f,141.53314f,75.39748f,99.63421f,141.53314f,75.31039f,101.875275f,141.53314f,70.91404f,114.02976f,141.53314f,63.035686f,114.345505f,141.53314f,62.935455f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,5,6,5,4,7,7,4,8,7,8,9,9,8,10,9,10,11,11,10,12,11,12,13,13,12,14,13,14,15,15,14,16,15,16,17,17,16,18,17,18,19,19,18,20,19,20,21,1,22,2,22,1,23,22,23,24,24,23,25,24,25,26,24,26,27,27,26,28,27,28,29,29,28,30,29,30,31,31,30,32,31,32,33,33,32,34,33,34,35,35,34,36,35,36,37,37,36,38,37,38,39,39,38,40,39,40,41,41,40,42,41,42,21,21,42,19,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 123, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
43,44,45,45,44,46,44,47,46,46,47,48,47,49,48,48,49,50,49,51,50,50,51,52,51,53,52,52,53,54,53,55,54,54,55,56,55,57,56,56,57,58,57,59,58,58,59,60,59,61,60,60,61,62,61,63,62,63,64,62,62,64,65,64,66,65,67,65,66,45,68,43,68,69,43,43,69,70,69,71,70,70,71,72,71,73,72,72,73,74,73,75,74,74,75,76,75,77,76,76,77,78,77,79,78,78,79,80,79,81,80,80,81,82,83,82,81,84,85,66,67,66,85,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 123, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID214(GL2 gl){
float[] positionsArray = {
109.316826f,141.53314f,64.56072f,105.27937f,141.53314f,67.18457f,109.445816f,141.53314f,64.51883f,105.17783f,141.53314f,67.24753f,101.875275f,141.53314f,70.91404f,101.875275f,141.53314f,70.91404f,105.17783f,141.53314f,67.24753f,105.27937f,141.53314f,67.18457f,109.316826f,141.53314f,64.56072f,109.445816f,141.53314f,64.51883f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,1,3,4,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 9, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
5,6,7,6,8,7,9,7,8,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 9, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID220(GL2 gl){
float[] positionsArray = {
131.82748f,166.03314f,69.34983f,134.5143f,141.53314f,73.48882f,131.82748f,141.53314f,69.34983f,134.5143f,166.03314f,73.48882f,128.16098f,141.53314f,66.04727f,128.16098f,166.03314f,66.04727f,136.03831f,141.53314f,78.182175f,136.03831f,166.03314f,78.182175f,123.76463f,141.53314f,63.806202f,123.76463f,166.03314f,63.806202f,136.29565f,141.53314f,83.110054f,136.29565f,166.03314f,83.110054f,118.93806f,141.53314f,62.779354f,118.93806f,166.03314f,62.779354f,135.26881f,141.53314f,87.93663f,135.26881f,166.03314f,87.93663f,114.02976f,141.53314f,63.035686f,114.02976f,166.03314f,63.035686f,133.02774f,141.53314f,92.33297f,133.02774f,166.03314f,92.33297f,129.72519f,141.53314f,95.99948f,129.72519f,166.03314f,95.99948f,125.5862f,166.03314f,98.686295f,125.5862f,141.53314f,98.686295f,120.89284f,166.03314f,100.210304f,120.89284f,141.53314f,100.210304f,115.96496f,166.03314f,100.46766f,115.96496f,141.53314f,100.46766f,111.13839f,166.03314f,99.44081f,111.13839f,141.53314f,99.44081f,106.74204f,166.03314f,97.199745f,106.74204f,141.53314f,97.199745f,103.07553f,166.03314f,93.89719f,103.07553f,141.53314f,93.89719f,100.388725f,141.53314f,89.758194f,100.388725f,166.03314f,89.758194f,98.86471f,141.53314f,85.064835f,98.86471f,166.03314f,85.064835f,98.60736f,141.53314f,80.136955f,98.60736f,166.03314f,80.136955f,99.63421f,141.53314f,75.31039f,99.63421f,166.03314f,75.31039f,101.875275f,141.53314f,70.91404f,101.875275f,166.03314f,70.91404f,101.875275f,166.03314f,70.91404f,105.27937f,141.53314f,67.18457f,101.875275f,141.53314f,70.91404f,105.27937f,166.03314f,67.18457f,109.445816f,166.03314f,64.51883f,109.445816f,141.53314f,64.51883f,113.296585f,166.03314f,63.268425f,109.445816f,141.53314f,64.51883f,109.445816f,166.03314f,64.51883f,113.296585f,141.53314f,63.268425f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.9803922, 0.1960784, 1.0);
int[] indices = {
0,1,2,1,0,3,0,4,5,4,0,2,3,6,1,6,3,7,5,8,9,8,5,4,7,10,6,10,7,11,9,12,13,12,9,8,11,14,10,14,11,15,13,16,17,16,13,12,15,18,14,18,15,19,19,20,18,20,19,21,20,22,23,22,20,21,23,24,25,24,23,22,25,26,27,26,25,24,27,28,29,28,27,26,29,30,31,30,29,28,31,32,33,32,31,30,32,34,33,34,32,35,35,36,34,36,35,37,37,38,36,38,37,39,39,40,38,40,39,41,41,42,40,42,41,43,44,45,46,45,44,47,48,45,47,45,48,49,50,51,52,51,50,53,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 144, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID228(GL2 gl){
float[] positionsArray = {
114.02976f,166.03314f,63.035686f,123.76463f,166.03314f,63.806202f,118.93806f,166.03314f,62.779354f,113.296585f,166.03314f,63.268425f,109.445816f,166.03314f,64.51883f,128.16098f,166.03314f,66.04727f,105.27937f,166.03314f,67.18457f,131.82748f,166.03314f,69.34983f,101.875275f,166.03314f,70.91404f,134.5143f,166.03314f,73.48882f,99.63421f,166.03314f,75.31039f,136.03831f,166.03314f,78.182175f,98.60736f,166.03314f,80.136955f,136.29565f,166.03314f,83.110054f,98.86471f,166.03314f,85.064835f,135.26881f,166.03314f,87.93663f,100.388725f,166.03314f,89.758194f,133.02774f,166.03314f,92.33297f,103.07553f,166.03314f,93.89719f,129.72519f,166.03314f,95.99948f,106.74204f,166.03314f,97.199745f,125.5862f,166.03314f,98.686295f,111.13839f,166.03314f,99.44081f,120.89284f,166.03314f,100.210304f,115.96496f,166.03314f,100.46766f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,1,3,4,1,4,5,5,4,6,5,6,7,7,6,8,7,8,9,9,8,10,9,10,11,11,10,12,11,12,13,13,12,14,13,14,15,15,14,16,15,16,17,17,16,18,17,18,19,19,18,20,19,20,21,21,20,22,21,22,23,23,22,24,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 69, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID236(GL2 gl){
float[] positionsArray = {
107.58137f,113.318f,27.375f,107.45769f,109.34058f,27.375f,107.257706f,111.33743f,27.375f,108.16768f,107.46353f,27.375f,108.4066f,115.147316f,27.375f,109.339294f,105.8342f,27.375f,109.677185f,116.700714f,27.375f,110.892685f,104.56362f,27.375f,111.30652f,117.87233f,27.375f,112.722f,103.73838f,27.375f,113.18357f,118.58231f,27.375f,114.70257f,103.41473f,27.375f,115.18042f,118.782295f,27.375f,116.699425f,103.6147f,27.375f,117.16099f,118.45864f,27.375f,118.57647f,104.32469f,27.375f,118.9903f,117.6334f,27.375f,120.2058f,105.49631f,27.375f,120.5437f,116.36282f,27.375f,121.47639f,107.0497f,27.375f,121.71531f,114.73349f,27.375f,122.30162f,108.87901f,27.375f,122.4253f,112.85644f,27.375f,122.62528f,110.85958f,27.375f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,0,4,3,4,5,5,4,6,5,6,7,7,6,8,7,8,9,9,8,10,9,10,11,11,10,12,11,12,13,13,12,14,13,14,15,15,14,16,15,16,17,17,16,18,17,18,19,19,18,20,19,20,21,21,20,22,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID242(GL2 gl){
float[] positionsArray = {
107.45769f,109.34058f,69.9375f,107.58137f,113.318f,69.9375f,107.257706f,111.33743f,69.9375f,108.16768f,107.46353f,69.9375f,108.4066f,115.147316f,69.9375f,109.339294f,105.8342f,69.9375f,109.677185f,116.700714f,69.9375f,110.892685f,104.56362f,69.9375f,111.30652f,117.87233f,69.9375f,112.722f,103.73838f,69.9375f,113.18357f,118.58231f,69.9375f,114.70257f,103.41473f,69.9375f,115.18042f,118.782295f,69.9375f,116.699425f,103.6147f,69.9375f,117.16099f,118.45864f,69.9375f,118.57647f,104.32469f,69.9375f,118.9903f,117.6334f,69.9375f,120.2058f,105.49631f,69.9375f,120.5437f,116.36282f,69.9375f,121.47639f,107.0497f,69.9375f,121.71531f,114.73349f,69.9375f,122.30162f,108.87901f,69.9375f,122.4253f,112.85644f,69.9375f,122.62528f,110.85958f,69.9375f,122.62528f,110.85958f,69.9375f,122.30162f,108.87901f,69.9375f,122.4253f,112.85644f,69.9375f,121.71531f,114.73349f,69.9375f,121.47639f,107.0497f,69.9375f,120.5437f,116.36282f,69.9375f,120.2058f,105.49631f,69.9375f,118.9903f,117.6334f,69.9375f,118.57647f,104.32469f,69.9375f,117.16099f,118.45864f,69.9375f,116.699425f,103.6147f,69.9375f,115.18042f,118.782295f,69.9375f,114.70257f,103.41473f,69.9375f,113.18357f,118.58231f,69.9375f,112.722f,103.73838f,69.9375f,111.30652f,117.87233f,69.9375f,110.892685f,104.56362f,69.9375f,109.677185f,116.700714f,69.9375f,109.339294f,105.8342f,69.9375f,108.4066f,115.147316f,69.9375f,108.16768f,107.46353f,69.9375f,107.58137f,113.318f,69.9375f,107.45769f,109.34058f,69.9375f,107.257706f,111.33743f,69.9375f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,1,3,4,4,3,5,4,5,6,6,5,7,6,7,8,8,7,9,8,9,10,10,9,11,10,11,12,12,11,13,12,13,14,14,13,15,14,15,16,16,15,17,16,17,18,18,17,19,18,19,20,20,19,21,20,21,22,22,21,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
24,25,26,26,25,27,25,28,27,27,28,29,28,30,29,29,30,31,30,32,31,31,32,33,32,34,33,33,34,35,34,36,35,35,36,37,36,38,37,37,38,39,38,40,39,39,40,41,40,42,41,41,42,43,42,44,43,43,44,45,44,46,45,47,45,46,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID248(GL2 gl){
float[] positionsArray = {
109.677185f,116.700714f,69.9375f,111.30652f,117.87233f,27.375f,109.677185f,116.700714f,27.375f,111.30652f,117.87233f,69.9375f,108.4066f,115.147316f,27.375f,108.4066f,115.147316f,69.9375f,113.18357f,118.58231f,27.375f,113.18357f,118.58231f,69.9375f,107.58137f,113.318f,27.375f,107.58137f,113.318f,69.9375f,115.18042f,118.782295f,27.375f,115.18042f,118.782295f,69.9375f,107.257706f,111.33743f,27.375f,107.257706f,111.33743f,69.9375f,117.16099f,118.45864f,27.375f,117.16099f,118.45864f,69.9375f,107.45769f,109.34058f,27.375f,107.45769f,109.34058f,69.9375f,118.9903f,117.6334f,27.375f,118.9903f,117.6334f,69.9375f,108.16768f,107.46353f,27.375f,108.16768f,107.46353f,69.9375f,120.5437f,116.36282f,27.375f,120.5437f,116.36282f,69.9375f,109.339294f,105.8342f,27.375f,109.339294f,105.8342f,69.9375f,121.71531f,114.73349f,69.9375f,121.71531f,114.73349f,27.375f,110.892685f,104.56362f,69.9375f,110.892685f,104.56362f,27.375f,122.4253f,112.85644f,69.9375f,122.4253f,112.85644f,27.375f,112.722f,103.73838f,69.9375f,112.722f,103.73838f,27.375f,122.62528f,110.85958f,69.9375f,122.62528f,110.85958f,27.375f,114.70257f,103.41473f,69.9375f,114.70257f,103.41473f,27.375f,122.30162f,108.87901f,69.9375f,122.30162f,108.87901f,27.375f,116.699425f,103.6147f,69.9375f,116.699425f,103.6147f,27.375f,121.47639f,107.0497f,69.9375f,121.47639f,107.0497f,27.375f,118.57647f,104.32469f,69.9375f,118.57647f,104.32469f,27.375f,120.2058f,105.49631f,69.9375f,120.2058f,105.49631f,27.375f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.227451, 0.054902, 1.0);
int[] indices = {
0,1,2,1,0,3,0,4,5,4,0,2,3,6,1,6,3,7,5,8,9,8,5,4,7,10,6,10,7,11,9,12,13,12,9,8,11,14,10,14,11,15,13,16,17,16,13,12,15,18,14,18,15,19,17,20,21,20,17,16,19,22,18,22,19,23,21,24,25,24,21,20,22,26,27,26,22,23,28,24,29,24,28,25,27,30,31,30,27,26,32,29,33,29,32,28,31,34,35,34,31,30,36,33,37,33,36,32,35,38,39,38,35,34,40,37,41,37,40,36,39,42,43,42,39,38,44,41,45,41,44,40,43,46,47,46,43,42,46,45,47,45,46,44,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 144, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID254(GL2 gl){
float[] positionsArray = {
107.024475f,44.28013f,72.5625f,106.88741f,42.098118f,11.1875f,106.88741f,42.098118f,72.5625f,107.024475f,44.28013f,11.1875f,107.31976f,39.95498f,11.1875f,107.31976f,39.95498f,72.5625f,107.72162f,46.352318f,72.5625f,107.72162f,46.352318f,11.1875f,108.29207f,37.99677f,11.1875f,108.29207f,37.99677f,72.5625f,108.93133f,48.173462f,72.5625f,108.93133f,48.173462f,11.1875f,109.73807f,36.356934f,11.1875f,109.73807f,36.356934f,72.5625f,110.57116f,49.61946f,11.1875f,110.57116f,49.61946f,72.5625f,111.55921f,35.147224f,72.5625f,111.55921f,35.147224f,11.1875f,112.52937f,50.591766f,11.1875f,112.52937f,50.591766f,72.5625f,113.6314f,34.450085f,72.5625f,113.6314f,34.450085f,11.1875f,114.67251f,51.02412f,11.1875f,114.67251f,51.02412f,72.5625f,115.813416f,34.31302f,72.5625f,115.813416f,34.31302f,11.1875f,116.85452f,50.887054f,11.1875f,116.85452f,50.887054f,72.5625f,117.95655f,34.745373f,72.5625f,117.95655f,34.745373f,11.1875f,118.92671f,50.189915f,11.1875f,118.92671f,50.189915f,72.5625f,119.914764f,35.717678f,72.5625f,119.914764f,35.717678f,11.1875f,120.747856f,48.980206f,11.1875f,120.747856f,48.980206f,72.5625f,121.554596f,37.163673f,72.5625f,121.554596f,37.163673f,11.1875f,122.193855f,47.34037f,72.5625f,122.193855f,47.34037f,11.1875f,122.764305f,38.98482f,11.1875f,122.764305f,38.98482f,72.5625f,123.16616f,45.38216f,72.5625f,123.16616f,45.38216f,11.1875f,123.46145f,41.057007f,11.1875f,123.46145f,41.057007f,72.5625f,123.59851f,43.23902f,72.5625f,123.59851f,43.23902f,11.1875f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.227451, 0.054902, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,9,12,13,12,9,8,10,14,11,14,10,15,16,12,17,12,16,13,15,18,14,18,15,19,20,17,21,17,20,16,19,22,18,22,19,23,24,21,25,21,24,20,23,26,22,26,23,27,28,25,29,25,28,24,27,30,26,30,27,31,32,29,33,29,32,28,31,34,30,34,31,35,36,33,37,33,36,32,34,38,39,38,34,35,40,36,37,36,40,41,39,42,43,42,39,38,44,41,40,41,44,45,43,46,47,46,43,42,47,45,44,45,47,46,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 144, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID260(GL2 gl){
float[] positionsArray = {
107.024475f,44.28013f,11.1875f,107.31976f,39.95498f,11.1875f,106.88741f,42.098118f,11.1875f,107.72162f,46.352318f,11.1875f,108.29207f,37.99677f,11.1875f,108.93133f,48.173462f,11.1875f,109.73807f,36.356934f,11.1875f,110.57116f,49.61946f,11.1875f,111.55921f,35.147224f,11.1875f,112.52937f,50.591766f,11.1875f,113.6314f,34.450085f,11.1875f,114.67251f,51.02412f,11.1875f,115.813416f,34.31302f,11.1875f,116.85452f,50.887054f,11.1875f,117.95655f,34.745373f,11.1875f,118.92671f,50.189915f,11.1875f,119.914764f,35.717678f,11.1875f,120.747856f,48.980206f,11.1875f,121.554596f,37.163673f,11.1875f,122.193855f,47.34037f,11.1875f,122.764305f,38.98482f,11.1875f,123.16616f,45.38216f,11.1875f,123.46145f,41.057007f,11.1875f,123.59851f,43.23902f,11.1875f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,1,3,4,4,3,5,4,5,6,6,5,7,6,7,8,8,7,9,8,9,10,10,9,11,10,11,12,12,11,13,12,13,14,14,13,15,14,15,16,16,15,17,16,17,18,18,17,19,18,19,20,20,19,21,20,21,22,22,21,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID266(GL2 gl){
float[] positionsArray = {
107.31976f,39.95498f,72.5625f,107.024475f,44.28013f,72.5625f,106.88741f,42.098118f,72.5625f,107.72162f,46.352318f,72.5625f,108.29207f,37.99677f,72.5625f,108.93133f,48.173462f,72.5625f,109.73807f,36.356934f,72.5625f,110.57116f,49.61946f,72.5625f,111.55921f,35.147224f,72.5625f,112.52937f,50.591766f,72.5625f,113.6314f,34.450085f,72.5625f,114.67251f,51.02412f,72.5625f,115.813416f,34.31302f,72.5625f,116.85452f,50.887054f,72.5625f,117.95655f,34.745373f,72.5625f,118.92671f,50.189915f,72.5625f,119.914764f,35.717678f,72.5625f,120.747856f,48.980206f,72.5625f,121.554596f,37.163673f,72.5625f,122.193855f,47.34037f,72.5625f,122.764305f,38.98482f,72.5625f,123.16616f,45.38216f,72.5625f,123.46145f,41.057007f,72.5625f,123.59851f,43.23902f,72.5625f,123.59851f,43.23902f,72.5625f,123.46145f,41.057007f,72.5625f,123.16616f,45.38216f,72.5625f,122.764305f,38.98482f,72.5625f,122.193855f,47.34037f,72.5625f,121.554596f,37.163673f,72.5625f,120.747856f,48.980206f,72.5625f,119.914764f,35.717678f,72.5625f,118.92671f,50.189915f,72.5625f,117.95655f,34.745373f,72.5625f,116.85452f,50.887054f,72.5625f,115.813416f,34.31302f,72.5625f,114.67251f,51.02412f,72.5625f,113.6314f,34.450085f,72.5625f,112.52937f,50.591766f,72.5625f,111.55921f,35.147224f,72.5625f,110.57116f,49.61946f,72.5625f,109.73807f,36.356934f,72.5625f,108.93133f,48.173462f,72.5625f,108.29207f,37.99677f,72.5625f,107.72162f,46.352318f,72.5625f,107.31976f,39.95498f,72.5625f,107.024475f,44.28013f,72.5625f,106.88741f,42.098118f,72.5625f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,0,4,3,4,5,5,4,6,5,6,7,7,6,8,7,8,9,9,8,10,9,10,11,11,10,12,11,12,13,13,12,14,13,14,15,15,14,16,15,16,17,17,16,18,17,18,19,19,18,20,19,20,21,21,20,22,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
{
gl.glColor4d(0.6705882, 0.6901961, 0.8, 1.0);
int[] indices = {
24,25,26,25,27,26,26,27,28,27,29,28,28,29,30,29,31,30,30,31,32,31,33,32,32,33,34,33,35,34,34,35,36,35,37,36,36,37,38,37,39,38,38,39,40,39,41,40,40,41,42,41,43,42,42,43,44,43,45,44,44,45,46,47,46,45,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
}
