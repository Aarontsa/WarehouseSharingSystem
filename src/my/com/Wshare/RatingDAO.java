package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.RatingBean;
import my.com.Wshare.ConnManager;

public class RatingDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static RatingBean selectQuery(RatingBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT User_Id, UserS_Id, Feedback_Rate, Feedback_Comment, Feedback_Date FROM Feedback1;";// select
			System.out.print(sql);	
			// statement*************

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

	public static void insertQuery(RatingBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
//		String sql = "INSERT INTO Feedback1 (User_Id, UserS_Id, Feedback_Rate, Feedback_Comment, Feedback_Date) VALUES ((SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getUsername() +"' AND  User_Passwords =  '" + bean.getPasswords() +"'),'" + bean.getUserS() +"','" + bean.getRating() +"','" + bean.getcommentUser() +"',getdate());";
							  
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO Feedback1 (User_Id, UserS_Id, Feedback_Rate, Feedback_Comment, Feedback_Date, Booking_id) VALUES ((SELECT UserP_id FROM Booking1 WHERE Booking_id = '" + bean.getUserS() +"'),(SELECT UserS_id FROM Booking1 WHERE Booking_id = '" + bean.getUserS() +"'),'" + bean.getRating() +"','" + bean.getcommentUser() +"',getdate(), (SELECT Booking_id FROM Booking1 WHERE Booking_id = '" + bean.getUserS() +"'));";//getUserS is booking id at here
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
