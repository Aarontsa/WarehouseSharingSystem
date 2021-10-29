package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import my.com.Wshare.AdminbookingreportBean;
import my.com.Wshare.ConnManager;



public class AdminbookingreportDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getBookingReportDetails() {
		Statement stmt = null;
		String sql = "SELECT Booking_id ,UserP_id, UserS_id, Booking_Quantity, Booking_Details, Booking_Checkin, Booking_Checkout, Booking_Days, Payment_Amount, Payment_Bank, Booking_Date FROM Booking1 ORDER BY Booking_id DESC;";// select
																																																																	// statement*************

		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String Booking_id = rs.getString("Booking_id");
				String UserP_id = rs.getString("UserP_id");
				String UserS_id = rs.getString("UserS_id");
				String Booking_Quantity = rs.getString("Booking_Quantity");
				String Booking_Details = rs.getString("Booking_Details");
				String Booking_Checkin = rs.getString("Booking_Checkin");
				String Booking_Checkout = rs.getString("Booking_Checkout");
				String Booking_Days = rs.getString("Booking_Days");
				String Payment_Amount = rs.getString("Payment_Amount");
				String Payment_Bank = rs.getString("Payment_Bank");
				String Booking_Date = rs.getString("Booking_Date");

				list += "<tr><td class=\"size\">" + Booking_id + "</td>";
				list += "	<td class=\"size\">" + UserP_id + "</td>";
				list += "	<td class=\"size\">" + UserS_id + "</td>";
				list += "	<td class=\"size\">" + Booking_Quantity + "</td>";
				list += "	<td class=\"size\">" + Booking_Details + "</td>";
				list += "	<td class=\"size\">" + Booking_Checkin + "</td>";
				list += "	<td class=\"size\">" + Booking_Checkout + "</td>";
				list += "	<td class=\"size\">" + Booking_Days + "</td>";
				list += "	<td class=\"size\">" + Payment_Amount + "</td>";
				list += "	<td class=\"size\">" + Payment_Bank + "</td>";
				list += "	<td class=\"size\">" + Booking_Date + "</td>";
				list += "	<td class=\"size\"><div id=\"deletebooking\" class=\"deletebooking\" name=\"deletebooking\" value=\"" + Booking_id +"\"><a></a>Delete</div></td>";
//				list += "	<td class=\"size\"><div id=\"editbooking\" class=\"backforget\" name=\"editbooking\" value=\"" + Booking_id +"\"><a></a>Edit</div></td>";
				list += "	</tr>";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getBookingReportDetails failed: An Exception has occurred! " + ex);
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
