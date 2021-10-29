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

import my.com.Wshare.RecommandStoragecountBean;
import my.com.Wshare.RecommandStoragecountDAO;
import my.com.Wshare.Sanitizer;

//@WebServlet("/HomeServlet")
public class RecommandStoragecountServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public RecommandStoragecountServlet() {
		super();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
			/*** Get variable that sent from UI ***/
//			String Storage_Username = request.getParameter("Storage_Username");
//			int Storage_Userid = Integer.parseInt(request.getParameter("Storage_Userid"));
//			String CStorage_Userid = request.getParameter("CStorage_Userid");
//			System.out.println(CStorage_Userid);
			
			/*** Create a bean to temporary hold the data ***/
//			StorageBean bean = new StorageBean();
//			bean.SetStorage_Username(Storage_Username);
//			bean.SetCStorage_Userid(CStorage_Userid);
//			bean.SetStorage_Userid(Storage_Userid);
			
			/*** Pass the bean to DAO for processing ***/
//			bean = StorageDAO.getUsers();
			
//			/*** Pass the bean to DAO for processing ***/
	        RecommandStoragecountDAO RecommandStoragecountDAO = new RecommandStoragecountDAO();

			/*** Convert the result to JSON format and return to the UI ***/
			String bean = RecommandStoragecountDAO.getRecommandStoragecount();

			String json = new Gson().toJson(bean);
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
