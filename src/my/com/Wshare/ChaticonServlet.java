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

import my.com.Wshare.ChaticonBean;
import my.com.Wshare.ChaticonDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ChaticonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ChaticonServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
			/*** Get variable that sent from UI ***/
			String CUsername = request.getParameter("CUsername");
			String CPasswords = request.getParameter("CPasswords");
			System.out.println("ChatlistServlet"+CUsername);
				
			/*** Create a bean to temporary hold the data ***/
			ChaticonBean bean = new ChaticonBean();
			bean.SetCUsername(CUsername);
			bean.SetCPasswords(CPasswords);
			
//			/*** Pass the bean to DAO for processing ***/
			ChaticonDAO ChaticonDAO = new ChaticonDAO();
			
			/*** Convert the result to JSON format and return to the UI ***/
			String res = ChaticonDAO.getChaticon(bean);

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
