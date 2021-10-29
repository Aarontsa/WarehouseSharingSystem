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

import my.com.Wshare.AdminDeletebookingBean;
import my.com.Wshare.AdminDeletebookingDAO;
import my.com.Wshare.Sanitizer;


//@WebServlet("/HomeServlet")
public class AdminDeletebookingServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public AdminDeletebookingServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String deletebooking_id = request.getParameter("deletebooking_id");
			System.out.println("AdminDeletebookingServlet"+deletebooking_id);
			
			/*** Sanitize special characters - String variables only ***/
//			String clean_Chatlist_status = new Sanitizer().sanitize(Chatlist_status);

			/*** Create a bean to temporary hold the data ***/
			AdminDeletebookingBean bean = new AdminDeletebookingBean();
			bean.Setdeletebooking_id(deletebooking_id);

			/*** Pass the bean to DAO for processing ***/
			bean = AdminDeletebookingDAO.selectQuery(bean);

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
			
		} catch (

		Throwable theException) {
			System.out.println(theException);
		}
	}
}
