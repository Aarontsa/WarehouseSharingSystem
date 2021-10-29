package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.ForgetgetpasswordsBean;

public class ForgetgetpasswordsDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getpasswords(ForgetgetpasswordsBean bean) {
		Statement stmt = null;
		String sql = "SELECT User_Passwords FROM UserLogin2 WHERE User_Name  = '" + bean.getUsername() + "';";

		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);
			int count = 0;

			while (rs.next()) {
				String User_Passwords = rs.getString("User_Passwords");
				
//				list += "<br>";
//				list += "<input id=\"retrieve\" name=\"retrieve\" type=\"text\" value=\""+User_Passwords+"\">";
				list += "Passwords : "+User_Passwords+"";
//				list += "<br>";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getpasswords failed: An Exception has occurred! " + ex);
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
