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

import my.com.Wshare.ValidRatingDAO;
import my.com.Wshare.ValidRatingBean;
//import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class ValidRatingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public ValidRatingServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {

			/*** Get variable that sent from UI ***/
			String Bookingid = request.getParameter("UserS");
			System.out.println("select query"+Bookingid);

			/*** Sanitize special characters - String variables only ***/
			String clean_Bookingid = new Sanitizer().sanitize(Bookingid);




			/*** Create a bean to temporary hold the data ***/
			ValidRatingBean bean = new ValidRatingBean();
			bean.SetBookingid(clean_Bookingid);


			/*** Pass the bean to DAO for processing ***/
			bean = ValidRatingDAO.ValidRating(bean);

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
