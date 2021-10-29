package my.com.Wshare;

public class BookingBean {

	private String Username;
	private String Passwords;
	private int UserS;
	private String BookingName;
	private int Quantity;
	private String Description;
	private int Mobilenumber;
	private String Checkin;
	private String Checkout;
	private int Price;
	private int Days;
	private String Bank;
	private String Storagesize;
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
	
	public String getStoragesize() {
		return Storagesize;
	}

	public void SetStoragesize(String newStoragesize) {
		Storagesize = newStoragesize;
	}

	public boolean getStatus() {
		return Status;
	}

	public void setStatus(boolean newStatus) {
		Status = newStatus;
	}

}
