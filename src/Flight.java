/*
 * Each flight is a separate object of type Flight
 * For each flight there is a code, status and time
 */
public class Flight {

	private String code;
	private String status;
	private String time;

	public Flight(String code, String status,  String time) {
	this.code = code;
	this.status = status;
	this.time = time;
	}

	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}

}
