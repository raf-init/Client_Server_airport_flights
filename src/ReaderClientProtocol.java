import java.io.*;
import java.util.Random;

public class ReaderClientProtocol {

	String [] arr = {"A", "B", "C", "D", "E"};
	String theOutput;

	public String prepareRequest() throws IOException {

			Random random = new Random();

			// random choose a code from array
			int select = random.nextInt(arr.length);
			theOutput = "READ" + " " + arr[select];
			// ends after running for 10 times 
			if(ReaderClient.counter==10) {
				theOutput = "CLOSE";
			}

		return theOutput;
	}
		public void processReply(String theInput) throws IOException
		{
			System.out.println("Message received from server: " + theInput);

		}



}
