package p6.ipc;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * 
 * Usage: 1)cd C:\\Users\\user\workspace\\SET10101\\bin 2)java
 * set10101.ipc.UDP_Client "Hello" "127.0.0.1"
 * 
 * @author Dr Lu Fan
 *
 */
public class UDP_Client {
	public static void main(String args[]) {
		DatagramSocket aSocket = null;
		System.out.println("CLIENT");
		try {
			String ip = "192.168.0.9";
			int serverPort = 6789;
			String msg = "Helloo";
			byte[] msgBytes = msg.getBytes();
			
			aSocket = new DatagramSocket();
			InetAddress aHost = InetAddress.getByName(ip);
			DatagramPacket request = new DatagramPacket(msgBytes, msgBytes.length, aHost, serverPort);
			
			aSocket.send(request);
			System.out.println("Message sent: "+msg);
			
			byte[] buffer = new byte[1000];
			DatagramPacket reply = new DatagramPacket(buffer, buffer.length);
			aSocket.receive(reply);
			
			System.out.println("Received: " + new String(reply.getData(), 0, reply.getLength()));
		} catch (Exception e) {
			aSocket.close();
			System.out.println("Socket: " + e.getMessage());
		}
	}

}
