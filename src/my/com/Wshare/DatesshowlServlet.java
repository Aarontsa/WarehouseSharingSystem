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

import my.com.Wshare.DatesshowlDAO;
import my.com.Wshare.DatesshowlBean;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class DatesshowlServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DatesshowlServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        
			/*** Get variable that sent from UI ***/
			String UserS = request.getParameter("CStorage_Userid");
			String Checkin = request.getParameter("Checkin");
			String Checkout = request.getParameter("Checkout");
			System.out.println("DatesshowDAO"+UserS);
			
			/*** Create a bean to temporary hold the data ***/
			DatesshowlBean bean = new DatesshowlBean();
			bean.SetUserS(UserS);
			bean.SetCheckin(Checkin);
			bean.SetCheckout(Checkout);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = LoginBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			DatesshowlDAO DatesshowlDAO = new DatesshowlDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = DatesshowlDAO.getDatesshowl(bean);

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
