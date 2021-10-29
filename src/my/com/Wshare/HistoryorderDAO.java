package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.HistoryorderBean;

public class HistoryorderDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getHistoryorder(HistoryorderBean bean) {
		Statement stmt = null;
//		WHERE Booking_Date >= DATEADD(day,-1, GETDATE()) AND Booking_Date <= DATEADD(day,0, GETDATE()) AND
		String sql = "SELECT Booking_id, Booking_Username, Booking_Quantity, Booking_Details, Booking_mobilenumber, Booking_Checkin, Booking_Checkout, Booking_Days, Payment_Amount, Payment_Bank, Booking_Date, UserS_name, Storage_size FROM Booking1 WHERE UserS_id =(SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsernameS() + "'AND User_Passwords = '" + bean.getCPasswordsS() + "') ORDER BY Booking_Date DESC;";// select
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;

			while (rs.next()) {
//				String UserS_id = rs.getString("UserS_id");
				String Booking_id = rs.getString("Booking_id");
				String Booking_Username = rs.getString("Booking_Username");
				String Booking_Quantity = rs.getString("Booking_Quantity");
				String Booking_Details = rs.getString("Booking_Details");
				String Booking_mobilenumber = rs.getString("Booking_mobilenumber");
				String Booking_Checkin = rs.getString("Booking_Checkin");
				String Booking_Checkout = rs.getString("Booking_Checkout");
				String Booking_Days = rs.getString("Booking_Days");
				String Payment_Amount = rs.getString("Payment_Amount");
				String Payment_Bank = rs.getString("Payment_Bank");
				String UserS_name = rs.getString("UserS_name");
				String Booking_Date = rs.getString("Booking_Date");
				String Storage_size = rs.getString("Storage_size");
//				String User_id = rs.getString("User_id");
				int timelooping = count++;


				list += "<div class=\"bttn-containerH\" id=\"filter"+timelooping+"\" name=\"filter\">";
//				list += "<input type=\"text\" name=\"containerid\" value=\""+UserS_id+"\" id=\"containerid\">";
				list += "<div id=\"test\" class=\"test\">";
				list += "<p hidden id=\"OrienCourseCode\"></p>";
				list += "<h2 id=\"BookingID\">Booking ID:" + Booking_id + "</h2>";
				list += "<p>Booking date: "+Booking_Date+"</p>";
				list += "<p id=\"storage\">Storage provider:" + UserS_name + "</p>";
				list += "<p id=\"Name\">Book name:" + Booking_Username + "</p>";
				list += "<p hidden id=\"Phonenumber\">Phone number:" + Booking_mobilenumber + "</p>";
				list += "<p id=\"Quantity\">Quantity:"+ Booking_Quantity +"</p>";
				list += "<p id=\"Details\">Details:" + Booking_Details + "</p>";
				list += "<p id=\"size\">Storage size:" + Storage_size + "</p>";
//				list += "<img  src=\"./img/icon/icon_forward2.png\" alt=\"HTML5 Icon\" class=\"imgbtnnext\"></img>";
				list += "<p id=\"OrienDatetime\">Date:" + Booking_Checkin + " - " + Booking_Checkout + "</p>";
//				list += "<p id=\"BookingDays\">" + Booking_Days + "</p>";
				list += "<p id=\"OrienVenue\">Payment amount: RM" + Payment_Amount + "</p>";
//				list += "<div id=\"Visit\" name=\"Visit\" class=\"Download\" type=\"submit\" value=\""+UserS_id+"\"><a></a>Visit User</div>&nbsp;&nbsp;";
//				list += "<div id=\"Download\" name=\"Download1\" class=\"Download\" type=\"submit\" value=\"filter"+timelooping+"\"><a></a>Download PDF</div>&nbsp;&nbsp;";
//				list += "<div id=\"Rating\" name=\"Rating\" class=\"Rating\" type=\"submit\" value=\""+UserS_id+"\"><a></a>Rating</div><br>";
//				list += "<p id=\"PaymentBank\">" + Payment_Bank + "</p>";
				list += "</div>";
				list += "</div>";
				// list += "<br>";


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getHistoryorder failed: An Exception has occurred! " + ex);
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (Exception ex) {
				}
				rs = null;
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (Exception ex) {
				}
				stmt = null;
			}

			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception ex) {
				}
				currentCon = null;
			}
		}

		return list;
	}

}
