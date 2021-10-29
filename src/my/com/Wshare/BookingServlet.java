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

import my.com.Wshare.BookingBean;
import my.com.Wshare.BookingDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class BookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public BookingServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			int UserS = Integer.parseInt(request.getParameter("UserS"));
//			System.out.println("Username");
//			System.out.println("Passwords");

			
			String BookingName = request.getParameter("BookingName");
			int Quantity = Integer.parseInt(request.getParameter("Quantity"));
			String Description = request.getParameter("Description");
			int Mobilenumber = Integer.parseInt(request.getParameter("Mobilenumber"));
			String Checkin = request.getParameter("Checkin");
			String Checkout = request.getParameter("Checkout");
			int Price = Integer.parseInt(request.getParameter("Price"));
			int Days = Integer.parseInt(request.getParameter("Days"));
			String Bank = request.getParameter("Bank");
			String Storagesize = request.getParameter("Storagesize");
//			System.out.println("Storagesize");
			
			/*** Sanitize special characters - String variables only ***/
//			String clean_Username = new Sanitizer().sanitize(Username);
//			String clean_Passwords = new Sanitizer().sanitize(Passwords);
//			String clean_Description = new Sanitizer().sanitize(Description);



			/*** Create a bean to temporary hold the data ***/
			BookingBean bean = new BookingBean();
			bean.SetUsername(Username);
			bean.SetPasswords(Passwords);
			bean.SetUserS(UserS);
			bean.SetBookingName(BookingName);
			bean.SetQuantity(Quantity);
			bean.SetDescription(Description);
			bean.SetMobilenumber(Mobilenumber);
			bean.SetCheckin(Checkin);
			bean.SetCheckout(Checkout);
			bean.SetPrice(Price);
			bean.SetDays(Days);
			bean.SetBank(Bank);
			bean.SetStoragesize(Storagesize);

			/*** Pass the bean to DAO for processing ***/
			bean = BookingDAO.selectQuery(bean);

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

}
