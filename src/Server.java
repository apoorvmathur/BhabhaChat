import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import javax.net.ServerSocketFactory;

public class Server implements Runnable {

	static final int port = 9080;
	static ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		startServer();
	}
	
	public static void startServer() throws IOException {
		serverSocket = ServerSocketFactory.getDefault().createServerSocket(port);
		while (true) {
			Socket socket = serverSocket.accept();
			System.out.println("Connection Incoming!");
			System.out.println("Connected to " + socket.getRemoteSocketAddress());
			Server server = new Server(socket);
			Thread thread = new Thread(server);
			thread.start();
		}
	}
	
	public static void stopServer() throws IOException {
		serverSocket.close();
	}

	Socket socket;

	static ArrayList<Message> messages = new ArrayList<Message>();
	ObjectInputStream stream;

	public Server(Socket socket) throws IOException {
		this.socket = socket;
		stream = new ObjectInputStream(socket.getInputStream());
	}

	@Override
	public void run() {
		try {
			while (true) {
				Message message = (Message) stream.readObject();
				messages.add(message);
				System.out.println(message);
			}
		} catch (EOFException e) {
			System.out.println("Disconnected!");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println(e);
		}
	}
}
