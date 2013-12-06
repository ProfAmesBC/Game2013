package Multiplayer;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MCastChatThread implements Runnable{
	private MulticastSocket socket;
	private final int MCAST_PORT = 21000;
	private int ttl = 64; /* time to live */
	private InetAddress group = InetAddress.getByName("224.3.4.5"); 
	public boolean listening = true;
	public String inputLine; 
	public String newInputLine;
	public byte[] buf; 

	public MCastChatThread() throws Exception{
		/* instantiate a MulticastSocket */
		this.socket = new MulticastSocket(MCAST_PORT);
		/* set the time to live */
		socket.setTimeToLive(ttl);
		inputLine = ""; 
		buf = new byte[256];
		this.socket.setLoopbackMode(false); 
		joinGroup(); 
	}

	@Override
	public void run() {
		while (listening) {
			try {
				DatagramPacket inpacket = new DatagramPacket(buf, buf.length);
				socket.receive(inpacket);
				//block and wait for client datagram packet
				newInputLine = new String(inpacket.getData()); 
				if(!inputLine.equals(newInputLine)){
					inputLine = new String(inpacket.getData());
					//System.out.println(inputLine);
					sendToSocket(inputLine); 
					inputLine = ""; 
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
