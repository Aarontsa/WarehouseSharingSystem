package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import my.com.Wshare.ConnManager;
//import my.com.Wshare.MapBean;

public class MapDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;
	
	public String getmarker() {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;

		/*** Prepare SQL query statement ***/
		String sql = "SELECT User_id, User_Name, Latitude, Longtitude FROM UserLogin2 WHERE User_Type='storage';";
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
				String Username = rs.getString("User_Name");
				String Latitude = rs.getString("Latitude");
				String Longtitude = rs.getString("Longtitude");

				list += "["+Userid+",\""+Username+"\","+Latitude+","+Longtitude+"]";
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

