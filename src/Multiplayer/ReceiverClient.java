package Multiplayer;

import game.Player;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.StringTokenizer;
//this is a comment
public class ReceiverClient implements Runnable, game.PlayerMotionWatcher {
	private Player p1;
	private byte [] inbuf = new byte[1024];
	private byte [] outbuf = new byte[1024];
	private InetAddress myAddr;
	private int port;
	
	public ReceiverClient(Player play1,InetAddress addr, int portno) {
		p1 = play1;
		myAddr = addr;
		port = portno;
		game.PlayerMotion.registerPlayerWatcher(this);
	}
	
	public void run() {
		try {
			DatagramSocket sock = new DatagramSocket();
			while(true) {
				//String send = 1+"\n"+p1.getX()+"\n"+p1.getY()+"\n"+p1.getZ();
				//String send = 1+"\n"+50+"\n"+80+"\n"+90;
				//DatagramPacket packet = new DatagramPacket(send.getBytes(), send.getBytes().length, myAddr, port);
			    //sock.send(packet);
				DatagramPacket indata = new DatagramPacket(inbuf,inbuf.length);
				sock.receive(indata);
				String incoming = new String(indata.getData());
				StringTokenizer tk = new StringTokenizer(new String(incoming));
				//p2.setX(Float.parseFloat(tk.nextToken()));
				//p2.setY(Float.parseFloat(tk.nextToken()));
				//p2.setZ(Float.parseFloat(tk.nextToken()));
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}	
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//TO DO ADD This later
	//public void playerMoved(float x, float y, float z, float angle) {
		//p1.setX(x); p1.setY(y); p1.setZ(z);// p1.setAngle(angle);
	//}

	@Override
	public void playerMoved(float x, float y, float z, float angle) {
		// TODO Auto-generated method stub
		
	}
	
//	public static void main(String [] args) throws UnknownHostException {
//		Client c = new Client(p1,InetAddress.getByName("136.167.251.84"), 9189);
//		c.run();
//	}
}