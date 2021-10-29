package my.com.Wshare;

import java.io.IOException;
//import java.sql.SQLException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import my.com.Wshare.HistoryBean;
import my.com.Wshare.HistoryDAO;
import my.com.Wshare.RatingBean;
import my.com.Wshare.RatingDAO;

public class HistoryServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HistoryServlet() {
		super();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			int UserS = Integer.parseInt(request.getParameter("UserS"));
			int Rating = Integer.parseInt(request.getParameter("Rating"));
			String commentUser = request.getParameter("commentUser");
			
			/*** Sanitize special characters - String variables only ***/
			String clean_Username = new Sanitizer().sanitize(Username);
			String clean_Passwords = new Sanitizer().sanitize(Passwords);
			String clean_commentUser = new Sanitizer().sanitize(commentUser);

			/*** Create a bean to temporary hold the data ***/
			RatingBean bean = new RatingBean();

			bean.SetUsername(clean_Username);
			bean.SetPasswords(clean_Passwords);
			bean.SetUserS(UserS);
			bean.SetRating(Rating);
			bean.SetcommentUser(clean_commentUser);


			/*** Pass the bean to DAO for processing ***/
			bean = RatingDAO.selectQuery(bean);

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
			String CUsernameS = request.getParameter("CUsername");
			String CPasswordsS = request.getParameter("CPasswords");
			System.out.println(CUsernameS);
			
			/*** Create a bean to temporary hold the data ***/
			HistoryBean bean = new HistoryBean();
			bean.SetCUsernameS(CUsernameS);
			bean.SetCPasswordsS(CPasswordsS);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			HistoryDAO HistoryDAO = new HistoryDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = HistoryDAO.getUsersHistory(bean);

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
