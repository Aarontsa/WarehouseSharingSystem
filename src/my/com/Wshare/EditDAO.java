package my.com.Wshare;

import java.sql.Connection;
import java.sql.ResultSet;
//import java.sql.SQLException;
import java.sql.Statement;
import my.com.Wshare.ConnManager;
import my.com.Wshare.EditBean;

public class EditDAO {
	static Connection currentCon = null;
	static ResultSet rs = null;

	public String getUsers(EditBean bean) {
		Statement stmt = null;
		String sql = "SELECT User_Name, User_Gender, User_Passwords, User_Mobile, User_Email, User_Address, Latitude, Longtitude, User_Description, User_Type, (SELECT Storage_size FROM Storage WHERE User_id =( SELECT User_id FROM UserLogin2 WHERE User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "')) as Storage_size FROM UserLogin2 WHERE  User_Name  = '" + bean.getCUsernameS() + "' AND User_Passwords = '" + bean.getCPasswordsS() + "';";// select
		String list = "";

		try {
			currentCon = ConnManager.getConnection();
			stmt = currentCon.createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				String User_Name = rs.getString("User_Name");
				String User_Gender = rs.getString("User_Gender");
				String User_Passwords = rs.getString("User_Passwords");
				String User_Mobile = rs.getString("User_Mobile");
				String User_Email = rs.getString("User_Email");
				String User_Address = rs.getString("User_Address");
				String Latitude = rs.getString("Latitude");
				String Longtitude = rs.getString("Longtitude");
				String User_Description = rs.getString("User_Description");
				String User_Type = rs.getString("User_Type");
				String Storage_size = rs.getString("Storage_size");
				System.out.println("here"+User_Type);
//				list += "<p>"+User_Name+","+User_Image+","+User_Passwords+","+User_Mobile+","+User_Email+","+User_Address+","+Latitude+","+Longtitude+","+User_Description+"</p>";
				list += "<form class=\"registerform\">";
				list += "<p class=\"Profiledetailstitle\">User details</p>";
				list += "<table class=\"ScaleBorder\" id=\"editform\">";
				list += "<tr class=\"edit\">";
//				list += "<td></td>";
				list += "<td>Gender:</td>";
				list += "<td>";
				list += "<div id=\"wrapper\" class=\"wrapper\">";
//				list += "<div id=\"image-holder1\" class=\"profileimage\"><img id=\"ProfilePicture\" src=\"./img/user.png\" alt=\"your image\" /></div>";
				list += "<div id=\"image-holder2\" class=\"profileimage\"><img id=\"ProfilePicture\" src=\"./img/male.png\" alt=\"your image\" /></div>";
				list += "<div id=\"image-holder3\" class=\"profileimage\"><img id=\"ProfilePicture\" src=\"./img/female.png\" alt=\"your image\" /></div>";
				list += "<br>";				
				list += "<table id=\"S_q1_2_if_yes1\" class=\"Squestion2\">";
				list += "<input type=\"radio\" name=\"img\" value=\"male\" id=\"male\"><label for=\"male\">";
				list += "<div class=\"right\"><span></span>Male</div>";
				list += "</label>";
				list += "<input type=\"radio\" name=\"img\" value=\"female\" id=\"female\"><label for=\"female\">";
				list += "<div class=\"right\"><span></span>Female</div>";
				list += "</label>";
				list += "<input id=\"userimg\" name=\"userimg\" type=\"hidden\" value=\""+User_Gender+"\">";
				list += "</table>";
				list += "</div>";
				list += "</td>";
				list += "</tr>";				
				list += "<tr class=\"edit\">";
				list += "<td>User Type:</td>";
				list += "<td>";
				list += "<table id=\"S_q1_2_if_yes2\" class=\"Squestion2\">";
				list += "<input type=\"radio\" name=\"usertype\" value=\"nostorage\" id=\"nostorage\"><label for=\"nostorage\">";
				list += "<div class=\"right\"><span></span>User</div>";
				list += "</label>";
				list += "<input type=\"radio\" name=\"usertype\" value=\"storage\" id=\"storage\"><label for=\"storage\">";
				list += "<div class=\"right\"><span></span>Provider</div>";
				list += "</label>";
				list += "<input id=\"usercatogery\" name=\"usercatogery\" type=\"hidden\" value=\""+User_Type+"\">";
				list += "</table>";
				list += "</td>";
				list += "</tr>";
				list += "<tr id=\"ifstorage\"class=\"edit\">";
				list += "<td>Storage size:</td>";
				list += "<td>";
				list += "<table id=\"S_q1_2_if_yes3\" class=\"Squestion2\">";
                list += "</td>";
                list += "<input type=\"radio\" name=\"Storagesize\" value=\"Small(50cmx50cm)\" id=\"Small\"><label for=\"Small\"><div class=\"right\"><span></span>Small(50cmx50cm)</div></label>";
                list += "<input type=\"radio\" name=\"Storagesize\" value=\"Large(100cmx100cm)\" id=\"Large\"><label for=\"Large\"><div class=\"right\"><span></span>Large(100cmx100cm)</div></label>";
                list += "<input id=\"Storage_size\" name=\"Storage_size\" type=\"hidden\" value=\""+Storage_size+"\">";
                list += "</table>";
                list += "</td>";
                list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Username:</td>";
				list += "<td><input id=\"Username\" type=\"text\" name=\"Username\" disabled=\"disabled\" value=\""+User_Name+"\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Passwords:</td>";
				list += "<td><input id=\"Passwords\" type=\"text\" name=\"Passwords\" value=\""+User_Passwords+"\" maxlength=\"20\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>E-mail:</td>";
				list += "<td><input id=\"Email\" type=\"text\" name=\"Email\" value=\""+User_Email+"\" maxlength=\"49\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Mobile number:</td>";
				list += "<td><input id=\"Mobilenumber\" type=\"text\" name=\"Mobilenumber\" value=\"0"+User_Mobile+"\" maxlength=\"10\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Home address:</td>";
				list += "<td><input type=\"text\" id=\"Address\" name=\"Homeaddress\" value=\""+User_Address+"\" maxlength=\"199\"></td>";
				list += "</tr>";
				list += "<tr class=\"edit\">";
				list += "<td>Description:</td>";
				list += "<td><input type=\"text\" id=\"Description\" name=\"Description\" value=\""+User_Description+"\" maxlength=\"199\" ></td> </tr> </table> <br>";
				list += "<center>";
				list += "<div hidden id=\"map\" class=\"mapsize\"></div>";
				list += "</center>";
				list += "<br>";
				list += "<input type=\"hidden\" id=\"CUsername\" value=\"\">";
				list += "<input type=\"hidden\" id=\"CPasswords\" value=\"\">";
//				list += "<br>";
				list += "<input id=\"lat\" type=\"hidden\" value=\""+Latitude+"\">";
//				list += "<br>";
				list += "<input id=\"lng\" type=\"hidden\" value=\""+Longtitude+"\">";
//				list += "<br><br>";
				list += "<div id=\"contner-block\"></div>";
				list += "<center>";
				list += "<div id=\"backbutton\" class=\"backbutton\" type=\"submit\" value=\"Back\"><a></a>Back</div>&nbsp;&nbsp;";
				list += "<div id=\"Saveeditbutton\" class=\"Saveeditbutton\" type=\"submit\" value=\"Saveedit\"><a></a>Save</div>";
				list += "</center>";
				list += "<br><br>";
				list += "</form>";



			}
			System.out.println(list);
		} catch (Exception ex) {
			System.out.println("getOrientationDetails failed: An Exception has occurred! " + ex);
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
