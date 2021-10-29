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

import my.com.Wshare.Chatuser2ViewBean;
import my.com.Wshare.Chatuser2ViewDAO;


public class Chatuser2Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public Chatuser2Servlet() {
		super();
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
//			String CUsername = request.getParameter("CUsername");
//			String CPasswords = request.getParameter("CPasswords");
//			String UserS_id = request.getParameter("UserS_id");
			String Chatlist_id = request.getParameter("Chatlist_id");
			System.out.println("Chatuser2Servlet"+Chatlist_id);
			
			/*** Create a bean to temporary hold the data ***/
			Chatuser2ViewBean bean = new Chatuser2ViewBean();
//			bean.SetCUsername(CUsername);
//			bean.SetCPasswords(CPasswords);
//			bean.SetUserS_id(UserS_id);
			bean.SetChatlist_id(Chatlist_id);
			
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			Chatuser2ViewDAO Chatuser2ViewDAO = new Chatuser2ViewDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = Chatuser2ViewDAO.getChatuser2(bean);

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
