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

import my.com.Wshare.RecommandresultcountBean;
import my.com.Wshare.RecommandresultcountDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/MapServlet")
public class RecommandresultcountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private MapDAO Map = new MapDAO();
	public RecommandresultcountServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
			String Userid1 = request.getParameter("Userid1");
			String Userid2 = request.getParameter("Userid2");
			String Userid3 = request.getParameter("Userid3");
			String Userid4 = request.getParameter("Userid4");
			String Userid5 = request.getParameter("Userid5");
			System.out.println("RecommandcountServlet"+Userid1);
			System.out.println("RecommandcountServlet"+Userid2);
			System.out.println("RecommandcountServlet"+Userid3);
			System.out.println("RecommandcountServlet"+Userid4);
			System.out.println("RecommandcountServlet"+Userid5);
			
			/*** Create a bean to temporary hold the data ***/
			RecommandresultcountBean bean = new RecommandresultcountBean();
			bean.SetUserid1(Userid1);
			bean.SetUserid2(Userid2);
			bean.SetUserid3(Userid3);
			bean.SetUserid4(Userid4);
			bean.SetUserid5(Userid5);
			
			/*** Pass the bean to DAO for processing ***/
			RecommandresultcountDAO RecommandresultcountDAO = new RecommandresultcountDAO();

			/*** Create a bean to temporary hold the data ***/
			String res = RecommandresultcountDAO.getRecommandresultcount(bean);


//			if (bean.getStatus()) {
//				HttpSession session = request.getSession(true);
//				session.setAttribute("currentSessionUser", bean);
//				// System.out.println(valid);
//				System.out.println(bean.getStatus());
//				return;
//
//			}
//
//			else {
//
//				System.out.println(bean.getStatus());
//
//			}
			/*** Convert the result to JSON format and return to the UI ***/
			System.out.println(res);
			String json = new Gson().toJson(res);
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
