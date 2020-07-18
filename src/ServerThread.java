import java.io.*;
import java.net.*;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

public class ServerThread extends Thread {

	private Socket dataSocket;
	private InputStream is;
	private BufferedReader in;
	private OutputStream os;
	private PrintWriter out;
	private static final String EXIT = "CLOSE";
    ConcurrentHashMap<String, Flight> flights = new  ConcurrentHashMap<>();

	public ServerThread(Socket socket, ConcurrentHashMap<String, Flight> flights) {
		dataSocket = socket;
		try {
			is = dataSocket.getInputStream();
			in = new BufferedReader (new InputStreamReader(is));
			os = dataSocket.getOutputStream();
			out = new PrintWriter(os,true);
			this.flights = flights;

		}catch  (IOException e){
		System.out.println("I/O Error" + e);
		}
	}

	public void run() {
		String inmsg, outmsg;

		try {
			inmsg = in.readLine();
			ServerProtocol app = new ServerProtocol();
			System.out.println("Started writing: " + new Date());
			outmsg = app.processRequest(inmsg, flights);
			System.out.println("Stopped writing: " + new Date());
			while (!outmsg.equals(EXIT)) {
			out.println(outmsg);
			inmsg = in.readLine();
			outmsg = app.processRequest(inmsg, flights);
			}
		out.println(outmsg); // in case client sents CLOSE the server responds 
		dataSocket.close();
		System.out.println("Data socket closed");
		}catch (IOException e) {
			System.out.print("I/O Error" + e);
		}
	}

}
