package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.ChaticonBean;

public class ChaticonDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getChaticon(ChaticonBean bean) {
		Statement stmt = null; 
//		String sql = "SELECT DISTINCT UserS_Id FROM Feedback1 where Feedback_Rate = 5;";// select
		String sql = "SELECT Chatlist_id, UserP_id, UserS_id, Chatlist_status FROM chatlist WHERE (Chatlist_status != (select User_id FROM UserLogin2 WHERE User_Name = '"+bean.getCUsername()+"' AND User_Passwords = '"+bean.getCPasswords()+"') AND Chatlist_status != '0') AND (UserP_id =(SELECT  User_id FROM UserLogin2 WHERE User_Name = '"+bean.getCUsername()+"' AND User_Passwords = '"+bean.getCPasswords()+"') or UserS_id=(SELECT  User_id FROM UserLogin2 WHERE User_Name = '"+bean.getCUsername()+"' AND User_Passwords = '"+bean.getCPasswords()+"'));";// select
		String list = "[";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 1;

			int first = 0;
			while (rs.next()) {
				if(first != 0) {
					list += ",";
				}
				String Chatlist_id = rs.getString("Chatlist_id");


				list += "\""+Chatlist_id+"\"";
				first = 1;

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getChaticon failed: An Exception has occurred! " + ex);
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
