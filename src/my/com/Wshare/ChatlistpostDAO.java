package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.ChatlistpostBean;
import my.com.Wshare.ConnManager;

public class ChatlistpostDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ChatlistpostBean selectQuery(ChatlistpostBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT UserP_id, UserS_id, Chatlist_status FROM Chatlist;";// select
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

	public static void insertQuery(ChatlistpostBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO Chatlist (UserP_id, UserS_id, Chatlist_status) VALUES ((SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsername() +"' AND  User_Passwords =  '" + bean.getCPasswords() +"'),'" + bean.getUserS_id() +"','0');";
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
