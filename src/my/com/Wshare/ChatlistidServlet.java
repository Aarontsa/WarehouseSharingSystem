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

import my.com.Wshare.ChatlistidBean;
import my.com.Wshare.ChatlistidDAO;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ChatlistidServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChatlistidServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			String CStorage_Userid = request.getParameter("CStorage_Userid");
			System.out.println("ChatlistidServlet"+Passwords);
			
			/*** Create a bean to temporary hold the data ***/
			ChatlistidBean bean = new ChatlistidBean();
			bean.SetUsername(Username);
			bean.SetPasswords(Passwords);
			bean.SetCStorage_Userid(CStorage_Userid);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = UseridBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ChatlistidDAO ChatlistidDAO = new ChatlistidDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ChatlistidDAO.getChatlistid(bean);

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
