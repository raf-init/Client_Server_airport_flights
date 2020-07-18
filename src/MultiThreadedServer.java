import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.net.*;

public class MultiThreadedServer  {

	private static final int PORT=1234;

	public static void main(String[] args) {

	     ConcurrentHashMap<String, Flight> flights = new  ConcurrentHashMap<>();

	     // starting the server and creating the threads for each request
		 try {
			 ServerSocket connectionSocket = new ServerSocket(PORT);
			 while(true) {
				 System.out.println("Server is listening to port:" + PORT);
				 Socket dataSocket = connectionSocket.accept();
				 System.out.println("Received request from" + dataSocket.getInetAddress());
				 ServerThread sthread1 = new ServerThread(dataSocket, flights);
				 sthread1.start();
			 }
		 }catch(IOException e){System.err.println(e);}
	}
}
