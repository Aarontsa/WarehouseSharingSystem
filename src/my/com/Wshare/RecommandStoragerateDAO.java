package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.RecommandStoragerateBean;

public class RecommandStoragerateDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getRecommandStoragerate() {
		Statement stmt = null; 
//		String sql = "SELECT DISTINCT UserS_Id FROM Feedback1 where Feedback_Rate = 5;";// select
		String sql = "SELECT TOP 3 (ROUND(AVG(CAST(Feedback_Rate AS FLOAT)), 2)) AS rate, UserS_Id FROM Feedback1 GROUP BY UserS_Id having (ROUND(AVG(CAST(Feedback_Rate AS FLOAT)), 2)) >=4 order BY rate DESC;";// select
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
				String UserS_Id = rs.getString("UserS_Id");


				list += "\""+UserS_Id+"\"";
				first = 1;

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getRecommandStoragerate failed: An Exception has occurred! " + ex);
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
