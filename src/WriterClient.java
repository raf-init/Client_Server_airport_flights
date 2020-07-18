import java.net.*;
import java.io.*;

public class WriterClient {
	
	private static final String HOST= "localhost";
	static final int PORT = 1234;	
	static int counter=0;
	
	public static void main(String[] args) throws IOException {
		InetAddress address = InetAddress.getByName(HOST);	
		Socket dataSocket = new Socket(HOST, PORT);
		InputStream is = dataSocket.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		OutputStream os = dataSocket.getOutputStream();
		PrintWriter out = new PrintWriter(os,true);
		System.out.println("Connection to " + HOST + " established");
		
		String inmsg, outmsg;
		
		WriterClientProtocol app = new WriterClientProtocol();

		while(true) {
			outmsg = app.prepareRequest(); 
			out.println(outmsg);
			System.out.println("To minima pou stelni o pelatis ston server ine: " + outmsg);	
			inmsg = in.readLine();
			app.processReply(inmsg);		
			if (inmsg.equals("CLOSE")) 
				break;	
		}
		dataSocket.close();
		System.out.println("Data socket close/d");
	}	
}