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

import my.com.Wshare.UpdatemessagestatusBean;
import my.com.Wshare.UpdatemessagestatusDAO;
import my.com.Wshare.Sanitizer;


//@WebServlet("/HomeServlet")
public class UpdatemessagestatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public UpdatemessagestatusServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String Chatlist_id = request.getParameter("Chatlist_id");
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
//			String Chatlist_status = request.getParameter("Chatlist_status");
			System.out.println("UpdatemessagestatusServlet"+Chatlist_id);
			
			/*** Sanitize special characters - String variables only ***/
			String clean_Username = new Sanitizer().sanitize(Username);
			String clean_Passwords = new Sanitizer().sanitize(Passwords);
//			String clean_Chatlist_status = new Sanitizer().sanitize(Chatlist_status);

			/*** Create a bean to temporary hold the data ***/
			UpdatemessagestatusBean bean = new UpdatemessagestatusBean();
			bean.SetUsername(clean_Username);
			bean.SetPasswords(clean_Passwords);
			bean.SetChatlist_id(Chatlist_id);
//			bean.SetChatlist_status(clean_Chatlist_status);

			/*** Pass the bean to DAO for processing ***/
			bean = UpdatemessagestatusDAO.selectQuery(bean);

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
			
		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}
}
