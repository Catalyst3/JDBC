package Servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.Planer;
import dao.PlanerDAO;

@WebServlet("/TravelPlannerServlet")
public class TravelPlannerServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("In servlet");
        String destination = request.getParameter("destination");
        String startDate = request.getParameter("start-date");
        String endDate = request.getParameter("end-date");
        double budget = Double.parseDouble(request.getParameter("budget"));
        String description = request.getParameter("description");
		
        
        Planer p = new Planer();
		
        p.setDestination(destination);
		p.setStartDate(startDate);
		p.setEndDate(endDate);
		p.setBudget(budget);
		p.setDescription(description);
		
		System.out.println("Planner  : "+p);
		
		PlanerDAO dao = new PlanerDAO();
        int x = dao.addDetails(p);	
		if(x==1)
		{
			System.out.println("Sucess");
		}
		else 
		{
		System.out.println("failed");
		}
		if(x==1)
		{
			System.out.println("Insert Successs");
			
			request.setAttribute("hist", "Insert Success...");
			RequestDispatcher rd = request.getRequestDispatcher("travel-history.jsp");
			rd.include(request, response);
		}
		else
		{
			System.out.println("Insert Faild...");
			request.setAttribute("msg", "Insert Faild...");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
