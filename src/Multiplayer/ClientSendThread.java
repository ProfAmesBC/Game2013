package Multiplayer;

//import GameServerTable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import game.*;

public class ClientSendThread implements PlayerMotionWatcher{
	private Player client; 
	public static final int PORT = 9189;  
	public static final String HOST = "localhost";  
	private DatagramSocket socket;
	private byte[] buf;

	public ClientSendThread(Player client) throws SocketException {
		this.client = client;
		PlayerMotion.registerPlayerWatcher(this);
		socket = new DatagramSocket();
		buf = new byte[256];
	}
	public void playerMoved(float x, float y, float z, float angle) {
		try {
			InetAddress address = InetAddress.getByName(HOST); 
			String outputLine = new String("");
			outputLine +=  client.getID()+":";
			outputLine += client.getX()+":";
			outputLine += client.getY()+":";
			outputLine += client.getZ()+":";

			buf = outputLine.getBytes();
			DatagramPacket outpacket = new DatagramPacket(buf, buf.length, address, PORT);
			System.out.println(new String(outpacket.getData()));
			socket.send(outpacket);
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
