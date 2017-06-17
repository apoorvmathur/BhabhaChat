import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	Socket socket;
	String name;
	ObjectOutputStream stream;
	
	public void connect(String address) throws UnknownHostException, IOException {
		socket = new Socket(address, Server.port);
		stream = new ObjectOutputStream(socket.getOutputStream());
	}
	
	public void send(String mess) throws IOException {
		Message message = new Message(name, socket.getLocalAddress()+"", socket.getInetAddress()+"", mess);
		stream.writeObject(message);
		stream.flush();
	}
	
	public void close() throws IOException {
		stream.close();
	}
	
	public static void main(String[] args) throws UnknownHostException, IOException {
		Client client = new Client();
		client.connect("localhost");
		System.out.println("Connected to "+ client.socket.getRemoteSocketAddress());
		client.name = "Mogambo";
		client.send("Hello!!");
		client.send("Hello!!");
		client.send("Hello!!");
		client.close();
	}

}
