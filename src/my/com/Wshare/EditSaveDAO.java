package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import my.com.Wshare.EditSaveBean;
import my.com.Wshare.ConnManager;

public class EditSaveDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public static EditSaveBean selectQuery(EditSaveBean bean) throws SQLException {
		currentCon = ConnManager.getConnection();
		Statement stmt = null;
		System.out.print("a");
		System.out.println("select query");
		try {
			String sql = "SELECT User_Name, User_Gender, User_Passwords, User_Mobile, User_Email, User_Address, Latitude, Longtitude, User_Description, User_Type FROM UserLogin2 WHERE  User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "';";// select
			System.out.print(sql);	
			// statement*************

			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
			}

			boolean more = rs.next();
			if (!more) {
				updateQuery(bean);
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

	public static void updateQuery(EditSaveBean bean) throws SQLException {
		Connection localCon = ConnManager.getConnection();
		// form
		System.out.println("update query");
		try {
			String sql = "UPDATE UserLogin2 SET User_Name = '" + bean.getUsernameS() + "', User_Gender ='" + bean.getimgS() + "', User_Passwords='" + bean.getPasswordsS() + "', User_Mobile='" + bean.getMobilenumberS()+"', User_Email='" + bean.getEmailS() + "'," + 
					" User_Address='" + bean.getAddressS() + "', Latitude='" + bean.getlatitudeS() + "', Longtitude='"+ bean.getlongtitudeS() + "', User_Description='" + bean.getDescriptionS() +"', User_Type='" + bean.getusertypeS() +"' WHERE User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "';";
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
