package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
import my.com.Wshare.ValidDatestatusBean;

public class ValidDatestatusDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
//	static ConnManager conn = new ConnManager();
//	static Connection currentCon = ConnManager.getConnection();
	
	public String getValidDatestatus(ValidDatestatusBean bean) {
		Statement stmt = null;
//		String sql = "SELECT DISTINCT(SELECT count(Booking_id) FROM Booking1 where UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)'AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"')) as datecounts," + 
//					 "(SELECT count(Booking_id) FROM Booking1 where  UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Large(100cmx100cm)'AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"')) as datecountl" + 
//					 " FROM Booking1 ;";// select
		String sql = "SELECT DISTINCT (SELECT COUNT(Booking_id) FROM Booking1 where (UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)'AND" + 
					 "(Booking_Checkin BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"' or Booking_Checkout BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"'))" + 
					 " or ( UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Small(50cmx50cm)' AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"'))) as datecounts," + 
					 " (SELECT COUNT(Booking_id) FROM Booking1 where (UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Large(100cmx100cm)'AND" + 
					 "(Booking_Checkin BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"' or Booking_Checkout BETWEEN '"+bean.getCheckin()+"' AND '"+bean.getCheckout()+"'))" + 
					 " or ( UserS_id= '"+bean.getUserS()+"' AND Storage_size = 'Large(100cmx100cm)' AND (Booking_Checkin <= '"+bean.getCheckin()+"' AND Booking_Checkout >= '"+bean.getCheckout()+"')))as datecountl" +
					 " FROM Booking1;";// select
		
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String datecounts = rs.getString("datecounts");
				String datecountl = rs.getString("datecountl");

				list += "<input type=\"hidden\" id=\"datecounts\" value="+ datecounts +">";
				list += "<input type=\"hidden\" id=\"datecountl\" value="+ datecountl +">";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getValidDatestatus failed: An Exception has occurred! " + ex);
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
