package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.RegistersizeBean;
import my.com.Wshare.ConnManager;

public class RegistersizeDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static RegistersizeBean selectQuery(RegistersizeBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT Storage_id, User_id, Storage_size FROM Storage;";// select
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

	public static void insertQuery(RegistersizeBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO Storage (User_id, Storage_size) VALUES ((SELECT User_id FROM UserLogin2 where User_Name ='" + bean.getUsername() + "' and User_Passwords = '" + bean.getPasswords() + "'),'" + bean.getStorage_size() + "'); ";
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
