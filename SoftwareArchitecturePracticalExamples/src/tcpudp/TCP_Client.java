package tcpudp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Usage: 1)cd C:\\Users\\user\workspace\\SET10101\\bin 2)java
 * set10101.ipc.TCP_Client "Hello" "127.0.0.1"
 * 
 * @author Dr Lu Fan
 *
 */
public class TCP_Client {
	public static void main(String args[]) {
		Socket s = null;
		System.out.println("CLIENT");
		try {
			String ip = "192.168.0.9";
			int serverPort = 7896;
			String msg = "Helloo";
			
			s = new Socket(ip, serverPort);
			DataInputStream in = new DataInputStream(s.getInputStream());
			DataOutputStream out = new DataOutputStream(s.getOutputStream());

			out.writeUTF(msg); // UTF is a string encoding format
			System.out.println("Message sent: "+msg);
			
			String data = in.readUTF();
			s.close();
			System.out.println("Received:     "+data);
		} catch (Exception e) {
			System.out.println("Error:" + e.getMessage());
		}
	}
}
