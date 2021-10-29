package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.UpdatestatusBean;
import my.com.Wshare.ConnManager;

public class UpdatestatusDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static UpdatestatusBean selectQuery(UpdatestatusBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT User_Status FROM UserLogin2 WHERE User_Name  = '" + bean.getUsername() + "' AND User_Passwords = '" + bean.getPasswords() + "';";// select
			System.out.print(sql);	
			// statement*************

			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
			}

			boolean more = rs.next();
			if (!more) {
				updateQuery(bean);
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

	public static void updateQuery(UpdatestatusBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("update query");
		try {
			String sql = "UPDATE UserLogin2 SET User_Status = '" + bean.getUser_Status() + "'WHERE User_Name  = '" + bean.getUsername() + "' AND User_Passwords = '" + bean.getPasswords() + "';";
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
