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

import my.com.Wshare.ForgetpasswordsBean;
import my.com.Wshare.ForgetpasswordsDAO;
import my.com.Wshare.ForgetgetpasswordsBean;
import my.com.Wshare.ForgetgetpasswordsDAO;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ForgetpasswordsServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ForgetpasswordsServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");


			/*** Sanitize special characters - String variables only ***/
			String clean_Username = new Sanitizer().sanitize(Username);




			/*** Create a bean to temporary hold the data ***/
			ForgetpasswordsBean bean = new ForgetpasswordsBean();
			bean.SetUsername(clean_Username);


			/*** Pass the bean to DAO for processing ***/
			bean = ForgetpasswordsDAO.Forgetpasswords(bean);

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
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
//			String CPasswords = request.getParameter("CPasswords");
//			System.out.println(CPasswords);
			
			/*** Create a bean to temporary hold the data ***/
			ForgetgetpasswordsBean bean = new ForgetgetpasswordsBean();
			bean.SetUsername(Username);
//			bean.SetCPasswords(CPasswords);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ForgetgetpasswordsDAO ForgetgetpasswordsDAO = new ForgetgetpasswordsDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ForgetgetpasswordsDAO.getpasswords(bean);

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
