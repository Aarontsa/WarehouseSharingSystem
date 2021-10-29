package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.ChatViewBean;

public class CommentViewDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getCommentView(CommentViewBean bean) {
		Statement stmt = null;
//		String sql = "SELECT Chat_id, UserP_id,(SELECT  User_Name FROM UserLogin WHERE User_Name = '" + bean.getCUsername() +"'AND User_Passwords = '" + bean.getCPasswords() + "') as current_name, UserS_id, User_Mgs, Chat_date FROM Chat2 WHERE  UserP_id =(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsername() + "'AND User_Passwords = '" + bean.getCPasswords() + "') or  UserS_id =(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsername() + "'AND User_Passwords = '" + bean.getCPasswords() + "') ORDER BY Chat_date DESC;";// select
//		String sql = "SELECT Chat_id, UserP_id,(SELECT  User_Name FROM UserLogin WHERE User_Name = '" + bean.getCUsername() +"'AND User_Passwords = '" + bean.getCPasswords() + "') as current_name, UserS_id, User_Mgs, Chat_date FROM Chat2 WHERE  (UserP_id =(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsername() + "'AND User_Passwords = '" + bean.getCPasswords() + "') and UserS_id='"+ bean.getUserS_id()+"') or (UserP_id ='"+ bean.getUserS_id()+"' and UserS_id=(SELECT  User_id FROM UserLogin WHERE User_Name = '" + bean.getCUsername() + "'AND User_Passwords = '" + bean.getCPasswords() + "')) ORDER BY Chat_date DESC;";// select
		String sql = "select Feedback_Comment, Feedback_Date from Feedback1 where UserS_Id = '"+ bean.getCStorage_Userid()+"' ORDER BY Feedback_Date ASC;";

		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
//			int count = 0;

			while (rs.next()) {
				String Feedback_Comment = rs.getString("Feedback_Comment");
				String Feedback_Date = rs.getString("Feedback_Date");
//				String User_name = rs.getString("User_name");
//				String User_Mgs = rs.getString("User_Mgs");
//				String Chat_date = rs.getString("Chat_date");
//				String current_name = rs.getString("current_name");
//				int timelooping = count++;

				list += "<div class=\"bttn-containerH\" id=\"bttn-container\" name=\"filter\">";
				list += "<div class=\"test\" id=\"User_name\">";
//				list += "<p id=\"username\" style=\"font-weight: bold;\">User:" + User_name + "</p>";
				list += "<p id=\"date\" style=\"font-size: x-small; font-style:italic; color: grey;\">" + Feedback_Date + "</p>";
				list += "<p id=\"mgs\">"+ Feedback_Comment +"</p>";
				list += "<p id=\"\">___________________________</p>";
//				list += "<br>";
				list += "</div>";
				list += "</div>";
//				list += "<br>";


			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getCommentView failed: An Exception has occurred! " + ex);
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
