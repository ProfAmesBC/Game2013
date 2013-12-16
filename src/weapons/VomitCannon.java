B

package weapons;
import com.jogamp.opengl.util.GLBuffers;

import game.PlayerStats;

import javax.media.opengl.GL2;
import javax.media.opengl.glu.GLU;

import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.HashMap;
import java.util.Map;
public class VomitCannon extends Projectile
{
private int displayList = -1;
private Map<String, com.jogamp.opengl.util.texture.Texture> imageMap = new HashMap<String, com.jogamp.opengl.util.texture.Texture>(); // map of ID's to textures
public VomitCannon(float x, float y, float z, float angle, float y_angle,PlayerStats s){
	super(s);
	setProjX(x);
	setProjY(y);
	setProjZ(z);
	setProjAngle(angle);
    setProjYAngle(y_angle);
    
}
private int count = 0;
private int angle = 0;
public void draw(GL2 gl, GLU glu) {
	
	gl.glClearColor(0,1,0,1);
	for (int i = 0; i < 10; i++)
		{
		//gl.glClear(GL_COLOR_BUFFER_BIT);
		}
	if(count == 0){
	generate(gl, glu);}
	gl.glPushMatrix();
	gl.glTranslatef(getProjX(), getProjY(), getProjZ());
	gl.glScaled(0.3, 0.3, 0.3);
	gl.glRotated(angle+=20, 0, 1, 0);
	gl.glCallList(displayList);
	gl.glPopMatrix();
  count++;
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
ID2(gl);
ID10(gl);
ID18(gl);
ID26(gl);
ID34(gl);
ID42(gl);
ID50(gl);
ID58(gl);
ID66(gl);
ID74(gl);
ID80(gl);
ID86(gl);
ID92(gl);
ID98(gl);
ID104(gl);
ID112(gl);
ID120(gl);
ID128(gl);
ID134(gl);
ID140(gl);
ID146(gl);
ID152(gl);
ID158(gl);
ID164(gl);
       gl.glPopMatrix();
   gl.glPopAttrib();
gl.glEndList();
}
//Trailer


private void ID2(GL2 gl){
float[] positionsArray = {
87.35411f,-19.21146f,-8.845898f,96.0677f,-34.303844f,7.393655f,89.341064f,-34.303844f,-8.845898f,93.85155f,-17.470478f,7.393655f,77.01818f,-21.980965f,-22.791117f,78.64052f,-34.303844f,-22.791117f,98.36204f,-34.303844f,24.82084f,96.0677f,-16.876661f,24.82084f,64.6953f,-34.303844f,-33.49166f,63.548134f,-25.590254f,-33.49166f,96.0677f,-34.303844f,42.248028f,93.85155f,-17.470478f,42.248028f,48.455746f,-34.303844f,-40.218304f,47.86193f,-29.793358f,-40.218304f,89.341064f,-34.303844f,58.48758f,87.35411f,-19.21146f,58.48758f,31.028563f,-34.303844f,-42.512634f,78.64052f,-34.303844f,72.4328f,77.01818f,-21.980965f,72.4328f,64.6953f,-34.303844f,83.13334f,63.548134f,-25.590254f,83.13334f,48.455746f,-34.303844f,89.859985f,47.86193f,-29.793358f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.3960784, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,2,5,2,4,0,3,6,1,6,3,7,4,8,9,8,4,5,7,10,6,10,7,11,9,12,13,12,9,8,11,14,10,14,11,15,12,16,13,15,17,14,17,15,18,19,18,20,18,19,17,21,20,22,20,21,19,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID10(GL2 gl){
float[] positionsArray = {
78.64052f,-81.9158f,24.82084f,63.548134f,-90.629395f,7.393655f,77.01818f,-80.293465f,7.393655f,64.6953f,-92.61635f,24.82084f,60.18481f,-84.803955f,-8.845898f,72.26173f,-75.53701f,-8.845898f,77.01818f,-80.293465f,42.248028f,63.548134f,-90.629395f,42.248028f,54.83454f,-75.53701f,-22.791117f,64.6953f,-67.97058f,-22.791117f,72.26173f,-75.53701f,58.48758f,60.18481f,-84.803955f,58.48758f,54.83454f,-58.109825f,-33.49166f,47.86193f,-63.460094f,-33.49166f,64.6953f,-67.97058f,72.4328f,54.83454f,-75.53701f,72.4328f,43.351444f,-46.626728f,-40.218304f,39.742153f,-49.396233f,-40.218304f,54.83454f,-58.109825f,83.13334f,47.86193f,-63.460094f,83.13334f,31.028563f,-34.303844f,-42.512634f,43.351444f,-46.626728f,89.859985f,39.742153f,-49.396233f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.7490196, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,12,8,13,8,12,9,14,11,10,11,14,15,16,13,17,13,16,12,15,18,19,18,15,14,16,17,20,19,21,22,21,19,18,21,23,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID18(GL2 gl){
float[] positionsArray = {
64.6953f,-92.61635f,24.82084f,47.86193f,-97.12683f,7.393655f,63.548134f,-90.629395f,7.393655f,48.455746f,-99.34299f,24.82084f,46.12095f,-90.629395f,-8.845898f,60.18481f,-84.803955f,-8.845898f,63.548134f,-90.629395f,42.248028f,47.86193f,-97.12683f,42.248028f,43.351444f,-80.293465f,-22.791117f,54.83454f,-75.53701f,-22.791117f,60.18481f,-84.803955f,58.48758f,46.12095f,-90.629395f,58.48758f,47.86193f,-63.460094f,-33.49166f,39.742153f,-66.82342f,-33.49166f,54.83454f,-75.53701f,72.4328f,43.351444f,-80.293465f,72.4328f,39.742153f,-49.396233f,-40.218304f,35.53905f,-51.137215f,-40.218304f,47.86193f,-63.460094f,83.13334f,39.742153f,-66.82342f,83.13334f,31.028563f,-34.303844f,-42.512634f,39.742153f,-49.396233f,89.859985f,35.53905f,-51.137215f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.4980392, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,12,8,13,8,12,9,14,11,10,11,14,15,16,13,17,13,16,12,15,18,19,18,15,14,16,17,20,19,21,22,21,19,18,21,23,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID26(GL2 gl){
float[] positionsArray = {
48.455746f,-99.34299f,24.82084f,31.028563f,-99.34299f,7.393655f,47.86193f,-97.12683f,7.393655f,31.028563f,-101.63732f,24.82084f,31.028563f,-92.61635f,-8.845898f,46.12095f,-90.629395f,-8.845898f,47.86193f,-97.12683f,42.248028f,31.028563f,-99.34299f,42.248028f,31.028563f,-81.9158f,-22.791117f,43.351444f,-80.293465f,-22.791117f,46.12095f,-90.629395f,58.48758f,31.028563f,-92.61635f,58.48758f,31.028563f,-67.97058f,-33.49166f,39.742153f,-66.82342f,-33.49166f,43.351444f,-80.293465f,72.4328f,31.028563f,-81.9158f,72.4328f,31.028563f,-51.731033f,-40.218304f,35.53905f,-51.137215f,-40.218304f,31.028563f,-67.97058f,83.13334f,39.742153f,-66.82342f,83.13334f,31.028563f,-34.303844f,-42.512634f,31.028563f,-51.731033f,89.859985f,35.53905f,-51.137215f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.1960784, 0.1960784, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,13,16,17,14,18,15,18,14,19,17,16,20,19,21,18,21,19,22,22,23,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID34(GL2 gl){
float[] positionsArray = {
31.028563f,-101.63732f,24.82084f,14.195193f,-97.12683f,7.393655f,31.028563f,-99.34299f,7.393655f,13.601377f,-99.34299f,24.82084f,15.936176f,-90.629395f,-8.845898f,31.028563f,-92.61635f,-8.845898f,31.028563f,-99.34299f,42.248028f,14.195193f,-97.12683f,42.248028f,18.70568f,-80.293465f,-22.791117f,31.028563f,-81.9158f,-22.791117f,31.028563f,-92.61635f,58.48758f,15.936176f,-90.629395f,58.48758f,22.314968f,-66.82342f,-33.49166f,31.028563f,-67.97058f,-33.49166f,31.028563f,-81.9158f,72.4328f,18.70568f,-80.293465f,72.4328f,26.518074f,-51.137215f,-40.218304f,31.028563f,-51.731033f,-40.218304f,22.314968f,-66.82342f,83.13334f,31.028563f,-67.97058f,83.13334f,31.028563f,-34.303844f,-42.512634f,26.518074f,-51.137215f,89.859985f,31.028563f,-51.731033f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.6, 0.8, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,13,16,17,14,18,15,18,14,19,17,16,20,19,21,18,21,19,22,22,23,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID42(GL2 gl){
float[] positionsArray = {
13.601377f,-99.34299f,24.82084f,-1.4910095f,-90.629395f,7.393655f,14.195193f,-97.12683f,7.393655f,-2.6381757f,-92.61635f,24.82084f,1.8723118f,-84.803955f,-8.845898f,15.936176f,-90.629395f,-8.845898f,14.195193f,-97.12683f,42.248028f,-1.4910095f,-90.629395f,42.248028f,7.2225833f,-75.53701f,-22.791117f,18.70568f,-80.293465f,-22.791117f,15.936176f,-90.629395f,58.48758f,1.8723118f,-84.803955f,58.48758f,14.195193f,-63.460094f,-33.49166f,22.314968f,-66.82342f,-33.49166f,18.70568f,-80.293465f,72.4328f,7.2225833f,-75.53701f,72.4328f,22.314968f,-49.396233f,-40.218304f,26.518074f,-51.137215f,-40.218304f,14.195193f,-63.460094f,83.13334f,22.314968f,-66.82342f,83.13334f,31.028563f,-34.303844f,-42.512634f,22.314968f,-49.396233f,89.859985f,26.518074f,-51.137215f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.0, 0.4980392, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,13,16,17,14,18,15,18,14,19,20,17,16,19,21,18,21,19,22,23,21,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID50(GL2 gl){
float[] positionsArray = {
81.52867f,-5.1475964f,-8.845898f,93.85155f,-17.470478f,7.393655f,87.35411f,-19.21146f,-8.845898f,87.35411f,-1.7842749f,7.393655f,72.26173f,-10.497868f,-22.791117f,77.01818f,-21.980965f,-22.791117f,96.0677f,-16.876661f,24.82084f,89.341064f,-0.6371086f,24.82084f,63.548134f,-25.590254f,-33.49166f,60.18481f,-17.470478f,-33.49166f,87.35411f,-1.7842749f,42.248028f,93.85155f,-17.470478f,42.248028f,47.86193f,-29.793358f,-40.218304f,46.12095f,-25.590254f,-40.218304f,81.52867f,-5.1475964f,58.48758f,87.35411f,-19.21146f,58.48758f,31.028563f,-34.303844f,-42.512634f,72.26173f,-10.497868f,72.4328f,77.01818f,-21.980965f,72.4328f,63.548134f,-25.590254f,83.13334f,60.18481f,-17.470478f,83.13334f,47.86193f,-29.793358f,89.859985f,46.12095f,-25.590254f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.3960784, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,2,5,2,4,0,3,6,1,6,3,7,4,8,9,8,4,5,6,10,11,10,6,7,9,12,13,12,9,8,11,14,15,14,11,10,12,16,13,15,17,18,17,15,14,19,17,20,17,19,18,21,20,22,20,21,19,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID58(GL2 gl){
float[] positionsArray = {
72.26173f,6.929318f,-8.845898f,87.35411f,-1.7842749f,7.393655f,81.52867f,-5.1475964f,-8.845898f,77.01818f,11.685773f,7.393655f,64.6953f,-0.6371086f,-22.791117f,72.26173f,-10.497868f,-22.791117f,89.341064f,-0.6371086f,24.82084f,78.64052f,13.30811f,24.82084f,60.18481f,-17.470478f,-33.49166f,54.83454f,-10.497868f,-33.49166f,77.01818f,11.685773f,42.248028f,87.35411f,-1.7842749f,42.248028f,46.12095f,-25.590254f,-40.218304f,43.351444f,-21.980965f,-40.218304f,72.26173f,6.929318f,58.48758f,81.52867f,-5.1475964f,58.48758f,31.028563f,-34.303844f,-42.512634f,64.6953f,-0.6371086f,72.4328f,72.26173f,-10.497868f,72.4328f,60.18481f,-17.470478f,83.13334f,54.83454f,-10.497868f,83.13334f,46.12095f,-25.590254f,89.859985f,43.351444f,-21.980965f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,2,5,2,4,0,3,6,1,6,3,7,4,8,9,8,4,5,6,10,11,10,6,7,9,12,13,12,9,8,11,14,15,14,11,10,12,16,13,15,17,18,17,15,14,19,17,20,17,19,18,21,20,22,20,21,19,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID66(GL2 gl){
float[] positionsArray = {
63.548134f,22.021704f,7.393655f,72.26173f,6.929318f,-8.845898f,60.18481f,16.19626f,-8.845898f,77.01818f,11.685773f,7.393655f,64.6953f,-0.6371086f,-22.791117f,54.83454f,6.929318f,-22.791117f,64.6953f,24.008654f,24.82084f,78.64052f,13.30811f,24.82084f,54.83454f,-10.497868f,-33.49166f,47.86193f,-5.1475964f,-33.49166f,63.548134f,22.021704f,42.248028f,77.01818f,11.685773f,42.248028f,43.351444f,-21.980965f,-40.218304f,39.742153f,-19.21146f,-40.218304f,60.18481f,16.19626f,58.48758f,72.26173f,6.929318f,58.48758f,31.028563f,-34.303844f,-42.512634f,54.83454f,6.929318f,72.4328f,64.6953f,-0.6371086f,72.4328f,54.83454f,-10.497868f,83.13334f,47.86193f,-5.1475964f,83.13334f,43.351444f,-21.980965f,89.859985f,39.742153f,-19.21146f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.6980392, 0.3960784, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,9,12,13,12,9,8,14,11,10,11,14,15,12,16,13,17,15,14,15,17,18,19,17,20,17,19,18,21,20,22,20,21,19,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID74(GL2 gl){
float[] positionsArray = {
47.86193f,28.519142f,7.393655f,60.18481f,16.19626f,-8.845898f,46.12095f,22.021704f,-8.845898f,63.548134f,22.021704f,7.393655f,54.83454f,6.929318f,-22.791117f,43.351444f,11.685773f,-22.791117f,48.455746f,30.735296f,24.82084f,64.6953f,24.008654f,24.82084f,47.86193f,-5.1475964f,-33.49166f,39.742153f,-1.7842749f,-33.49166f,47.86193f,28.519142f,42.248028f,63.548134f,22.021704f,42.248028f,39.742153f,-19.21146f,-40.218304f,35.53905f,-17.470478f,-40.218304f,46.12095f,22.021704f,58.48758f,60.18481f,16.19626f,58.48758f,31.028563f,-34.303844f,-42.512634f,43.351444f,11.685773f,72.4328f,54.83454f,6.929318f,72.4328f,47.86193f,-5.1475964f,83.13334f,39.742153f,-1.7842749f,83.13334f,39.742153f,-19.21146f,89.859985f,35.53905f,-17.470478f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.0, 0.4980392, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,5,8,9,8,5,4,10,7,6,7,10,11,9,12,13,12,9,8,14,11,10,11,14,15,12,16,13,17,15,14,15,17,18,19,17,20,17,19,18,21,20,22,20,21,19,21,22,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID80(GL2 gl){
float[] positionsArray = {
31.028563f,30.735296f,7.393655f,46.12095f,22.021704f,-8.845898f,31.028563f,24.008654f,-8.845898f,47.86193f,28.519142f,7.393655f,43.351444f,11.685773f,-22.791117f,31.028563f,13.30811f,-22.791117f,31.028563f,33.02963f,24.82084f,48.455746f,30.735296f,24.82084f,31.028563f,-0.6371086f,-33.49166f,39.742153f,-1.7842749f,-33.49166f,31.028563f,30.735296f,42.248028f,47.86193f,28.519142f,42.248028f,35.53905f,-17.470478f,-40.218304f,31.028563f,-16.876661f,-40.218304f,31.028563f,24.008654f,58.48758f,46.12095f,22.021704f,58.48758f,31.028563f,-34.303844f,-42.512634f,31.028563f,13.30811f,72.4328f,43.351444f,11.685773f,72.4328f,39.742153f,-1.7842749f,83.13334f,31.028563f,-0.6371086f,83.13334f,31.028563f,-16.876661f,89.859985f,35.53905f,-17.470478f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.6, 0.8, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,7,6,7,10,11,8,12,13,12,8,9,14,11,10,11,14,15,12,16,13,17,15,14,15,17,18,19,17,20,17,19,18,21,19,20,19,21,22,22,21,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID86(GL2 gl){
float[] positionsArray = {
14.195193f,28.519142f,7.393655f,31.028563f,24.008654f,-8.845898f,15.936176f,22.021704f,-8.845898f,31.028563f,30.735296f,7.393655f,31.028563f,13.30811f,-22.791117f,18.70568f,11.685773f,-22.791117f,13.601377f,30.735296f,24.82084f,31.028563f,33.02963f,24.82084f,22.314968f,-1.7842749f,-33.49166f,31.028563f,-0.6371086f,-33.49166f,14.195193f,28.519142f,42.248028f,31.028563f,30.735296f,42.248028f,26.518074f,-17.470478f,-40.218304f,31.028563f,-16.876661f,-40.218304f,15.936176f,22.021704f,58.48758f,31.028563f,24.008654f,58.48758f,31.028563f,-34.303844f,-42.512634f,18.70568f,11.685773f,72.4328f,31.028563f,13.30811f,72.4328f,22.314968f,-1.7842749f,83.13334f,31.028563f,-0.6371086f,83.13334f,26.518074f,-17.470478f,89.859985f,31.028563f,-16.876661f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.1960784, 0.1960784, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,7,6,7,10,11,9,12,8,12,9,13,14,11,10,11,14,15,16,12,13,17,15,14,15,17,18,19,18,17,18,19,20,21,20,19,20,21,22,22,21,23,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID92(GL2 gl){
float[] positionsArray = {
-1.4910095f,22.021704f,7.393655f,15.936176f,22.021704f,-8.845898f,1.8723118f,16.19626f,-8.845898f,14.195193f,28.519142f,7.393655f,18.70568f,11.685773f,-22.791117f,7.2225833f,6.929318f,-22.791117f,-2.6381757f,24.008654f,24.82084f,13.601377f,30.735296f,24.82084f,14.195193f,-5.1475964f,-33.49166f,22.314968f,-1.7842749f,-33.49166f,-1.4910095f,22.021704f,42.248028f,14.195193f,28.519142f,42.248028f,22.314968f,-19.21146f,-40.218304f,26.518074f,-17.470478f,-40.218304f,1.8723118f,16.19626f,58.48758f,15.936176f,22.021704f,58.48758f,31.028563f,-34.303844f,-42.512634f,7.2225833f,6.929318f,72.4328f,18.70568f,11.685773f,72.4328f,14.195193f,-5.1475964f,83.13334f,22.314968f,-1.7842749f,83.13334f,22.314968f,-19.21146f,89.859985f,26.518074f,-17.470478f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.4980392, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,7,6,7,10,11,9,12,8,12,9,13,14,11,10,11,14,15,16,12,13,17,15,14,15,17,18,19,18,17,18,19,20,21,20,19,20,21,22,23,22,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID98(GL2 gl){
float[] positionsArray = {
-14.961057f,11.685773f,7.393655f,1.8723118f,16.19626f,-8.845898f,-10.204602f,6.929318f,-8.845898f,-1.4910095f,22.021704f,7.393655f,7.2225833f,6.929318f,-22.791117f,-2.6381757f,-0.6371086f,-22.791117f,-16.583395f,13.30811f,24.82084f,-2.6381757f,24.008654f,24.82084f,7.2225833f,-10.497868f,-33.49166f,14.195193f,-5.1475964f,-33.49166f,-14.961057f,11.685773f,42.248028f,-1.4910095f,22.021704f,42.248028f,18.70568f,-21.980965f,-40.218304f,22.314968f,-19.21146f,-40.218304f,-10.204602f,6.929318f,58.48758f,1.8723118f,16.19626f,58.48758f,31.028563f,-34.303844f,-42.512634f,-2.6381757f,-0.6371086f,72.4328f,7.2225833f,6.929318f,72.4328f,7.2225833f,-10.497868f,83.13334f,14.195193f,-5.1475964f,83.13334f,18.70568f,-21.980965f,89.859985f,22.314968f,-19.21146f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.7490196, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,7,6,7,10,11,9,12,8,12,9,13,14,11,10,11,14,15,16,12,13,17,15,14,15,17,18,19,18,17,18,19,20,21,20,19,20,21,22,23,22,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID104(GL2 gl){
float[] positionsArray = {
-25.296988f,-1.7842749f,7.393655f,-10.204602f,6.929318f,-8.845898f,-19.471544f,-5.1475964f,-8.845898f,-14.961057f,11.685773f,7.393655f,-2.6381757f,-0.6371086f,-22.791117f,-10.204602f,-10.497868f,-22.791117f,-27.283937f,-0.6371086f,24.82084f,-16.583395f,13.30811f,24.82084f,1.8723118f,-17.470478f,-33.49166f,7.2225833f,-10.497868f,-33.49166f,-14.961057f,11.685773f,42.248028f,-25.296988f,-1.7842749f,42.248028f,15.936176f,-25.590254f,-40.218304f,18.70568f,-21.980965f,-40.218304f,-10.204602f,6.929318f,58.48758f,-19.471544f,-5.1475964f,58.48758f,31.028563f,-34.303844f,-42.512634f,-2.6381757f,-0.6371086f,72.4328f,-10.204602f,-10.497868f,72.4328f,1.8723118f,-17.470478f,83.13334f,7.2225833f,-10.497868f,83.13334f,15.936176f,-25.590254f,89.859985f,18.70568f,-21.980965f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,6,11,6,10,7,9,12,8,12,9,13,14,11,15,11,14,10,16,12,13,17,15,18,15,17,14,19,17,18,17,19,20,21,20,19,20,21,22,23,22,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID112(GL2 gl){
float[] positionsArray = {
-31.794426f,-17.470478f,7.393655f,-19.471544f,-5.1475964f,-8.845898f,-25.296988f,-19.21146f,-8.845898f,-25.296988f,-1.7842749f,7.393655f,-10.204602f,-10.497868f,-22.791117f,-14.961057f,-21.980965f,-22.791117f,-34.010582f,-16.876661f,24.82084f,-27.283937f,-0.6371086f,24.82084f,-1.4910095f,-25.590254f,-33.49166f,1.8723118f,-17.470478f,-33.49166f,-25.296988f,-1.7842749f,42.248028f,-31.794426f,-17.470478f,42.248028f,14.195193f,-29.793358f,-40.218304f,15.936176f,-25.590254f,-40.218304f,-19.471544f,-5.1475964f,58.48758f,-25.296988f,-19.21146f,58.48758f,31.028563f,-34.303844f,-42.512634f,-10.204602f,-10.497868f,72.4328f,-14.961057f,-21.980965f,72.4328f,-1.4910095f,-25.590254f,83.13334f,1.8723118f,-17.470478f,83.13334f,14.195193f,-29.793358f,89.859985f,15.936176f,-25.590254f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.4980392, 1.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,4,8,5,8,4,9,10,6,11,6,10,7,9,12,8,12,9,13,14,11,15,11,14,10,16,12,13,17,15,18,15,17,14,19,17,18,17,19,20,21,20,19,20,21,22,23,22,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID120(GL2 gl){
float[] positionsArray = {
-31.794426f,-17.470478f,7.393655f,-27.283937f,-34.303844f,-8.845898f,-34.010582f,-34.303844f,7.393655f,-25.296988f,-19.21146f,-8.845898f,-16.583395f,-34.303844f,-22.791117f,-14.961057f,-21.980965f,-22.791117f,-36.304913f,-34.303844f,24.82084f,-34.010582f,-16.876661f,24.82084f,-2.6381757f,-34.303844f,-33.49166f,-1.4910095f,-25.590254f,-33.49166f,-31.794426f,-17.470478f,42.248028f,-34.010582f,-34.303844f,42.248028f,13.601377f,-34.303844f,-40.218304f,14.195193f,-29.793358f,-40.218304f,-25.296988f,-19.21146f,58.48758f,-27.283937f,-34.303844f,58.48758f,31.028563f,-34.303844f,-42.512634f,-16.583395f,-34.303844f,72.4328f,-14.961057f,-21.980965f,72.4328f,-2.6381757f,-34.303844f,83.13334f,-1.4910095f,-25.590254f,83.13334f,13.601377f,-34.303844f,89.859985f,14.195193f,-29.793358f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.4, 0.8, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,4,1,4,3,5,6,0,2,0,6,7,5,8,4,8,5,9,10,6,11,6,10,7,9,12,8,12,9,13,14,11,15,11,14,10,16,12,13,17,14,15,14,17,18,19,18,17,18,19,20,21,20,19,20,21,22,23,22,21,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID128(GL2 gl){
float[] positionsArray = {
-34.010582f,-34.303844f,7.393655f,-25.296988f,-49.396233f,-8.845898f,-31.794426f,-51.137215f,7.393655f,-27.283937f,-34.303844f,-8.845898f,-14.961057f,-46.626728f,-22.791117f,-16.583395f,-34.303844f,-22.791117f,-36.304913f,-34.303844f,24.82084f,-34.010582f,-51.731033f,24.82084f,-2.6381757f,-34.303844f,-33.49166f,-1.4910095f,-43.01744f,-33.49166f,-31.794426f,-51.137215f,42.248028f,-34.010582f,-34.303844f,42.248028f,13.601377f,-34.303844f,-40.218304f,14.195193f,-38.814335f,-40.218304f,-25.296988f,-49.396233f,58.48758f,-27.283937f,-34.303844f,58.48758f,31.028563f,-34.303844f,-42.512634f,-14.961057f,-46.626728f,72.4328f,-16.583395f,-34.303844f,72.4328f,-2.6381757f,-34.303844f,83.13334f,-1.4910095f,-43.01744f,83.13334f,13.601377f,-34.303844f,89.859985f,14.195193f,-38.814335f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 0.3960784, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,4,1,4,3,5,6,2,7,2,6,0,8,4,5,4,8,9,10,6,7,6,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,17,15,14,15,17,18,17,19,18,19,17,20,20,21,19,21,20,22,23,21,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID134(GL2 gl){
float[] positionsArray = {
-31.794426f,-51.137215f,7.393655f,-19.471544f,-63.460094f,-8.845898f,-25.296988f,-66.82342f,7.393655f,-25.296988f,-49.396233f,-8.845898f,-10.204602f,-58.109825f,-22.791117f,-14.961057f,-46.626728f,-22.791117f,-34.010582f,-51.731033f,24.82084f,-27.283937f,-67.97058f,24.82084f,-1.4910095f,-43.01744f,-33.49166f,1.8723118f,-51.137215f,-33.49166f,-25.296988f,-66.82342f,42.248028f,-31.794426f,-51.137215f,42.248028f,14.195193f,-38.814335f,-40.218304f,15.936176f,-43.01744f,-40.218304f,-19.471544f,-63.460094f,58.48758f,-25.296988f,-49.396233f,58.48758f,31.028563f,-34.303844f,-42.512634f,-10.204602f,-58.109825f,72.4328f,-14.961057f,-46.626728f,72.4328f,-1.4910095f,-43.01744f,83.13334f,1.8723118f,-51.137215f,83.13334f,14.195193f,-38.814335f,89.859985f,15.936176f,-43.01744f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.3960784, 1.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,4,1,4,3,5,6,2,7,2,6,0,8,4,5,4,8,9,10,6,7,6,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,17,15,14,15,17,18,17,19,18,19,17,20,20,21,19,21,20,22,23,21,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID140(GL2 gl){
float[] positionsArray = {
-25.296988f,-66.82342f,7.393655f,-10.204602f,-75.53701f,-8.845898f,-14.961057f,-80.293465f,7.393655f,-19.471544f,-63.460094f,-8.845898f,-2.6381757f,-67.97058f,-22.791117f,-10.204602f,-58.109825f,-22.791117f,-27.283937f,-67.97058f,24.82084f,-16.583395f,-81.9158f,24.82084f,1.8723118f,-51.137215f,-33.49166f,7.2225833f,-58.109825f,-33.49166f,-14.961057f,-80.293465f,42.248028f,-25.296988f,-66.82342f,42.248028f,15.936176f,-43.01744f,-40.218304f,18.70568f,-46.626728f,-40.218304f,-10.204602f,-75.53701f,58.48758f,-19.471544f,-63.460094f,58.48758f,31.028563f,-34.303844f,-42.512634f,-2.6381757f,-67.97058f,72.4328f,-10.204602f,-58.109825f,72.4328f,1.8723118f,-51.137215f,83.13334f,7.2225833f,-58.109825f,83.13334f,15.936176f,-43.01744f,89.859985f,18.70568f,-46.626728f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.0, 0.0, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,3,4,1,4,3,5,6,2,7,2,6,0,8,4,5,4,8,9,10,6,7,6,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,17,15,14,15,17,18,17,19,18,19,17,20,20,21,19,21,20,22,23,21,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID146(GL2 gl){
float[] positionsArray = {
-1.4910095f,-90.629395f,7.393655f,-10.204602f,-75.53701f,-8.845898f,1.8723118f,-84.803955f,-8.845898f,-14.961057f,-80.293465f,7.393655f,-2.6381757f,-67.97058f,-22.791117f,7.2225833f,-75.53701f,-22.791117f,-2.6381757f,-92.61635f,24.82084f,-16.583395f,-81.9158f,24.82084f,7.2225833f,-58.109825f,-33.49166f,14.195193f,-63.460094f,-33.49166f,-1.4910095f,-90.629395f,42.248028f,-14.961057f,-80.293465f,42.248028f,18.70568f,-46.626728f,-40.218304f,22.314968f,-49.396233f,-40.218304f,1.8723118f,-84.803955f,58.48758f,-10.204602f,-75.53701f,58.48758f,31.028563f,-34.303844f,-42.512634f,7.2225833f,-75.53701f,72.4328f,-2.6381757f,-67.97058f,72.4328f,7.2225833f,-58.109825f,83.13334f,14.195193f,-63.460094f,83.13334f,18.70568f,-46.626728f,89.859985f,22.314968f,-49.396233f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.6980392, 0.3960784, 1.0, 1.0);
int[] indices = {
0,1,2,1,0,3,2,4,5,4,2,1,6,3,0,3,6,7,8,5,4,5,8,9,10,7,6,7,10,11,12,9,8,9,12,13,14,11,10,11,14,15,16,13,12,17,15,14,15,17,18,17,19,18,19,17,20,20,21,19,21,20,22,23,21,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID152(GL2 gl){
float[] positionsArray = {
72.26173f,-75.53701f,-8.845898f,87.35411f,-66.82342f,7.393655f,77.01818f,-80.293465f,7.393655f,81.52867f,-63.460094f,-8.845898f,64.6953f,-67.97058f,-22.791117f,72.26173f,-58.109825f,-22.791117f,89.341064f,-67.97058f,24.82084f,78.64052f,-81.9158f,24.82084f,60.18481f,-51.137215f,-33.49166f,54.83454f,-58.109825f,-33.49166f,77.01818f,-80.293465f,42.248028f,87.35411f,-66.82342f,42.248028f,46.12095f,-43.01744f,-40.218304f,43.351444f,-46.626728f,-40.218304f,72.26173f,-75.53701f,58.48758f,81.52867f,-63.460094f,58.48758f,31.028563f,-34.303844f,-42.512634f,64.6953f,-67.97058f,72.4328f,72.26173f,-58.109825f,72.4328f,60.18481f,-51.137215f,83.13334f,54.83454f,-58.109825f,83.13334f,46.12095f,-43.01744f,89.859985f,43.351444f,-46.626728f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(1.0, 1.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,3,0,3,4,5,2,6,7,6,2,1,8,4,9,4,8,5,6,10,7,10,6,11,12,9,13,9,12,8,11,14,10,14,11,15,12,13,16,15,17,14,17,15,18,17,19,20,19,17,18,20,21,22,21,20,19,21,23,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID158(GL2 gl){
float[] positionsArray = {
81.52867f,-63.460094f,-8.845898f,93.85155f,-51.137215f,7.393655f,87.35411f,-66.82342f,7.393655f,87.35411f,-49.396233f,-8.845898f,72.26173f,-58.109825f,-22.791117f,77.01818f,-46.626728f,-22.791117f,96.0677f,-51.731033f,24.82084f,89.341064f,-67.97058f,24.82084f,63.548134f,-43.01744f,-33.49166f,60.18481f,-51.137215f,-33.49166f,87.35411f,-66.82342f,42.248028f,93.85155f,-51.137215f,42.248028f,47.86193f,-38.814335f,-40.218304f,46.12095f,-43.01744f,-40.218304f,81.52867f,-63.460094f,58.48758f,87.35411f,-49.396233f,58.48758f,31.028563f,-34.303844f,-42.512634f,72.26173f,-58.109825f,72.4328f,77.01818f,-46.626728f,72.4328f,63.548134f,-43.01744f,83.13334f,60.18481f,-51.137215f,83.13334f,47.86193f,-38.814335f,89.859985f,46.12095f,-43.01744f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.4980392, 1.0, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,3,0,3,4,5,2,6,7,6,2,1,8,4,9,4,8,5,6,10,7,10,6,11,12,9,13,9,12,8,11,14,10,14,11,15,12,13,16,15,17,14,17,15,18,17,19,20,19,17,18,20,21,22,21,20,19,21,23,22,};
IntBuffer fbi = GLBuffers.newDirectIntBuffer(indices, 0);
gl.glDrawElements(GL2.GL_TRIANGLES, 66, GL2.GL_UNSIGNED_INT, fbi);
gl.glDisable(GL2.GL_TEXTURE_2D);
gl.glDisable(GL2.GL_BLEND);
}
gl.glDisableClientState(GL2.GL_VERTEX_ARRAY);
gl.glDisableClientState(GL2.GL_NORMAL_ARRAY);
gl.glDisableClientState(GL2.GL_TEXTURE_COORD_ARRAY);
}
private void ID164(GL2 gl){
float[] positionsArray = {
87.35411f,-49.396233f,-8.845898f,96.0677f,-34.303844f,7.393655f,93.85155f,-51.137215f,7.393655f,89.341064f,-34.303844f,-8.845898f,77.01818f,-46.626728f,-22.791117f,78.64052f,-34.303844f,-22.791117f,98.36204f,-34.303844f,24.82084f,96.0677f,-51.731033f,24.82084f,64.6953f,-34.303844f,-33.49166f,63.548134f,-43.01744f,-33.49166f,93.85155f,-51.137215f,42.248028f,96.0677f,-34.303844f,42.248028f,48.455746f,-34.303844f,-40.218304f,47.86193f,-38.814335f,-40.218304f,87.35411f,-49.396233f,58.48758f,89.341064f,-34.303844f,58.48758f,31.028563f,-34.303844f,-42.512634f,77.01818f,-46.626728f,72.4328f,78.64052f,-34.303844f,72.4328f,64.6953f,-34.303844f,83.13334f,63.548134f,-43.01744f,83.13334f,48.455746f,-34.303844f,89.859985f,47.86193f,-38.814335f,89.859985f,31.028563f,-34.303844f,92.15431f,};
FloatBuffer fbv = GLBuffers.newDirectFloatBuffer(positionsArray, 0);
gl.glVertexPointer(3, GL2.GL_FLOAT, 0, fbv);
gl.glEnableClientState(GL2.GL_VERTEX_ARRAY);
FloatBuffer fbn = null;
FloatBuffer fbt = null;
float[] texcoordArray = null;
{
gl.glColor4d(0.4, 0.8, 0.0, 1.0);
int[] indices = {
0,1,2,1,0,3,4,3,0,3,4,5,2,6,7,6,2,1,8,4,9,4,8,5,6,10,7,10,6,11,12,9,13,9,12,8,11,14,10,14,11,15,12,13,16,15,17,14,17,15,18,17,19,20,19,17,18,20,21,22,21,20,19,21,23,22,};
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
