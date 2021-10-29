package my.com.Wshare;

public class LoginBean {

	private String CUsernameS;
	private String CPasswordsS;
	private String BookingName;
	private int Quantity;
	private String Description;
	private int Mobilenumber;
	private String Checkin;
	private String Checkout;
	private int Price;
	private int Days;
	private String Bank;
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
	
	public String getBookingName() {
		return BookingName;
	}

	public void SetBookingName(String newBookingName) {
		BookingName = newBookingName;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void SetQuantity(int newQuantity) {
		Quantity = newQuantity;
	}
	
	public String getDescription() {
		return Description;
	}
	
	public void SetDescription(String newDescription) {
		Description = newDescription;
	}
	
	public int getMobilenumber() {
		return Mobilenumber;
	}

	public void SetMobilenumber(int newMobilenumber) {
		Mobilenumber = newMobilenumber;
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
	
	public int getPrice() {
		return Price;
	}

	public void SetPrice(int newPrice) {
		Price = newPrice;
	}
	
	public int getDays() {
		return Days;
	}

	public void SetDays(int newDays) {
		Days = newDays;
	}

	public String getBank() {
		return Bank;
	}

	public void SetBank(String newBank) {
		Bank = newBank;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
