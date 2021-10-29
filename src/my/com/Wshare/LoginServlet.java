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

import my.com.Wshare.LoginBean;
import my.com.Wshare.LoginDAO;
import my.com.Wshare.Sanitizer;


public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
			System.out.println(CUsernameS);
			
			/*** Create a bean to temporary hold the data ***/
			LoginBean bean = new LoginBean();
			bean.SetCUsernameS(CUsernameS);
			bean.SetCPasswordsS(CPasswordsS);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = LoginBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			LoginDAO LoginDAO = new LoginDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = LoginDAO.getTodayHistory(bean);

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
