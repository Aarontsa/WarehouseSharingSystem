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

import my.com.Wshare.RegisterBean;
import my.com.Wshare.RegisterDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class RegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
//	private HomeDAO home = new HomeDAO();
	public RegisterServlet() {
		super();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			/*** Get variable that sent from UI ***/
			String Username = request.getParameter("Username");
			String Passwords = request.getParameter("Passwords");
			String Email = request.getParameter("Email");
			int Mobilenumber = Integer.parseInt(request.getParameter("Mobilenumber"));
			String Address = request.getParameter("Address");
			String Description = request.getParameter("Description");
			String img = request.getParameter("img");
			String usertype = request.getParameter("usertype");
			Float latitude=Float.parseFloat(request.getParameter("latitude"));
			Float longtitude=Float.parseFloat(request.getParameter("longtitude"));
			
			/*** Sanitize special characters - String variables only ***/
			String clean_Username = new Sanitizer().sanitize(Username);
			String clean_Passwords = new Sanitizer().sanitize(Passwords);
			String clean_Description = new Sanitizer().sanitize(Description);



			/*** Create a bean to temporary hold the data ***/
			RegisterBean bean = new RegisterBean();
			bean.SetUsername(clean_Username);
			bean.SetPasswords(clean_Passwords);
			bean.SetEmail(Email);
			bean.SetMobilenumber(Mobilenumber);
			bean.SetAddress(Address);
			bean.SetDescription(clean_Description);
			bean.Setimg(img);
			bean.Setusertype(usertype);
			bean.Setlatitude(latitude);
			bean.Setlongtitude(longtitude);

			/*** Pass the bean to DAO for processing ***/
			bean = RegisterDAO.selectQuery(bean);

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
