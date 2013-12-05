package Multiplayer;

import game.BatsEverywhere;
import game.Player;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.StringTokenizer;

import javax.media.opengl.glu.GLU;
//this is a comment
public class ReceiverClient implements Runnable {
	private Player p1;
	private byte [] inbuf = new byte[1024];
	private GLU glu2;
	private MulticastSocket msock;
	
	public ReceiverClient(Player play1, GLU glu) {
		p1 = play1;
		glu2 = glu;
		try {
			msock = new MulticastSocket(20000);
			msock.joinGroup(InetAddress.getByName("234.1.2.3"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void run() {
		try {
			while(true) {
				DatagramPacket indata = new DatagramPacket(inbuf,inbuf.length);
				msock.receive(indata);
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
}