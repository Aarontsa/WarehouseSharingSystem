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

import my.com.Wshare.HistoryorderBean;
import my.com.Wshare.HistoryorderDAO;


public class HistoryorderServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public HistoryorderServlet() {
		super();
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
			HistoryorderBean bean = new HistoryorderBean();
			bean.SetCUsernameS(CUsernameS);
			bean.SetCPasswordsS(CPasswordsS);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			HistoryorderDAO HistoryorderDAO = new HistoryorderDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = HistoryorderDAO.getHistoryorder(bean);

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
