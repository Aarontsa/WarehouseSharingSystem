package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
//import my.com.Wshare.RecommandBean;

public class RecommandDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public String getRecommand() {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;

		/*** Prepare SQL query statement ***/
		String sql = "SELECT User_id, UserS_id, Feedback_Rate FROM Feedback1;";
		System.out.print(sql);
		String list = "[";
//		System.out.println("select query");
		try {
			/*** Open SQL connection ***/
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();

			/*** Execute SQL statement ***/
			rs = stmt.executeQuery(sql);

			/*** Check for query result ***/
//			int count = 0;
			int first = 0;
			while (rs.next()) {
				if(first != 0) {
					list += ",";
				}
				String Userid = rs.getString("User_id");
				String UserS_id = rs.getString("UserS_id");
				String Feedback_Rate = rs.getString("Feedback_Rate");


				list += "{User:"+Userid+", Storage:"+UserS_id+", Rate:"+Feedback_Rate+"}";
				first = 1;

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("failed: An Exception has occurred! " + ex);
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

