package Multiplayer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;


public class ChatHandler implements ActionListener{
	private String outputLine; 
	private MulticastSocket socket;
	private final int MCAST_PORT = 21000;
	private int ttl = 64; /* time to live */
	private InetAddress group = InetAddress.getByName("224.3.4.5");

	public String playerName; 
	
	public ChatHandler(String playerName) throws Exception{
		this.playerName = playerName; 
		/* instantiate a MulticastSocket */
		this.socket = new MulticastSocket(MCAST_PORT);
		/* set the time to live */
		socket.setTimeToLive(ttl);
		joinGroup();
	}
	
	public void actionPerformed(ActionEvent e) {
		String msg = playerName + e.getActionCommand();
		try {
			sendToSocket(msg);
		} 
		catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	public void joinGroup() throws Exception {
		socket.joinGroup(group);
	}

	public void leaveGroup() throws Exception {
		socket.leaveGroup(group);
		socket.close();
	}

	public void sendToSocket(String msg) throws Exception{
		/* remember to convert keyboard input (in msg) to bytes */
		DatagramPacket sendPacket = new DatagramPacket(msg.getBytes(), msg.length(), group, MCAST_PORT);
		socket.send(sendPacket);
	}

	public String readFromSocket() throws Exception{
		String socketString = null; /* string from socket */

		// get their responses!
		//byte[] buf is a byte array from the socket
		byte[] buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		socket.receive(recv);
		socketString = new String(recv.getData(), 0, recv.getLength());
		return 	socketString;	
	}
	
	public void sendToTerminal(String msg) throws Exception{
		System.out.println("Multicast text: " + msg);
	}
}

