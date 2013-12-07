package Multiplayer;
import java.net.*;

public class GameServer { 
	public static final int PORT = 9189;  

	public static final String HOST = "136.167.251.10"; //will change 
	private MulticastSocket mcastSocket;
	private int MCAST_PORT = 20000;
	private InetAddress group; 

	public static void main(String[] args) throws Exception {
		GameServer G = new GameServer(); 
		DatagramSocket socket; 
		socket = new DatagramSocket(PORT); //master datagram socket
		G.mcastSocket = new MulticastSocket(G.MCAST_PORT);
		G.group = InetAddress.getByName("234.1.2.3"); 
		byte[] buf = new byte[256];
		boolean listening = true;
		GameServerTable S = new GameServerTable(); 
		String inputLine; 
		String outputLine = ""; 
		
		//System.out.println("Starting Chat Thread");
		MCastChatThread MCC = new MCastChatThread(); 
		Thread MCCT = new Thread(MCC); 
		MCCT.start(); 
		
		G.joinGroup();

		while (listening) {
			DatagramPacket inpacket = new DatagramPacket(buf, buf.length);
			socket.receive(inpacket); //block and wait for client datagram packet
			inputLine = new String(inpacket.getData());

			System.out.println(inputLine);
			G.sendToSocket(inputLine); 
		}
		socket.close();
	}
	public void joinGroup() throws Exception {
		mcastSocket.joinGroup(group);
	}

	public void leaveGroup() throws Exception {
		mcastSocket.leaveGroup(group);
		mcastSocket.close();
	}

	public void sendToSocket(String msg) throws Exception{
		/* remember to convert keyboard input (in msg) to bytes */
		DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, MCAST_PORT);
		mcastSocket.send(sendPacket);
	}

	public String readFromSocket() throws Exception{
		String socketString = null; /* string from socket */

		// get their responses!
		//byte[] buf is a byte array from the socket
		byte[] buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		mcastSocket.receive(recv);
		socketString = new String(recv.getData(), 0, recv.getLength());
		return 	socketString;	
	}
	public void sendToTerminal(String msg) throws Exception{
		System.out.println("Multicast text: " + msg);
	}
}
