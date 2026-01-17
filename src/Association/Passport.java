package src.Association;

public class Passport {
	
	private String id;
	private String dob;
	private String expdate;
	Passport(String id, String dob, String expdate){
		this.id=id;
		this.dob=dob;
		this.expdate=expdate;
	}
	
	public String getID() {
		return id;
	}
	public String getDob() {
		return dob;
	}
	public String getExpDate() {
		return expdate;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	public void setdob (String dob) {
		this.dob = dob;
	}
	public void setexpdate(String expdate) {
		this.expdate = expdate;
	}
}
