package Multiplayer;

//import GameServerTable;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

import game.*;

public class ClientSendThread implements Runnable{
	private Player client; 
	public static final int PORT = 9189;  
	public static final String HOST = "136.167.251.23"; 
	public static final int playerNumber = 2; 

	public ClientSendThread(Player client){
		this.client = client; 
	}

	public void run() { 

		try {
			DatagramSocket socket; 
			socket = new DatagramSocket();
			byte[] buf = new byte[256];
			boolean listening = true;
			//GameServerTable S = new GameServerTable(playerNumber); 
			String inputLine; 
			String outputLine = ""; 
			InetAddress address = InetAddress.getByName(HOST); 

			while (listening){
				outputLine +=  client.getID()+"\n"; 
				outputLine += client.getX()+"\n"; 
				outputLine += client.getY()+"\n"; 
				outputLine += client.getZ()+"\n"; 

				Thread.sleep(10);
				buf = outputLine.getBytes();
				DatagramPacket outpacket = new DatagramPacket(buf, buf.length, address, PORT);
				socket.send(outpacket);
			}

			socket.close();
		} 
		catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}



}
