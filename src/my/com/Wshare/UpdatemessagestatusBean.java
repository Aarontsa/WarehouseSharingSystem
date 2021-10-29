package my.com.Wshare;

public class UpdatemessagestatusBean {

	private String Username;
	private String Passwords;
	private String Chatlist_id;
	private String Chatlist_status;
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

	public String getChatlist_id() {
		return Chatlist_id;
	}

	public void SetChatlist_id(String newChatlist_id) {
		Chatlist_id = newChatlist_id;
	}
	
	public String getChatlist_status() {
		return Chatlist_status;
	}

	public void SetChatlist_status(String newChatlist_status) {
		Chatlist_status = newChatlist_status;
	}
	
	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
