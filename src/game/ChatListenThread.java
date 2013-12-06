package game;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

public class ChatListenThread implements Runnable{

	private MulticastSocket socket;
	private final int MCAST_PORT; 
	private int ttl = 64; /* time to live */
	private InetAddress group;
	private Queue<String> msgs;
	public JTextArea controls; 
	public boolean listening = true; 

	public ChatListenThread(JTextArea controls) throws Exception{
		group = InetAddress.getByName("224.3.4.5");
		MCAST_PORT = 21000; 
		/* instantiate a MulticastSocket */
		this.socket = new MulticastSocket(MCAST_PORT);
		/* set the time to live */
		socket.setTimeToLive(ttl);
		msgs = new LinkedList<String>();
		this.controls = controls; 	
	}

	public void joinGroup() throws Exception {
		socket.joinGroup(group);
	}

	public void leaveGroup() throws Exception {
		socket.leaveGroup(group);
		socket.close();
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

	public void run() {
		try {
			joinGroup();
			
				msgs.add(readFromSocket());
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						String msg = msgs.remove()+"\n"; 
						try{
						controls.replaceRange(msg, 150, 200); 
						}
						catch(IllegalArgumentException e){
							controls.append(msg); 
						}
					}
				}); 
		}
		catch (Exception e) {
			e.printStackTrace();
		} 

	}
}




