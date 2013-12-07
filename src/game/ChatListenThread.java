package game;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChatListenThread implements Runnable{

	private MulticastSocket socket;
	private final int MCAST_PORT; 
	private int ttl = 64; /* time to live */
	private InetAddress group;
	private Queue<String> msgs;
	public JTextArea chat; 
	public JTextField chatBox; 
	public boolean listening = true;
	public byte[] buf;
	public String oldMsg; 
	public int msgCount = 0; 
	public String controlDefault; 

	public ChatListenThread(JTextArea chat, JTextField chatBox) throws Exception{
		group = InetAddress.getByName("224.3.4.5");
		MCAST_PORT = 21000; 
		/* instantiate a MulticastSocket */
		this.socket = new MulticastSocket(MCAST_PORT);
		/* set the time to live */
		socket.setTimeToLive(ttl);
		msgs = new LinkedList<String>();
		this.chat = chat; 	
		this.chatBox = chatBox; 
		oldMsg = ""; 
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
		buf = new byte[1000];
		DatagramPacket recv = new DatagramPacket(buf, buf.length);
		socket.receive(recv);
		socketString = new String(recv.getData(), 0, recv.getLength());
		return 	socketString;	
	}

	public void run() {
		try {
			joinGroup();
			controlDefault = chat.getText();
			while (listening){
				String msgFromSocket = readFromSocket(); 
				msgs.add(msgFromSocket);
				oldMsg = msgFromSocket;
				System.out.println("Received from multicast: "+msgFromSocket);
				SwingUtilities.invokeLater(new Runnable() {
					public void run(){
						if(!msgs.isEmpty())
							msgs.remove();
						if(!msgs.isEmpty()){
							String msg = msgs.remove()+"\n"; 
							chat.append(msg);
						}
						chatBox.setText("");
					}
				}); 
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		} 

	}
}




