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

@WebServlet("/ExpenseEntryServlet")
public class ExpenseEntryServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In servlet");
		String destination = request.getParameter("mySelect");
        String expenseDate = request.getParameter("date-expance");
        String descriptionofExpense = request.getParameter("description");
        double amount = Double.parseDouble(request.getParameter("amount"));
		Planer p = new Planer();
		p.setDestination(destination);
		p.setExpenseDate(expenseDate);
		p.setDescriptionofExpense(descriptionofExpense);
		p.setAmount(amount);
		PlanerDAO dao = new PlanerDAO();
        int x = dao.addExpenses(p);	
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
			
			request.setAttribute("exp", "Insert Success...");
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
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
