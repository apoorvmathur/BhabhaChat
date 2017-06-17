import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test {
	
	public static void main(String[] args) throws IOException {
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutput out = new ObjectOutputStream(bos);
		String str = "Hi!";
		out.writeObject(str);
		out.flush();
		byte[] buf = bos.toByteArray();
		DatagramPacket packet = new DatagramPacket(buf, buf.length, InetAddress.getByName("127.0.0.1"), DiscoveryServer.port);
		DatagramSocket socket = new DatagramSocket();
		socket.send(packet);
	}
}
