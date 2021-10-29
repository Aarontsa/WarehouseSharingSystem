package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
import my.com.Wshare.ValidRatingBean;

public class ValidRatingDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
//	static ConnManager conn = new ConnManager();
//	static Connection currentCon = ConnManager.getConnection();
	
	public static ValidRatingBean ValidRating(ValidRatingBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;

		/*** Prepare SQL query statement ***/
		String sql = "SELECT Booking_id FROM Feedback1 WHERE Booking_id  = '" + bean.getBookingid() + "';";
		System.out.print(sql);
//		System.out.println("select query");
		try {
			/*** Open SQL connection ***/
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();

			/*** Execute SQL statement ***/
			rs = stmt.executeQuery(sql);

			/*** Check for query result ***/

			boolean more = rs.next();
			if (!more) {
				/*** no record ***/
				System.out.println("new");
				bean.setStatus(false);

			} else {
				/*** else, existing record ***/
				System.out.println("repeated");
				bean.setStatus(true);
				
			}

			/*** Set the return status ***/
		} catch (Exception ex) {
			bean.setStatus(false);

			/*** Output error message for debugging purposes ***/
			System.out.println("selectQuery failed: An Exception has occurred! " + ex);
		}

		/*** IMPORTANT: Remember to close all SQL connection ***/
		if (currentCon != null) {
			try {
				currentCon.close();
			} catch (Exception ex) {
			}
			currentCon = null;
		}

		/*** Return status to the caller ***/
		return bean;
	}

}
