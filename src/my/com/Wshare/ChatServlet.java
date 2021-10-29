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

import my.com.Wshare.ChatBean;
import my.com.Wshare.ChatDAO;
import my.com.Wshare.ChatViewBean;
import my.com.Wshare.ChatViewDAO;

public class ChatServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChatServlet() {
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
			ChatBean bean = new ChatBean();

			bean.SetCUsername(clean_CUsername);
			bean.SetCPasswords(clean_CPasswords);
//			bean.SetUserS_id(UserS_id);
			bean.SetUser_Mgs(User_Mgs);
			bean.SetChatlist_id(Chatlist_id);


			/*** Pass the bean to DAO for processing ***/
			bean = ChatDAO.selectQuery(bean);

			if (bean.getStatus()) {
				HttpSession session = request.getSession(true);
				session.setAttribute("currentSessionUser", bean);
				 System.out.println("ChatServlet"+Chatlist_id);
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
			String UserS_id = request.getParameter("UserS_id");
			String Chatlistid = request.getParameter("Chatlistid");
			System.out.println("ChatServlet doget"+UserS_id);
			
			/*** Create a bean to temporary hold the data ***/
			ChatViewBean bean = new ChatViewBean();
			bean.SetCUsername(CUsername);
			bean.SetCPasswords(CPasswords);
			bean.SetUserS_id(UserS_id);
			bean.SetChatlistid(Chatlistid);
			
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ChatViewDAO ChatViewDAO = new ChatViewDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ChatViewDAO.getChat(bean);

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
