import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Receiver {
	
	public static void main(String[] args) throws IOException {

		InetAddress group =  InetAddress.getByName("224.0.0.5");
		MulticastSocket multicastSock = new MulticastSocket(4446);
		multicastSock.joinGroup(group);
		String msg = new String("");
		byte[ ] buffer = new byte[100];

		do {
			Calendar calendar = GregorianCalendar.getInstance();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

			multicastSock.receive(packet);
			msg = new String (buffer).trim();

			System.out.println("["+calendar.get(Calendar.HOUR_OF_DAY)+":"+calendar.get(Calendar.MINUTE)+"]\t"+msg);
			buffer = new byte[100];		//clear the buffer

		} while(msg.equals("Derri: q") == false);
		 	
		multicastSock.close();
	}
}
