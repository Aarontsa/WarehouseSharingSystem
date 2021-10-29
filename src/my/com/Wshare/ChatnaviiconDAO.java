package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import my.com.Wshare.ConnManager;
import my.com.Wshare.ChatnaviiconBean;

public class ChatnaviiconDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getChatcount(ChatnaviiconBean bean) {
		Statement stmt = null;
		String sql = "SELECT count(Chatlist_id) AS UNREAD FROM chatlist WHERE ((Chatlist_status != (select User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsername() +"' and User_Passwords = '" + bean.getCPasswords() + "')) and Chatlist_status != '0' ) AND (UserP_id  = (select User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsername() + "' and User_Passwords = '" + bean.getCPasswords() + "') or UserS_id = (select User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsername() +"' and User_Passwords = '" + bean.getCPasswords() + "'));";
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String UNREAD = rs.getString("UNREAD");


				list += "<input type=\"hidden\" id=\"countmessage\" value=\""+UNREAD+"\">";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getChatcount failed: An Exception has occurred! " + ex);
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
