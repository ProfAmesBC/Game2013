package Multiplayer;

//import GameServerTable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.StringTokenizer;

import game.*;

public class ClientSendThread implements Runnable{
	private Player client; 
	public static final int PORT = 9189;  
	public static final String HOST = "136.167.125.37"; 
	public static final int playerNumber = 2; 

	public ClientSendThread(Player client){
		this.client = client; 
	}

	public void run() {  //throws IOException, InterruptedException {
		try {
			DatagramSocket socket; 
			socket = new DatagramSocket(PORT);
			byte[] buf = new byte[256];
			boolean listening = true;
			//GameServerTable S = new GameServerTable(playerNumber); 
			String inputLine; 
			String outputLine = ""; 
			InetAddress address = InetAddress.getByName(HOST); 
			
			outputLine +=  client.getID()+"\n"; 
			outputLine += client.getX()+"\n"; 
			outputLine += client.getY()+"\n"; 
			outputLine += client.getZ()+"\n"; 

			buf = outputLine.getBytes();
			DatagramPacket outpacket = new DatagramPacket(buf, buf.length, address, PORT);
			socket.send(outpacket);
			
			/*
			while (listening) {
				DatagramPacket inpacket = new DatagramPacket(buf, buf.length);
				socket.receive(inpacket); //block and wait for client datagram packet
				inputLine = new String(inpacket.getData(), 0, inpacket.getLength());

				StringTokenizer st = new StringTokenizer(inputLine); 

				while(st.hasMoreTokens()){
					String playerID = st.nextToken(); 
					double newX = Double.parseDouble(st.nextToken()); 
					double newY = Double.parseDouble(st.nextToken());
					double newZ = Double.parseDouble(st.nextToken()); 

					//S.addPlayer(playerID, newX, newY, newZ);
				}

				//S.printTable(); 
				*/



				//ECHO TEST
				/*StringTokenizer st = new StringTokenizer(inputLine);
				 while (st.hasMoreTokens()) {
			         outputLine += ""+st.nextToken();
			     }

				//put output into buffer
				buf = outputLine.getBytes();
				InetAddress address = inpacket.getAddress();
				int port = inpacket.getPort();

				// send the response to the client at "address" and "port"
				DatagramPacket outpacket = new DatagramPacket(buf, buf.length,address, port);
				socket.send(outpacket);*/ 

			socket.close();
		} 
		catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}


	}



}
