package my.com.Wshare;

public class ChaticonBean {

		private String CUsername;
		private String CPasswords;
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
		
		public boolean getStatus() {
			return Status;
		}

		public void setStatus(boolean newStatus) {
			Status = newStatus;
		}

	}
