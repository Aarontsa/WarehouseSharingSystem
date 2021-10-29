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

import my.com.Wshare.EditstorageSaveBean;
import my.com.Wshare.EditstorageSaveDAO;
import my.com.Wshare.Sanitizer;


//@WebServlet("/HomeServlet")
public class EditstorageSaveServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public EditstorageSaveServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
//			String UsernameS = request.getParameter("Username");
//			String PasswordsS = request.getParameter("Passwords");
			String Storage_size = request.getParameter("Storage_size");
			System.out.println("edit"+CUsernameS);
			System.out.println(CPasswordsS);
			System.out.println(Storage_size);
			
			/*** Sanitize special characters - String variables only ***/
			String clean_CUsernameS = new Sanitizer().sanitize(CUsernameS);
			String clean_CPasswordsS = new Sanitizer().sanitize(CPasswordsS);
//			String clean_UsernameS = new Sanitizer().sanitize(UsernameS);
//			String clean_PasswordsS = new Sanitizer().sanitize(PasswordsS);
//			String clean_Storage_size = new Sanitizer().sanitize(Storage_size);



			/*** Create a bean to temporary hold the data ***/
			EditstorageSaveBean bean = new EditstorageSaveBean();
			bean.SetCUsernameS(clean_CUsernameS);
			bean.SetCPasswordsS(clean_CPasswordsS);
//			bean.SetUsernameS(clean_UsernameS);
//			bean.SetPasswordsS(clean_PasswordsS);
			bean.SetStorage_size(Storage_size);


			/*** Pass the bean to DAO for processing ***/
			bean = EditstorageSaveDAO.selectQuery(bean);

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
