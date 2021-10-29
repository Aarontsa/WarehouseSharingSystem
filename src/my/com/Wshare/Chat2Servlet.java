package my.com.Wshare;

import java.io.IOException;
//import java.sql.SQLException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import my.com.Wshare.Chat2Bean;
import my.com.Wshare.Chat2DAO;
import my.com.Wshare.Chat2ViewBean;
import my.com.Wshare.Chat2ViewDAO;

public class Chat2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Chat2Servlet() {
		super();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String CUsername = request.getParameter("CUsername");
			String CPasswords = request.getParameter("CPasswords");
//			int UserS_id = Integer.parseInt(request.getParameter("UserS_id"));
			int Chatlist_id = Integer.parseInt(request.getParameter("Chatlist_id"));
			String User_Mgs = request.getParameter("User_Mgs");
			
			/*** Sanitize special characters - String variables only ***/
			String clean_CUsername = new Sanitizer().sanitize(CUsername);
			String clean_CPasswords = new Sanitizer().sanitize(CPasswords);

			/*** Create a bean to temporary hold the data ***/
			Chat2Bean bean = new Chat2Bean();

			bean.SetCUsername(clean_CUsername);
			bean.SetCPasswords(clean_CPasswords);
//			bean.SetUserS_id(UserS_id);
			bean.SetUser_Mgs(User_Mgs);
			bean.SetChatlist_id(Chatlist_id);


			/*** Pass the bean to DAO for processing ***/
			bean = Chat2DAO.selectQuery(bean);

			if (bean.getStatus()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", bean);
				 System.out.println(Chatlist_id);
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
			String CUsername = request.getParameter("CUsername");
			String CPasswords = request.getParameter("CPasswords");
//			String UserS_id = request.getParameter("UserS_id");
			String Chatlist_id = request.getParameter("Chatlist_id");
			System.out.println(Chatlist_id);
			
			/*** Create a bean to temporary hold the data ***/
			Chat2ViewBean bean = new Chat2ViewBean();
			bean.SetCUsername(CUsername);
			bean.SetCPasswords(CPasswords);
			bean.SetChatlist_id(Chatlist_id);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			Chat2ViewDAO Chat2ViewDAO = new Chat2ViewDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = Chat2ViewDAO.getChat2(bean);

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
