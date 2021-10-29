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

import my.com.Wshare.ChatlistpostBean;
import my.com.Wshare.ChatlistpostDAO;
import my.com.Wshare.ChatlistBean;
import my.com.Wshare.ChatlistDAO;
import my.com.Wshare.Sanitizer;


public class ChatlistServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChatlistServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
			/*** Get variable that sent from UI ***/
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
			System.out.println("ChatlistServlet"+CUsernameS);
			
			/*** Create a bean to temporary hold the data ***/
			ChatlistBean bean = new ChatlistBean();
			bean.SetCUsernameS(CUsernameS);
			bean.SetCPasswordsS(CPasswordsS);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = LoginBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ChatlistDAO ChatlistDAO = new ChatlistDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ChatlistDAO.getChatlist(bean);

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
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String CUsername = request.getParameter("CUsername");
			String CPasswords = request.getParameter("CPasswords");
			int UserS_id = Integer.parseInt(request.getParameter("UserS_id"));
			
			/*** Sanitize special characters - String variables only ***/
			String clean_CUsername = new Sanitizer().sanitize(CUsername);
			String clean_CPasswords = new Sanitizer().sanitize(CPasswords);

			/*** Create a bean to temporary hold the data ***/
			ChatlistpostBean bean = new ChatlistpostBean();
			bean.SetCUsername(clean_CUsername);
			bean.SetCPasswords(clean_CPasswords);
			bean.SetUserS_id(UserS_id);

			/*** Pass the bean to DAO for processing ***/
			bean = ChatlistpostDAO.selectQuery(bean);

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
