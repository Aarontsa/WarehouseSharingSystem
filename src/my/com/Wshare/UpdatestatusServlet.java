package my.com.Wshare;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import my.com.Wshare.UpdatestatusBean;
import my.com.Wshare.UpdatestatusDAO;
import my.com.Wshare.Sanitizer;


//@WebServlet("/HomeServlet")
public class UpdatestatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public UpdatestatusServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
//			String CUsernameS = request.getParameter("CUsername");
//			String CPasswordsS = request.getParameter("CPasswords");
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			String User_Status = request.getParameter("User_Status");
//			int MobilenumberS = Integer.parseInt(request.getParameter("Mobilenumber"));
//			String AddressS = request.getParameter("Address");
//			String DescriptionS = request.getParameter("Description");
//			String imgS = request.getParameter("img");
//			String usertypeS = request.getParameter("usertype");
//			Float latitudeS=Float.parseFloat(request.getParameter("latitude"));
//			Float longtitudeS=Float.parseFloat(request.getParameter("longtitude"));
			System.out.println(User_Status);
			/*** Sanitize special characters - String variables only ***/
//			String clean_CUsernameS = new Sanitizer().sanitize(CUsernameS);
//			String clean_CPasswordsS = new Sanitizer().sanitize(CPasswordsS);
			String clean_Username = new Sanitizer().sanitize(Username);
			String clean_Passwords = new Sanitizer().sanitize(Passwords);
			String clean_User_Status = new Sanitizer().sanitize(User_Status);



			/*** Create a bean to temporary hold the data ***/
			UpdatestatusBean bean = new UpdatestatusBean();
//			bean.SetCUsernameS(clean_CUsernameS);
//			bean.SetCPasswordsS(clean_CPasswordsS);
			bean.SetUsername(clean_Username);
			bean.SetPasswords(clean_Passwords);
			bean.SetUser_Status(clean_User_Status);
//			bean.SetMobilenumberS(MobilenumberS);
//			bean.SetAddressS(AddressS);
//			bean.SetDescriptionS(clean_DescriptionS);
//			bean.SetimgS(imgS);
//			bean.SetusertypeS(usertypeS);
//			bean.SetlatitudeS(latitudeS);
//			bean.SetlongtitudeS(longtitudeS);

			/*** Pass the bean to DAO for processing ***/
			bean = UpdatestatusDAO.selectQuery(bean);

			if (bean.getStatus()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", bean);
				// System.out.println(valid);
				System.out.println(bean.getStatus());
				return;

			}

			else {

				System.out.println(bean.getStatus());

			}
			/*** Convert the result to JSON format and return to the UI ***/

			String json = new Gson().toJson(bean);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			
//			response.getWriter().write("Accepted");
//			System.out.println(bean);

		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}
}
