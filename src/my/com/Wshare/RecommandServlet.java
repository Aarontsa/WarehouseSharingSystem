package my.com.Wshare;

import java.io.IOException;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import my.com.Wshare.MapDAO;

import my.com.Wshare.RecommandBean;
import my.com.Wshare.RecommandDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/MapServlet")
public class RecommandServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private MapDAO Map = new MapDAO();
	public RecommandServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			RecommandDAO RecommandDAO = new RecommandDAO();


			/*** Create a bean to temporary hold the data ***/
			String bean = RecommandDAO.getRecommand();


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
			System.out.println(bean);
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

}
