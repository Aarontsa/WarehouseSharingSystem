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

//import my.com.Wshare.ValidchatlistidBean;
//import my.com.Wshare.ValidchatlistidDAO;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ValidchatlistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ValidchatlistServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			String CStorage_Userid = request.getParameter("CStorage_Userid");

			/*** Sanitize special characters - String variables only ***/
//			String clean_Username = new Sanitizer().sanitize(Username);

			/*** Create a bean to temporary hold the data ***/
			ValidchatlistBean bean = new ValidchatlistBean();
			bean.SetUsername(Username);
			bean.SetPasswords(Passwords);
			bean.SetCStorage_Userid(CStorage_Userid);

			/*** Pass the bean to DAO for processing ***/
			bean = ValidchatlistDAO.Validchatlist(bean);

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
