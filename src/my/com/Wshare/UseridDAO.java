package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


//import my.com.Wshare.ConnManager;
import my.com.Wshare.UseridBean;

public class UseridDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getUserid(UseridBean bean) {
		Statement stmt = null;
		String sql = "SELECT User_id FROM UserLogin2 WHERE User_Name  = '" + bean.getCUsernameS() + "' and User_Passwords  = '" + bean.getCPasswordsS() + "';";
		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String User_id = rs.getString("User_id");


				list += "<input type=\"hidden\" id=\"CUserid\" value=\""+User_id+"\">";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getUserid failed: An Exception has occurred! " + ex);
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
