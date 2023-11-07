package Servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.Planer;
import dao.PlanerDAO;

@WebServlet("/ViewExpenes")
public class ViewExpenes extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String destination = request.getParameter("destination");
		PlanerDAO d = new PlanerDAO();
		
		System.out.println("Sservelet :: "+destination);
		List<Planer> ls = d.getExpensesByDestination(destination);
		System.out.println("List is : "+ls);
		if(ls!=null)
		{
			request.setAttribute("expense",ls);
			RequestDispatcher rd = request.getRequestDispatcher("expenseDetails.jsp");
			rd.include(request, response);
		}
		else {
			request.setAttribute("msg", "Record not Found..");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
