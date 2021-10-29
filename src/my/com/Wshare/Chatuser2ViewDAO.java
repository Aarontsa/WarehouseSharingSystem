package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.Chatuser2ViewBean;

public class Chatuser2ViewDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getChatuser2(Chatuser2ViewBean bean) {
		Statement stmt = null;
//		String sql = "SELECT User_Name, User_Status FROM UserLogin2 WHERE User_id = (SELECT DISTINCT (UserS_id) FROM chatlist WHERE Chatlist_id = '"+bean.getChatlist_id()+"'); ";
		String sql = "SELECT (SELECT User_Name FROM UserLogin2 WHERE User_id =UserP_id) as name1, (SELECT User_Status FROM UserLogin2 WHERE User_id =UserP_id) as status1,(SELECT User_Name FROM UserLogin2 WHERE User_id =UserS_id) as name2, (SELECT User_Status FROM UserLogin2 WHERE User_id =UserS_id) as status2 FROM Chatlist WHERE  Chatlist_id = '"+bean.getChatlist_id()+"';";
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 0;

			while (rs.next()) {
				String name1 = rs.getString("name1");
				String status1 = rs.getString("status1");
				String name2 = rs.getString("name2");
				String status2 = rs.getString("status2");
//				String Chat_date = rs.getString("Chat_date");
//				String current_name = rs.getString("current_name");
//				int timelooping = count++;


				list += "<div id=\"messagepeoplebackground\" class=\"messagepeoplebackground\">";
				list += "<center><p class=\"useractivename\">"+name1+"&nbsp;<img id=\"offlineuser\" class=\"newsss\" src=\"./img/circler-16.png\" alt=\"\"><img id=\"onlineuser\" class=\"newsss\" src=\"./img/circleg-16.png\" alt=\"\"></p></center>";
				list += "<input id=\"userstatus\" name=\"userstatus\" type=\"hidden\" value=\""+status1+"\">";
				list += "<center><p class=\"useractivename\">"+name2+"&nbsp;<img id=\"offlineuser1\" class=\"newsss\" src=\"./img/circler-16.png\" alt=\"\"><img id=\"onlineuser1\" class=\"newsss\" src=\"./img/circleg-16.png\" alt=\"\"></p></center>";
				list += "<input id=\"userstatus1\" name=\"userstatus\" type=\"hidden\" value=\""+status2+"\">";
				list += "</div>";
				
				
				


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getChatuser2 failed: An Exception has occurred! " + ex);
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
