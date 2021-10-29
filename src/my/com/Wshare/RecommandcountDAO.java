package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
import my.com.Wshare.RecommandcountBean;

public class RecommandcountDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public String getRecommandcount(RecommandcountBean bean) {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;

		/*** Prepare SQL query statement ***/
//		String sql = "SELECT COUNT(Booking_id) as bookingtime, UserS_Id as a FROM Booking1 where UserS_Id='"+bean.getUserid1()+"' or UserS_Id='"+bean.getUserid2()+"' or UserS_Id='"+bean.getUserid3()+"' and Booking_Date >= DATEADD(day,-30, GETDATE()) AND Booking_Date <= DATEADD(day,0, GETDATE()) group by UserS_Id order by bookingtime asc;"; 
		String sql = "SELECT TOP 1 COUNT(Booking1.Booking_id) as bookingtime, Feedback1.UserS_Id as a, (select (ROUND(AVG(CAST(Feedback1.Feedback_Rate AS FLOAT)),2))) AS rate FROM (Feedback1 INNER JOIN Booking1 ON Feedback1.Booking_id = Booking1.Booking_id) where (Feedback1.Feedback_Rate >= 3 ) and (Booking1.Booking_Date >= DATEADD(day,-60, GETDATE()) AND Booking1.Booking_Date <= DATEADD(day,0, GETDATE())  ) GROUP BY Feedback1.UserS_Id  having COUNT (Booking1.Booking_id) <7 order by newid();"; //order by booking time -> NEWID() asc
		
		System.out.print(sql);
		String list = "[";
//		System.out.println("select query");
		try {
			/*** Open SQL connection ***/
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();

			/*** Execute SQL statement ***/
			rs = stmt.executeQuery(sql);

			/*** Check for query result ***/
//			int count = 0;
			int first = 0;
			while (rs.next()) {
				if(first != 0) {
					list += ",";
				}
				String bookingtime = rs.getString("bookingtime");
				String UserS_Id = rs.getString("a");



				list += "["+UserS_Id+"]";
				first = 1;

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getRecommandcount failed: An Exception has occurred! " + ex);
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
		list += "]";
		return list;
	}

}

