package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.RegisterBean;
import my.com.Wshare.ConnManager;

public class RegisterDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static RegisterBean selectQuery(RegisterBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT User_Name, User_Gender, User_Passwords, User_Mobile, User_Email, User_Address, Latitude, Longtitude, User_Description, User_Type FROM UserLogin2;";// select
			System.out.print(sql);																																																					// statement*************

			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
			}

			boolean more = rs.next();
			if (!more) {
				insertQuery(bean);
			}
			bean.setStatus(true);
		} catch (Exception ex) {
			bean.setStatus(false);
			System.out.println("selectQuery failed: " + ex);
		}

		finally {
			if (currentCon != null) {
				try {
					currentCon.close();
				} catch (Exception ex) {
				}
			}
			currentCon = null;
		}
		return bean;
	}

	public static void insertQuery(RegisterBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("insert query");
		try {
			String sql = "INSERT INTO UserLogin2 (User_Name, User_Gender, User_Passwords, User_Mobile, User_Email, User_Address, Latitude, Longtitude, User_Description, User_Type) VALUES "
					+ "('" + bean.getUsername() + "','" + bean.getimg() + "','" + bean.getPasswords() + "','" + bean.getMobilenumber()
										+ "','" + bean.getEmail() + "','" + bean.getAddress() + "','" + bean.getlatitude() + "','"
										+ bean.getlongtitude() + "','" + bean.getDescription() +"','" + bean.getusertype() +"')";
			System.out.print(sql);
			// select statement*************
			
			localCon.createStatement().executeUpdate(sql);

		} catch (Exception ex) {
			System.out.println("Insert record failed:" + ex);
		} finally {
			if (localCon != null) {
				try {
					localCon.close();
				} catch (Exception ex) {
				}
			}
			localCon = null;
		}
	}

}
