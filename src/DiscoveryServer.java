import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class DiscoveryServer {
	
	public static void main(String[] args) {
		startServer();
	}
	
	static final int port = 9081;
	static DatagramSocket socket;
	
	public static void startServer() {
		try {
			socket = new DatagramSocket(port);
			while(true) {
				byte[] buf = new byte[1024];
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				ByteArrayInputStream bis = new ByteArrayInputStream(buf);
				ObjectInput in = new ObjectInputStream(bis);
				String str = (String)in.readObject();
				System.out.println(str);
				in.close();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
