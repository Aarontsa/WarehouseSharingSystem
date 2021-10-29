package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
import my.com.Wshare.DatesshowBean;

public class DatesshowDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
//	static ConnManager conn = new ConnManager();
//	static Connection currentCon = ConnManager.getConnection();
	
	public String getDatesshow(DatesshowBean bean) {
		Statement stmt = null;
//		String sql = "SELECT DISTINCT(Booking_Checkin), Booking_Checkout FROM Booking1 where UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)'AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"');";// select
		String sql = "SELECT DISTINCT(Booking_Checkin), Booking_Checkout FROM Booking1 where (UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)'AND" + 
				 "(Booking_Checkin BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"' or Booking_Checkout BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"'))" + 
				 " or ( UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)' AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"'));";// select
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String Booking_Checkin = rs.getString("Booking_Checkin");
				String Booking_Checkout = rs.getString("Booking_Checkout");

				list += "<p style=\"text-align: center;\">"+Booking_Checkin+"--"+Booking_Checkout+"</p>";


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getDatesshow failed: An Exception has occurred! " + ex);
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
