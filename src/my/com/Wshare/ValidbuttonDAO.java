package my.com.Wshare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
import my.com.Wshare.ValidbuttonBean;

public class ValidbuttonDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
//	static ConnManager conn = new ConnManager();
//	static Connection currentCon = ConnManager.getConnection();
	
	public static ValidbuttonBean Validbutton(ValidbuttonBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;

		/*** Prepare SQL query statement ***/
		String sql = "SELECT User_id, User_Name FROM UserLogin2 WHERE User_Name  = '" + bean.getUsername() + "' and User_Type = 'nostorage';";
		System.out.print(sql);
		System.out.println("select query");
		try {
			/*** Open SQL connection ***/
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();

			/*** Execute SQL statement ***/
			rs = stmt.executeQuery(sql);

			/*** Check for query result ***/

			boolean more = rs.next();
			if (!more) {
				/*** else, existing record ***/
				System.out.println("Show");
				bean.setStatus(true);
			} else {
				/*** no record ***/
				System.out.println("hide");
				bean.setStatus(false);

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
