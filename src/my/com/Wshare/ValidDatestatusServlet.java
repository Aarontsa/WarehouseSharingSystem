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

import my.com.Wshare.ValidDatestatusDAO;
import my.com.Wshare.ValidDatestatusBean;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ValidDatestatusServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ValidDatestatusServlet() {
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
//			System.out.println("ChatlistServlet"+UserS);
//			System.out.println("ChatlistServlet"+Checkin);
//			System.out.println("ChatlistServlet"+Checkout);
			
			/*** Create a bean to temporary hold the data ***/
			ValidDatestatusBean bean = new ValidDatestatusBean();
			bean.SetUserS(UserS);
			bean.SetCheckin(Checkin);
			bean.SetCheckout(Checkout);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = LoginBean.getTodayHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			ValidDatestatusDAO ValidDatestatusDAO = new ValidDatestatusDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = ValidDatestatusDAO.getValidDatestatus(bean);

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
