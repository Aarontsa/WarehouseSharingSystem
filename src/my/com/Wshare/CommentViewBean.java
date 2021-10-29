package my.com.Wshare;

public class CommentViewBean {

	private String CUsername;
	private String CPasswords;
	private String CStorage_Userid;
	private String Chatlist_id;
	private String User_Mgs;
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
	
	public String getCStorage_Userid() {
		return CStorage_Userid;
	}

	public void SetCStorage_Userid(String newCStorage_Userid) {
		CStorage_Userid = newCStorage_Userid;
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

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
