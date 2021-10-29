package my.com.Wshare;

import java.sql.Connection;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import my.com.Wshare.AdminuserreportBean;
import my.com.Wshare.ConnManager;



public class AdminuserreportDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getuserReportDetails() {
		Statement stmt = null;
		String sql = "SELECT (SELECT COUNT(Booking_id) FROM Booking1 WHERE Booking_Date BETWEEN '2019/01/01' AND '2019/03/31') AS '1QBOOK'," + 
				"(SELECT COUNT(Booking_id) FROM Booking1 WHERE Booking_Date BETWEEN '2019/04/01' AND '2019/06/30') AS '2QBOOK'," + 
				"(SELECT COUNT(Booking_id) FROM Booking1 WHERE Booking_Date BETWEEN '2019/07/01' AND '2019/09/30') AS '3QBOOK'," + 
				"(SELECT COUNT(Booking_id) FROM Booking1 WHERE Booking_Date BETWEEN '2019/10/01' AND '2019/12/31') AS '4QBOOK'," + 
				"(SELECT COUNT(Booking_id) FROM Booking1 WHERE Booking_Date BETWEEN '2019/01/01' AND '2019/12/31') AS '1YBOOK'," + 
				"(SELECT ISNULL(SUM(Payment_Amount),0) FROM Booking1 WHERE Booking_Date BETWEEN '2019/01/01' AND '2019/03/31') AS '1Qpayment'," + 
				"(SELECT ISNULL(SUM(Payment_Amount),0) FROM Booking1 WHERE Booking_Date BETWEEN '2019/04/01' AND '2019/06/30') AS '2Qpayment'," + 
				"(SELECT ISNULL(SUM(Payment_Amount),0) FROM Booking1 WHERE Booking_Date BETWEEN '2019/07/01' AND '2019/09/30') AS '3Qpayment'," + 
				"(SELECT ISNULL(SUM(Payment_Amount),0) FROM Booking1 WHERE Booking_Date BETWEEN '2019/10/01' AND '2019/12/31') AS '4Qpayment'," + 
				"(SELECT ISNULL(SUM(Payment_Amount),0) FROM Booking1 WHERE Booking_Date BETWEEN '2019/01/01' AND '2019/12/31') AS '1Ypayment';";// select
																																																																	// statement*************

		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String FirstQBOOK = rs.getString("1QBOOK");
				String SecondQBOOK = rs.getString("2QBOOK");
				String ThirdQBOOK = rs.getString("3QBOOK");
				String FourthQBOOK = rs.getString("4QBOOK");
				String OneYBOOK = rs.getString("1YBOOK");
				String FirstQpayment = rs.getString("1Qpayment");
				String SecondQpayment = rs.getString("2Qpayment");
				String ThirdQpayment = rs.getString("3Qpayment");
				String FourthQpayment = rs.getString("4Qpayment");
				String OneYpayment = rs.getString("1Ypayment");

				list += "<tr><td class=\"size\">" + FirstQBOOK + "</td>";
				list += "	<td class=\"size\">" + SecondQBOOK + "</td>";
				list += "	<td class=\"size\">" + ThirdQBOOK + "</td>";
				list += "	<td class=\"size\">" + FourthQBOOK + "</td>";
				list += "	<td class=\"size\" style=\"background: lightslategray;\">" + OneYBOOK + "</td>";
				list += "	<td class=\"size\">" + FirstQpayment + "</td>";
				list += "	<td class=\"size\">" + SecondQpayment + "</td>";
				list += "	<td class=\"size\">" + ThirdQpayment + "</td>";
				list += "	<td class=\"size\">" + FourthQpayment + "</td>";
				list += "	<td class=\"size\" style=\"background: lightslategray;\">" + OneYpayment + "</td>";
				list += "	</tr>";

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getuserReportDetails failed: An Exception has occurred! " + ex);
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
