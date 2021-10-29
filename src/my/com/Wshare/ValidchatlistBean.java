package my.com.Wshare;

public class ValidchatlistBean {

	private String Username;
	private String Passwords;
	private String CStorage_Userid;
	private boolean Status;

	public String getUsername() {
		return Username;
	}

	public void SetUsername(String newUsername) {
		Username = newUsername;
	}
	
	public String getPasswords() {
		return Passwords;
	}

	public void SetPasswords(String newPasswords) {
		Passwords = newPasswords;
	}
	
	public String getCStorage_Userid() {
		return CStorage_Userid;
	}

	public void SetCStorage_Userid(String newCStorage_Userid) {
		CStorage_Userid = newCStorage_Userid;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
