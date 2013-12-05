package Multiplayer;
import java.net.*;
import java.util.StringTokenizer;
import java.io.*;

public class GameServer { 
	public static final int PORT = 9189;  
	public static final String HOST = "localhost"; //will change 
	public static final int playerNumber = 2; 
	
	public static void main(String[] args) throws IOException {
		DatagramSocket socket; 
		socket = new DatagramSocket(PORT); //master datagram socket
		byte[] buf = new byte[256];
		boolean listening = true;
		GameServerTable S = new GameServerTable(playerNumber); 
		String inputLine; 
		String outputLine = ""; 
		String playerID = ""; 
//		float newX = 0; 
//		float newY = 0; 
//		float newZ = 0; 
		
		while (listening) {
			DatagramPacket inpacket = new DatagramPacket(buf, buf.length);
			socket.receive(inpacket); //block and wait for client datagram packet
			inputLine = new String(inpacket.getData());
			System.out.println(inputLine);
			StringTokenizer st = new StringTokenizer(inputLine, ":"); 
		
				playerID = st.nextToken(); 
//				System.out.println(playerID);
//				System.out.println("'"+Float.parseFloat(st.nextToken())+"'");
//				System.out.println(Float.parseFloat(st.nextToken()));
//				System.out.println(Float.parseFloat(st.nextToken()));
			float newX = Float.parseFloat(st.nextToken()); 
			float newY = Float.parseFloat(st.nextToken());
			float newZ = Float.parseFloat(st.nextToken()); 
			System.out.println("Finished one");
		//	System.out.println("ID: "+ playerID + " X: "+newX+" Y: "+newY+" Z: "+newZ); 
		}
		socket.close();
	}
}