package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.RecommandStoragecountBean;

public class RecommandStoragecountDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getRecommandStoragecount() {
		Statement stmt = null;
		String sql = "SELECT User_id, User_Name, User_Gender, User_Mobile, User_Email, User_Address FROM UserLogin2 WHERE User_Type='storage';";// select
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 1;

			while (rs.next()) {
				int User_id = rs.getInt("User_id");
				String User_Name = rs.getString("User_Name");
				String User_Gender = rs.getString("User_Gender");
				String User_Mobile = rs.getString("User_Mobile");
//				String User_Email = rs.getString("User_Email");
				String User_Address = rs.getString("User_Address");
//				String rate = rs.getString("rate");
//				String numberrate = rs.getString("numberrate");
//				String space = rs.getString("space");
//				String User_Description = rs.getString("User_Description");
				int timelooping = count++;
				System.out.println(User_Gender);
				
				list += "<div id=\"count" + User_id + "-"+timelooping+"\" class=\"bttn-containercount\" value=\"" + User_id + "\" name=\"filter\">";
//				list += "<div class=\"" + UserS_id + "\" id=\"" + UserS_id + "\">";
				list += "<p id=\"User_Name\" style=\"font-weight:bold;\"> Storage:" + User_Name + "</p>";
//				list += "<p id=\"User_Image\" style=\"font-weight:bold;\">" + User_Gender + "</p>";
				list += "<p id=\"User_Mobile\" style=\"font-weight:bold;\"> Mobile:" + User_Mobile + "</p>";
				list += "<p id=\"User_Address\" style=\"font-weight:bold;\"> Address:" + User_Address + "</p>";
				list += "<input type=\"hidden\" id=\"User_id\" value="+ User_id +">";
				list += "<input type=\"hidden\" id=\"User_Name\" value="+ User_Name +">";
//				list += "</div>";
				list += "</div>";
				// list += "<br>";				

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getRecommandStoragecount failed: An Exception has occurred! " + ex);
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
