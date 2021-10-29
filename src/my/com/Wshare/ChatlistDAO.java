package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.ChatlistBean;

public class ChatlistDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getChatlist(ChatlistBean bean) {
		Statement stmt = null;
//		String sql = "SELECT Distinct UserP_id, UserS_id  FROM Chat2 WHERE  (UserP_id =(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsernameS() + "'AND User_Passwords = '" + bean.getCPasswordsS() + "') or UserS_id=(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsernameS() + "'AND User_Passwords = '" + bean.getCPasswordsS() + "'));";// select
		String sql = "SELECT Chatlist_id, UserP_id, UserS_id, (select User_Name from UserLogin2 where User_id=UserS_id) as name, (select User_Name from UserLogin2 where User_id=UserP_id) as name2 FROM chatlist WHERE  (UserP_id =(SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsernameS() + "'AND User_Passwords = '" + bean.getCPasswordsS() + "') or UserS_id=(SELECT  User_id FROM UserLogin2 WHERE User_Name = '" + bean.getCUsernameS() + "'AND User_Passwords = '" + bean.getCPasswordsS() + "'));";// select
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;

			while (rs.next()) {
				String UserP_id = rs.getString("UserP_id");
				String UserS_id = rs.getString("UserS_id");
				String Chatlist_id = rs.getString("Chatlist_id");
				String name = rs.getString("name");
				String name2 = rs.getString("name2");
				int timelooping = count++;

				list += "<div id=\"" + UserS_id + "-"+timelooping+"\" class=\"bttn-containerchat\" value=\"" + Chatlist_id + "\" name=\"filter\">";
				list += "<p hidden id=\"UserP_id\" value=\"" + UserS_id + "\">From:" + UserP_id + "</p>";
				list += "<p id=\"name\" style=\"font-weight:bold;\"> " + name +"-"+ name2 +  "<img id=\""+Chatlist_id+"-"+timelooping+"\" class=\"newsss\" src=\"./img/new-post-16.png\" alt=\"\"></p>";
//				list += "<p id=\"name2\" style=\"font-weight:bold;\"> User:" + name2 + "<img id=\""+Chatlist_id+"\" class=\"newsss\" src=\"./img/circler-16.png\" alt=\"\"></p>";
//				list += "<p id=\"name\">" + bean.getCUsernameS() + "</p>";
				list += "<input type=\"hidden\" id=\"UserS_id\" value="+ Chatlist_id +">";
//				list += "</div>";
				list += "</div>";
//				list += "<input type=\"hidden\" id=\"UserS_id\" value="+ UserS_id +">";
//				list += "<p hidden id=\"UserS_id\">To:" + UserS_id + "</p>";
//				list += "<div class=\"" + UserS_id + "\" id=\"" + UserS_id + "\">";
				// list += "<br>";


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getChatlist failed: An Exception has occurred! " + ex);
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
