package my.com.Wshare;

public class ChatViewBean {

	private String CUsername;
	private String CPasswords;
	private String UserS_id;
	private String Chatlist_id;
	private String User_Mgs;
	private String Chatlistid;
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
	
	public String getUserS_id() {
		return UserS_id;
	}

	public void SetUserS_id(String newUserS_id) {
		UserS_id = newUserS_id;
	}
	
	public String getChatlist_id() {
		return Chatlist_id;
	}

	public void SetChatlist_id(String newChatlist_id) {
		Chatlist_id = newChatlist_id;
	}

	public String getUser_Mgs() {
		return User_Mgs;
	}

	public void SetUser_Mgs(String newUser_Mgs) {
		User_Mgs = newUser_Mgs;
	}
	
	public String getChatlistid() {
		return Chatlistid;
	}

	public void SetChatlistid(String newChatlistid) {
		Chatlistid = newChatlistid;
	}
	

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
