package my.com.Wshare;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

import my.com.Wshare.UsergraphorderBean;
import my.com.Wshare.UsergraphorderDAO;
//import my.com.bbraun.hrit.EvaluationForm.Sanitizer;

import com.google.gson.Gson;

public class UsergraphorderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public UsergraphorderServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			System.out.println("getusergraphorder"+Username);
			
			/*** Create a bean to temporary hold the data ***/
			UsergraphorderBean bean = new UsergraphorderBean();
			bean.SetUsername(Username);
			bean.SetPasswords(Passwords);

			/*** Pass the bean to DAO for processing ***/
			UsergraphorderDAO UsergraphorderDAO = new UsergraphorderDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = UsergraphorderDAO.getusergraphorder(bean);
			System.out.println(res);

			String json = new Gson().toJson(res);
			response.setContentType("application/json");
			response.setCharacterEncoding("utf-8");
			response.getWriter().write(json);
			//System.out.println(json);

		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}

}
