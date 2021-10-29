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

import my.com.Wshare.EditBean;
import my.com.Wshare.EditDAO;
import my.com.Wshare.Sanitizer;
import my.com.Wshare.EditSaveBean;
import my.com.Wshare.EditSaveDAO;

//@WebServlet("/HomeServlet")
public class EditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public EditServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
			String UsernameS = request.getParameter("Username");
			String PasswordsS = request.getParameter("Passwords");
			String EmailS = request.getParameter("Email");
			int MobilenumberS = Integer.parseInt(request.getParameter("Mobilenumber"));
			String AddressS = request.getParameter("Address");
			String DescriptionS = request.getParameter("Description");
			String imgS = request.getParameter("img");
			String usertypeS = request.getParameter("usertype");
			Float latitudeS=Float.parseFloat(request.getParameter("latitude"));
			Float longtitudeS=Float.parseFloat(request.getParameter("longtitude"));
			
			/*** Sanitize special characters - String variables only ***/
			String clean_CUsernameS = new Sanitizer().sanitize(CUsernameS);
			String clean_CPasswordsS = new Sanitizer().sanitize(CPasswordsS);
			String clean_UsernameS = new Sanitizer().sanitize(UsernameS);
			String clean_PasswordsS = new Sanitizer().sanitize(PasswordsS);
			String clean_DescriptionS = new Sanitizer().sanitize(DescriptionS);



			/*** Create a bean to temporary hold the data ***/
			EditSaveBean bean = new EditSaveBean();
			bean.SetCUsernameS(clean_CUsernameS);
			bean.SetCPasswordsS(clean_CPasswordsS);
			bean.SetUsernameS(clean_UsernameS);
			bean.SetPasswordsS(clean_PasswordsS);
			bean.SetEmailS(EmailS);
			bean.SetMobilenumberS(MobilenumberS);
			bean.SetAddressS(AddressS);
			bean.SetDescriptionS(clean_DescriptionS);
			bean.SetimgS(imgS);
			bean.SetusertypeS(usertypeS);
			bean.SetlatitudeS(latitudeS);
			bean.SetlongtitudeS(longtitudeS);

			/*** Pass the bean to DAO for processing ***/
			bean = EditSaveDAO.selectQuery(bean);

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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
			System.out.println("edit"+CUsernameS);
			System.out.println("edit"+CPasswordsS);
			
			/*** Create a bean to temporary hold the data ***/
			EditBean bean = new EditBean();
			bean.SetCUsernameS(CUsernameS);
			bean.SetCPasswordsS(CPasswordsS);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = EditDAO.getUsers();
			
//			/*** Pass the bean to DAO for processing ***/
			EditDAO EditDAO = new EditDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = EditDAO.getUsers(bean);

			String json = new Gson().toJson(res);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			System.out.println(json);

		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}
}
