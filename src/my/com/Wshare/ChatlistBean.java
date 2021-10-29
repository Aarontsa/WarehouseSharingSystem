package my.com.Wshare;

public class ChatlistBean {

	private String CUsernameS;
	private String CPasswordsS;;
//	private String Checkin;
//	private String Checkout;
	private boolean Status;
	
	public String getCUsernameS() {
		return CUsernameS;
	}

	public void SetCUsernameS(String newCUsernameS) {
		CUsernameS = newCUsernameS;
	}

	public String getCPasswordsS() {
		return CPasswordsS;
	}

	public void SetCPasswordsS(String newCPasswordsS) {
		CPasswordsS = newCPasswordsS;
	}
	
	
//	public String getCheckin() {
//		return Checkin;
//	}
//
//	public void SetCheckin(String newCheckin) {
//		Checkin = newCheckin;
//	}
//
//	public String getCheckout() {
//		return Checkout;
//	}
//
//	public void SetCheckout(String newCheckout) {
//		Checkout = newCheckout;
//	}
	
	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
