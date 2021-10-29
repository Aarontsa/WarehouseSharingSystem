package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.EditstorageSaveBean;
import my.com.Wshare.ConnManager;

public class EditstorageSaveDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static EditstorageSaveBean selectQuery(EditstorageSaveBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT Storage_id, User_id, Storage_size FROM Storage WHERE User_id = (SELECT User_id FROM UserLogin2 WHERE User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "');";// select
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

	public static void updateQuery(EditstorageSaveBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("update query");
		try {
			String sql = "UPDATE Storage SET Storage_size = '" + bean.getStorage_size() + "' WHERE User_id = (SELECT User_id FROM UserLogin2 WHERE User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "');";
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
