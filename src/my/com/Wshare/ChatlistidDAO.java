package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import my.com.Wshare.ConnManager;
import my.com.Wshare.ChatlistidBean;

public class ChatlistidDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getChatlistid(ChatlistidBean bean) {
		Statement stmt = null;
		String sql = "SELECT Chatlist_id FROM chatlist WHERE UserP_id  =(select User_id from UserLogin2 where User_name= '" + bean.getUsername() + "' and User_Passwords  = '" + bean.getPasswords() + "') and UserS_id = '" + bean.getCStorage_Userid() + "';";
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String Chatlist_id = rs.getString("Chatlist_id");


				list += "<input type=\"text\" id=\"Chatlistid\" value=\""+Chatlist_id+"\">";

			}
			System.out.println("whereeeee"+list);
		} catch (Exception ex) {
			System.out.println("getChatlistid failed: An Exception has occurred! " + ex);
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

		return list;
	}

}
