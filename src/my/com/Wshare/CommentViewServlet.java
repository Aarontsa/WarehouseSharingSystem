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

import my.com.Wshare.CommentViewBean;
import my.com.Wshare.CommentViewDAO;


public class CommentViewServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public CommentViewServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
//			String CUsername = request.getParameter("CUsername");
//			String CPasswords = request.getParameter("CPasswords");
			String CStorage_Userid = request.getParameter("CStorage_Userid");
//			String Chatlist_id = request.getParameter("Chatlist_id");
			System.out.println(CStorage_Userid);
			
			/*** Create a bean to temporary hold the data ***/
			CommentViewBean bean = new CommentViewBean();
//			bean.SetCUsername(CUsername);
//			bean.SetCPasswords(CPasswords);
			bean.SetCStorage_Userid(CStorage_Userid);
//			bean.SetChatlist_id(Chatlist_id);
			
			
			/*** Pass the bean to DAO for processing ***/
//			bean = HistoryDAO.getUsersHistory();
			
//			/*** Pass the bean to DAO for processing ***/
			CommentViewDAO CommentViewDAO = new CommentViewDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String res = CommentViewDAO.getCommentView(bean);

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
