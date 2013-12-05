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
		GameServerTable S = new GameServerTable(); 
		String inputLine; 
		String outputLine = ""; 
		String playerID = ""; 
		double newX = 0; 
		double newY = 0; 
		double newZ = 0; 
		
		while (listening) {
			DatagramPacket inpacket = new DatagramPacket(buf, buf.length);
			socket.receive(inpacket); //block and wait for client datagram packet
			inputLine = new String(inpacket.getData());
			
			StringTokenizer st = new StringTokenizer(inputLine, ":"); 
			
			while(st.hasMoreTokens()){
				playerID = st.nextToken(); 
				newX = Float.parseFloat(st.nextToken()); 
				newY = Float.parseFloat(st.nextToken());
				newZ = Float.parseFloat(st.nextToken()); 
			}
			System.out.println("ID: "+ playerID + " X: "+newX+" Y: "+newY+" Z: "+newZ); 
		}
		socket.close();
	}
}
