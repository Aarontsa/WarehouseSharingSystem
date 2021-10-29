package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.ChatBean;
import my.com.Wshare.ConnManager;

public class ChatDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static ChatBean selectQuery(ChatBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
//			String sql = "SELECT Chat_id, UserP_id, UserS_id, User_Mgs, Chat_date FROM Chat2 WHERE  UserP_id =(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsername() + "'AND User_Passwords = '" + bean.getCPasswords() +"');";// select
			String sql = "SELECT Chat_id, Chatlist_id User_id, User_name, User_Mgs, Chat_date FROM chat;";// select

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

	public static void insertQuery(ChatBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO chat (  Chatlist_id, User_id, User_name, User_Mgs, Chat_date ) VALUES ( '" + bean.getChatlist_id() +"',(SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsername() +"' AND User_Passwords = '" + bean.getCPasswords() +"'),'" + bean.getCUsername() +"','" + bean.getUser_Mgs() +"',getdate());";
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
