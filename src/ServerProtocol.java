import java.io.*;
import java.util.concurrent.ConcurrentHashMap;


public class ServerProtocol {
		public String processRequest(String Input, ConcurrentHashMap<String, Flight> flights) throws IOException {

			String A[] = Input.split(" ");
			String command = A[0]; //command: READ, WRITE, DELETE, UPDATE or CLOSE

			if (command.toUpperCase().equals("READ")) {
				return processRead(A, flights);
			}

			if (command.toUpperCase().equals("WRITE")) {

				return processWrite(A, flights);
			}

	        if(command.toUpperCase().equals("DELETE")) {
	            return processDelete(A, flights);
	        }

	        if(command.toUpperCase().equals("UPDATE")) {
	        	return processUpdate(A, flights);
	        }

	        if(command.toUpperCase().equals("CLOSE")){
	        	return "CLOSE";
	        }

		// in case of sending a different inpout
		return "INPUT ERROR";
	}

		public String processRead (String A[], ConcurrentHashMap<String, Flight> flights) {
			if(A.length!=2) { //A[0] = "READ" and A[1] = any code
				return "RERR";
			}

		    String status = A[1];

		    if(flights.containsKey(status))
		    	return "ROK" + " " + flights.get(status).getCode() + " " + flights.get(status).getStatus() + " " + flights.get(status).getTime();

		    return "RERR: De vrethike tetios hristis";
		}

		public String processWrite (String A[], ConcurrentHashMap<String, Flight> flights) {
			if(A.length!= 4) { //A[0] = "WRITE", A[1] = any code, A[2] = arrival/ departure, A[3] = time
				return "WERR";
			}

			String code = A[1] ;
			String status = A[2];
			String time = A[3];

			if(flights.containsKey(code))
				return "WERR";
			flights.putIfAbsent(code, new Flight(code, status, time));

			return "WOK";
		}

		public String processDelete (String A[], ConcurrentHashMap<String, Flight> flights) {
			if(A.length!= 2) { //A[0] = "DELETE", A[1] = any code
				return "DERR";
			}

			String code = A[1] ;
			Flight hashcode = flights.get(code);

			if(hashcode != null) {
				flights.remove(code, hashcode);
				return "DOK";
			}

			return "DERR";
		}

		public String processUpdate (String A[], ConcurrentHashMap<String, Flight> flights) {
			if(A.length!= 4) { //A[0] = "WRITE", A[1] = any code , A[2] = arrival/ departure, A[3] = time
				return "UERR";
			}

			String code = A[1] ;
			String status = A[2];
			String time = A[3];
			Flight hashcode = flights.get(code);

			if(hashcode != null)
			{
				flights.remove(code, hashcode);
				flights.replace(code, hashcode, new Flight(code, status, time));
				return "UOK";
			}

				return "UERR";
		}
}
