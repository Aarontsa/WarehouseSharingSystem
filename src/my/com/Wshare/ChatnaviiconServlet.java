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

import my.com.Wshare.ChatnaviiconBean;
import my.com.Wshare.ChatnaviiconDAO;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ChatnaviiconServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChatnaviiconServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String CUsername = request.getParameter("CUsername");
			String CPasswords = request.getParameter("CPasswords");
			System.out.println(CUsername);
			
			/*** Create a bean to temporary hold the data ***/
			ChatnaviiconBean bean = new ChatnaviiconBean();
			bean.SetCUsername(CUsername);
			bean.SetCPasswords(CPasswords);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = UseridBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ChatnaviiconDAO ChatnaviiconDAO = new ChatnaviiconDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ChatnaviiconDAO.getChatcount(bean);

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
