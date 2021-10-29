package my.com.Wshare;

public class MapBean {

	private int Userid;
	private String Username;
	private float Latitude;
	private float Longtitude;
	private boolean Status;
	
	public int getUserid() {
		return Userid;
	}

	public void SetUserid(int newUserid) {
		Userid = newUserid;
	}

	public String getUsername() {
		return Username;
	}

	public void SetUsername(String newUsername) {
		Username = newUsername;
	}

	public float getLatitude() {
		return Latitude;
	}

	public void SetLatitude(float newLatitude) {
		Latitude = newLatitude;
	}
	
	public float getLongtitude() {
		return Longtitude;
	}

	public void SetLongtitude(float newLongtitude) {
		Longtitude = newLongtitude;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
