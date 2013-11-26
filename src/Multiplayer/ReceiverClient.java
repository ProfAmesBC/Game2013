package Multiplayer;

import game.BatsEverywhere;
import game.Player;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.StringTokenizer;

import javax.media.opengl.glu.GLU;
//this is a comment
public class ReceiverClient implements Runnable {
	private Player p1;
	private byte [] inbuf = new byte[1024];
	private GLU glu2;
	
	public ReceiverClient(Player play1, GLU glu) {
		p1 = play1;
		glu2 = glu;
	}
	
	public void run() {
		try {
			DatagramSocket sock = new DatagramSocket();
			while(true) {
				DatagramPacket indata = new DatagramPacket(inbuf,inbuf.length);
				sock.receive(indata);
				String incoming = new String(indata.getData());
				StringTokenizer tk = new StringTokenizer(new String(incoming));
				Integer id = new Integer(Integer.parseInt(tk.nextToken()));
				
				if (BatsEverywhere.getPlayers().get(id) != null) {
					BatsEverywhere.getPlayers().put(id, new Player(glu2, id));
				}
				Player toUpdate = BatsEverywhere.getPlayers().get(id);
				
				toUpdate.setX(Float.parseFloat(tk.nextToken()));
				toUpdate.setY(Float.parseFloat(tk.nextToken()));
				toUpdate.setZ(Float.parseFloat(tk.nextToken()));
				
				BatsEverywhere.getSem().release();
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//TO DO ADD This later
	//public void playerMoved(float x, float y, float z, float angle) {
		//p1.setX(x); p1.setY(y); p1.setZ(z);// p1.setAngle(angle);
	//}
	
//	public static void main(String [] args) throws UnknownHostException {
//		Client c = new Client(p1,InetAddress.getByName("136.167.251.84"), 9189);
//		c.run();
//	}
}