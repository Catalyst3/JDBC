package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.PlanerDAO;
import Model.Planer;
@WebServlet("/TravelHistoryServlet")
public class TravelHistoryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
////		String PlanId = request.getParameter("id");
////		int id = Integer.parseInt(PlanId);
//		PlanerDAO d = new PlanerDAO();
//		int x = d.addDetails(p);
//		if(p1!=null)
//		{
//			request.setAttribute("hist",p1);
//			RequestDispatcher rd = request.getRequestDispatcher("travel-history.jsp");
//			rd.include(request, response);
//		}
//		else {
//			request.setAttribute("msg", "Record not Found..");
//			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
//			rd.include(request, response);
//		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

}
