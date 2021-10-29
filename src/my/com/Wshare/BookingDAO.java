package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.BookingBean;
import my.com.Wshare.ConnManager;

public class BookingDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static BookingBean selectQuery(BookingBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT Booking_Username, Booking_Quantity, Booking_Details, Booking_mobilenumber, Booking_Checkin, Booking_Checkout, Booking_Days, Payment_Amount, Payment_Bank, UserP_id, UserS_id, Booking_Date, UserS_name, Storage_id, Storage_size FROM Booking1;";// select
			System.out.print(sql);																																																					// statement*************

			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
			}

			boolean more = rs.next();
			if (!more) {
				insertQuery(bean);
			}
			bean.setStatus(true);
		} catch (Exception ex) {
			bean.setStatus(false);
			System.out.println("selectQuery failed: " + ex);
		}

		finally {
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception ex) {
				}
			}
			currentCon = null;
		}
		return bean;
	}

	public static void insertQuery(BookingBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO Booking1 (Booking_Username, Booking_Quantity, Booking_Details, Booking_mobilenumber, Booking_Checkin, Booking_Checkout, Booking_Days, Payment_Amount, Payment_Bank, UserP_id, UserS_id, Booking_Date, UserS_name, Storage_id, Storage_size) VALUES " 
					+ "('" + bean.getBookingName() + "','" + bean.getQuantity() + "','" + bean.getDescription() + "','" + bean.getMobilenumber()
										+ "','" + bean.getCheckin() + "','" + bean.getCheckout() + "','" + bean.getPrice() + "','"
										+ bean.getDays() + "','" + bean.getBank() +"', (SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getUsername() +"' AND  User_Passwords =  '" + bean.getPasswords() +"'),'" + bean.getUserS() +"',getdate(),(SELECT User_Name FROM UserLogin2 WHERE  User_id = '" + bean.getUserS() +"'),(SELECT Storage_id FROM Storage WHERE User_id = '" + bean.getUserS() +"'),'" + bean.getStoragesize() +"');";
			System.out.print(sql);
			// select statement*************
			
			localCon.createStatement().executeUpdate(sql);

		} catch (Exception ex) {
			System.out.println("Insert record failed:" + ex);
		} finally {
			if (localCon != null) {
				try {
					localCon.close();
				} catch (Exception ex) {
				}
			}
			localCon = null;
		}
	}

}
