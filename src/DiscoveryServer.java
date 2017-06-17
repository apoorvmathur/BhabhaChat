import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.util.ArrayList;

public class DiscoveryServer {

	static final int port = 9081;

	static DatagramSocket socket;
	static ArrayList<PubKey> hosts = new ArrayList<PubKey>();
	public static void addHost(PubKey key) {
		if (hosts.contains(key)) {
			hosts.remove(key);
		}
		hosts.add(key);
	}

	public static void main(String[] args) {
		startServer();
	}

	public static void startServer() {
		try {
			socket = new DatagramSocket(port);
			while (true) {
				byte[] buf = new byte[2048];

				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);

				ByteArrayInputStream bis = new ByteArrayInputStream(buf);
				ObjectInput in = new ObjectInputStream(bis);

				PubKey key = (PubKey) in.readObject();
				key.setIpAddress(packet.getAddress().getHostAddress());
				addHost(key);
				System.out.println(hosts);
				in.close();
			}
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
