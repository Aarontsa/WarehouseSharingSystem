package my.com.Wshare;

public class ChatBean {

	private String CUsername;
	private String CPasswords;
	private int UserS_id;
	private String User_Mgs;
	private int Chatlist_id;
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
	
	public int getChatlist_id() {
		return Chatlist_id;
	}

	public void SetChatlist_id(int newChatlist_id) {
		Chatlist_id = newChatlist_id;
	}

	public String getUser_Mgs() {
		return User_Mgs;
	}

	public void SetUser_Mgs(String newUser_Mgs) {
		User_Mgs = newUser_Mgs;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
