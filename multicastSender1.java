import java.util.Scanner;
import java.io.*;
import java.net.*;

public class Sender {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		InetAddress group = InetAddress.getByName("224.0.0.5");
		MulticastSocket multicastSock = new MulticastSocket();
		String msg = sc.nextLine();
		msg = "Derri: " + msg;
		do {
							
			DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 4446);
			
			multicastSock.send(packet);
			
			msg = sc.nextLine();
			msg = "Derri: " + msg;

		 } while(msg.equals("Derri: q") == false);

		 DatagramPacket packet = new DatagramPacket(msg.getBytes(), msg.length(), group, 4446);
				
		multicastSock.send(packet);
		multicastSock.close();
	}
}
