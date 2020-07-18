import java.io.IOException;
import java.util.Random;

public class WriterClientProtocol {

	String [] arr1 = {"WRITE", "DELETE", "UPDATE"};
	String [] arr2 = {"A", "B", "C", "D", "E"};
	String [] arr3 = {"Arrival", "Departure"};
	String [] arr4 = {"1:00", "2:00", "3:00", "4:00", "5:00", "6:00",
						"7:00", "8:00", "9:00", "10:00", "11:00", "12:00"};
	String theOutput;

	public String prepareRequest() throws IOException {
		WriterClient.counter++;

		Random randominput = new Random();
		Random randomcode = new Random();
		Random randomstatus = new Random();
		Random randomtime = new Random();


		//random selection of elements
		int selectinput = randominput.nextInt(arr1.length);
		int selectcode = randomcode.nextInt(arr2.length);
		int selectstatus = randomstatus.nextInt(arr3.length);
		int selecttime = randomtime.nextInt(arr4.length);

		// prints the value of the random chosen code
		theOutput = arr1[selectinput] + " " + arr2[selectcode] + " " + arr3[selectstatus] + " " + arr4[selecttime];
		if(WriterClient.counter==10) {
			theOutput = "CLOSE";
		}

			return theOutput;
	}
		public void processReply(String theInput) throws IOException
		{
			System.out.println("Message received from server: " + theInput);

		}
}
