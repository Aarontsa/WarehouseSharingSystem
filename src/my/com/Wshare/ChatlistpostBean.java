package my.com.Wshare;

public class ChatlistpostBean {

	private String CUsername;
	private String CPasswords;
	private int UserS_id;
	private boolean Status;
	
	public String getCUsername() {
		return CUsername;
	}

	public void SetCUsername(String newCUsername) {
		CUsername = newCUsername;
	}

	public String getCPasswords() {
		return CPasswords;
	}

	public void SetCPasswords(String newCPasswords) {
		CPasswords = newCPasswords;
	}
	
	public int getUserS_id() {
		return UserS_id;
	}

	public void SetUserS_id(int newUserS_id) {
		UserS_id = newUserS_id;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
