package my.com.Wshare;

public class ValidDatestatusBean {

	private String UserS;
	private String Checkin;
	private String Checkout;
	private boolean Status;

	public String getUserS() {
		return UserS;
	}

	public void SetUserS(String newUserS) {
		UserS = newUserS;
	}
	
	public String getCheckin() {
		return Checkin;
	}

	public void SetCheckin(String newCheckin) {
		Checkin = newCheckin;
	}
	
	public String getCheckout() {
		return Checkout;
	}

	public void SetCheckout(String newCheckout) {
		Checkout = newCheckout;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
