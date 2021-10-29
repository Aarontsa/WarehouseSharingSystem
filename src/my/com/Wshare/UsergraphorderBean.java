package my.com.Wshare;

public class UsergraphorderBean {

	private String Username;
	private String Passwords;
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
	
	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
