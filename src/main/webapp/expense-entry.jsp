<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Model.Planer"%>
<%@page import="dao.PlanerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Expense Entry</title>
  <link rel="stylesheet" href="Style.css">
</head>
<body>
<header>
<%
PlanerDAO d = new PlanerDAO();
List<Planer> ls = d.getDestinationName();
System.out.println("In expense page : "+ls);
Iterator<Planer> itr = ls.iterator();
%>
    <h1>Expense Entry</h1>
  </header>

  <main>
    <section class="expense-section">
      <h2>Record Your Expenses</h2>
      <form id="expenseForm" action="ExpenseEntryServlet" method="get">
         <label for="mySelect">Select an Trip:</label>
         <select id="mySelect" name="mySelect" class="select-trip">
         <option disabled selected>Select Trip</option>
         <%
			while(itr.hasNext())
			{
				Planer p = itr.next();
				%>
           <option value="<%=p.getDestination()%>"><%=p.getDestination()%></option>
            <%
			}
		%>
       </select>
        <br>
        <div class="date-container">
        <label for="expancedate">Date of Expense:</label>
        <div class="dateofexpance">
        <input type="date" id="date-expance" name="date-expance" required>
        </div>
        </div> 
        <br>
        <label for="description">Description:</label>
        <input type="text" id="description" name="description"  required>

        <label for="amount">Amount:</label>
        <input type="number" id="amount" name="amount" placeholder="Enter the amount" required>

        <button type="submit">Submit</button>
      </form>
    </section>
  </main>
  <footer>
    <p>&copy; 2023 Your Voyage Master</p>
  </footer>
</body>
</html>