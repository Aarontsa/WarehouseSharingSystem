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

import my.com.Wshare.DatesshowDAO;
import my.com.Wshare.DatesshowBean;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class DatesshowServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public DatesshowServlet() {
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
			DatesshowBean bean = new DatesshowBean();
			bean.SetUserS(UserS);
			bean.SetCheckin(Checkin);
			bean.SetCheckout(Checkout);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = LoginBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			DatesshowDAO DatesshowDAO = new DatesshowDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = DatesshowDAO.getDatesshow(bean);

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
