package my.com.Wshare;

public class RecommandcountBean {


	private String Userid1;
	private String Userid2;
	private String Userid3;

	private boolean Status;

	public String getUserid1() {
		return Userid1;
	}

	public void SetUserid1(String newUserid1) {
		Userid1 = newUserid1;
	}
	
	public String getUserid2() {
		return Userid2;
	}

	public void SetUserid2(String newUserid2) {
		Userid2 = newUserid2;
	}
	
	public String getUserid3() {
		return Userid3;
	}

	public void SetUserid3(String newUserid3) {
		Userid3 = newUserid3;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
