package my.com.Wshare;

public class RatingBean {

	private String Username;
	private String Passwords;
	private int UserS;
	private int Rating;
	private String commentUser;
	
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
	
	public int getUserS() {
		return UserS;
	}

	public void SetUserS(int newUserS) {
		UserS = newUserS;
	}

	public int getRating() {
		return Rating;
	}

	public void SetRating(int newRating) {
		Rating = newRating;
	}

	public String getcommentUser() {
		return commentUser;
	}

	public void SetcommentUser(String newcommentUser) {
		commentUser = newcommentUser;
	}
	
	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
