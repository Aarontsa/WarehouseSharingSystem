package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.StorageBean;

public class StorageDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getUsersDetails(StorageBean bean) {
		Statement stmt = null;
//		String sql = "SELECT User_id, User_Name, User_Gender, User_Mobile, User_Email, User_Address, User_Description, (SELECT (ROUND(AVG(CAST(Feedback_Rate AS FLOAT)), 2)) AS rate FROM Feedback1 WHERE UserS_Id = '" + bean.getCStorage_Userid() + "') as rate, (SELECT count(Feedback_Rate) FROM Feedback1 WHERE UserS_Id = '" + bean.getCStorage_Userid() + "') as numberrate, (3-(SELECT count(Booking_Date) FROM Booking1 WHERE UserS_Id = '" + bean.getCStorage_Userid() + "' and Booking_Date >= DATEADD(day,-1, GETDATE()) AND Booking_Date <= DATEADD(day,0, GETDATE()))) as space FROM UserLogin2 WHERE User_id = '" + bean.getCStorage_Userid() + "';";// select
		String sql = "SELECT User_id, User_Name, User_Gender, User_Mobile, User_Email, User_Address, User_Description, (SELECT (ROUND(AVG(CAST(Feedback_Rate AS FLOAT)), 2)) AS rate FROM Feedback1 WHERE UserS_Id = '" + bean.getCStorage_Userid() + "') as rate, (SELECT count(Feedback_Rate) FROM Feedback1 WHERE UserS_Id = '" + bean.getCStorage_Userid() + "') as numberrate,"
				+ "(SELECT COUNT(Booking_id) FROM Booking1 where (UserS_id= '" + bean.getCStorage_Userid() + "' AND Storage_size = 'Small(50cmx50cm)'AND (Booking_Checkin BETWEEN  Convert(date, getdate())  AND  Convert(date, getdate())  or Booking_Checkout BETWEEN  Convert(date, getdate())  AND  Convert(date, getdate()) )) or ( UserS_id= '" + bean.getCStorage_Userid() + "' AND Storage_size = 'Small(50cmx50cm)' AND (Booking_Checkin <=  Convert(date, getdate())  AND Booking_Checkout >=  Convert(date, getdate()) ))) as spacecount,"
				+ "(SELECT COUNT(Booking_id) FROM Booking1 where (UserS_id= '" + bean.getCStorage_Userid() + "' AND Storage_size = 'Large(100cmx100cm)'AND (Booking_Checkin BETWEEN Convert(date, getdate())  AND Convert(date, getdate())  or Booking_Checkout BETWEEN Convert(date, getdate())  AND Convert(date, getdate()) )) or ( UserS_id= '" + bean.getCStorage_Userid() + "' AND Storage_size = 'Large(100cmx100cm)' AND (Booking_Checkin <= Convert(date, getdate())  AND Booking_Checkout >= Convert(date, getdate()) )))as spacecount1 FROM UserLogin2 WHERE User_id = '" + bean.getCStorage_Userid() + "';";// select

		String list = "";
		System.out.println(sql);
		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				int User_id = rs.getInt("User_id");
				String User_Name = rs.getString("User_Name");
				String User_Gender = rs.getString("User_Gender");
				String User_Mobile = rs.getString("User_Mobile");
				String User_Email = rs.getString("User_Email");
				String User_Address = rs.getString("User_Address");
				String rate = rs.getString("rate");
				String numberrate = rs.getString("numberrate");
				String spacecount = rs.getString("spacecount");
				String spacecount1 = rs.getString("spacecount1");
				String User_Description = rs.getString("User_Description");
//				String spaceleft = (3 - space);
				System.out.println(User_Gender);
				
//				list += "<p>"+User_Name+","+User_Image+","+User_Passwords+","+User_Mobile+","+User_Email+","+User_Address+","+Latitude+","+Longtitude+","+User_Description+"</p>";
				list += "<form class=\"Storageviewform\">";
				list += "<p id=\"\" class=\"storagedetailstitle\">Storage Details</p>";
				list += "<table class=\"ScaleBorder\" id=\"Storageform\">";
				list += "<tr class=\"edit\">";
				list += "<td></td><td><div id=\"wrapper\" class=\"wrapper\">";
//				list += "<div id=\"image-holder\" class=\"profileimage\" ><img id=\"ProfilePicture\" src=\"./img/user icon.png\" alt=\"your image\" /></div>";
				list += "<div id=\"image-holder2\" class=\"profileimage\"><img id=\"ProfilePicture\" src=\"./img/male.png\" alt=\"your image\" /></div>";
				list += "<div id=\"image-holder3\" class=\"profileimage\"><img id=\"ProfilePicture\" src=\"./img/female.png\" alt=\"your image\" /></div>";
				list += "<br>";
				list += "<input id=\"fileUpload\" name=\"fileUpload1\" multiple=\"multiple\" type=\"hidden\" value=\""+User_Gender+"\"/>"; 
				list += "</div></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td></td>";
				list += "<td>";
				list += "<div class=\"starwrapper\">";
				list += "<input disabled selected type=\"radio\" id=\"r1\" name=\"rg1\" value=\"1\">";
				list += "<label for=\"r1\">&#9733;</label>";
				list += "<input disabled selected type=\"radio\" id=\"r2\" name=\"rg2\" value=\"2\">";
				list += "<label for=\"r2\">&#9733;</label>";
				list += "<input disabled selected type=\"radio\" id=\"r3\" name=\"rg3\" value=\"3\">";
				list += "<label for=\"r3\">&#9733;</label>";
				list += "<input disabled selected type=\"radio\" id=\"r4\" name=\"rg4\" value=\"4\">";
				list += "<label for=\"r4\">&#9733;</label>";
				list += "<input disabled selected type=\"radio\" id=\"r5\" name=\"rg5\" value=\"5\">";
				list += "<label for=\"r5\">&#9733;</label>";
//				list += "<p>Review:"+numberrate+"</p>";
				list += "</div>";
//				list += "<center><p>Review:"+numberrate+"</p></center>";
				list += "<input id=\"storagerating\" name=\"storagerating\" type=\"hidden\" value=\""+rate+"\"/>";
				list += "</td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td><input type=\"hidden\" name=\"review\" disabled=\"disabled\" value=\""+numberrate+"\"></td><td><center><p class=\"hometxt\">Review:"+numberrate+"</p></center></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td></td><td>";
//				list += "<br><br>";
				list += "<center><a id=\"whatsapp\" class=\"whatsapp\" ><img class=\"whatsapp\" src=\"./img/wa48.png\" value=\""+User_Mobile+"\"></img></a>";
				list += "<div id=\"Chatbutton\" class=\"Chatbutton\" type=\"submit\" value=\""+User_Mobile+"\"><a></a>Chat</div>&nbsp;&nbsp;";
				list += "<div id=\"Bookbutton\" class=\"Bookbutton\" type=\"submit\" value=\"Book\"><a ></a>Book</div></center><br><br>";
//				list += "<center><p id=\"spacefull\" class=\"hometxtspace\">Space left: Full</p></center>";
//				list += "<center><p id=\"spaceXfull\" class=\"hometxtspace\">Space left: Available</p></center>";
				list += "</td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td></td><td><input type=\"hidden\" id=\"space\" name=\"space\" disabled=\"disabled\" value=\""+spacecount+"\"></td>";
				list += "<td></td><td><input type=\"hidden\" id=\"space1\" name=\"space1\" disabled=\"disabled\" value=\""+spacecount1+"\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Username:</td><td><input type=\"text\" id=\"StorageUsername\" name=\"StorageUsername\" disabled=\"disabled\" value=\""+User_Name+"\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>E-mail:</td><td><input type=\"text\" id=\"UserEmail\" name=\"UserEmail\" disabled=\"disabled\" value=\""+User_Email+"\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Address:</td><td><input type=\"text\" id=\"Homeaddress\"  name=\"Homeaddress\" disabled=\"disabled\" value=\""+User_Address+"\">&nbsp;&nbsp;<div id=\"Copyaddressbutton\" class=\"Copybutton\" type=\"text\" value=\"\"><a></a>Copy</div></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Mobile number:</td><td><input type=\"text\" id=\"Mobilenumber\" class=\"MobilenumberS\" name=\"Mobilenumber\" disabled=\"disabled\" value=\"0"+User_Mobile+"\">&nbsp;&nbsp;<div id=\"Copymobilenumberbutton\" class=\"Copybutton\" type=\"text\" value=\"\"><a></a>Copy</div></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Description:</td><td><input type=\"text\" id=\"Description\" name=\"Description\" disabled=\"disabled\" value=\""+User_Description+"\"></td>";
				list += "</tr>";
				list += "</table>";
				list += "<br>";
				list += "<input type=\"hidden\" id=\"StorageUserid\" name=\"StorageUserid\" value=\""+ User_id +"\">";
				list += "<input type=\"hidden\" id=\"Mobilenumberwa\" name=\"Mobilenumber\" disabled=\"disabled\" value=\""+User_Mobile+"\" style=\"width:84%;\">";

//				list += "<br>";
//				list += "Userid:<input type=\"hidden\" name=\"Userid\" value=\"\">";
//				list += "<br><br>";
//				list += "<center><div id=\"backbutton\" class=\"backbutton\" type=\"submit\" value=\"Back\"><a></a>Back</div></center>";
//				list += "<br><br>";
				list += "</form>";
				

			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getUserDetails failed: An Exception has occurred! " + ex);
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
