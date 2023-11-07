
<%@page import="java.util.Iterator"%>
<%@page import="Model.Planer"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" href="Style.css">
<title>Expenses Details</title>
</head>
<body>
<%List<Planer> ls = (List<Planer>)request.getAttribute("expense"); %>
<%
System.out.println("In  Page : "+ls);
Iterator<Planer> itr = ls.iterator();  
%>
<header>
        <h1>Expenses Details</h1>
      </header>
      <main>
        <section class="Expenses-Details-section">
          <h2>Your Expenses Details</h2>
          <div class="expense-card">
           
           <% while(itr.hasNext())
			{
        	   Planer p2 = itr.next();
				%>
				<div class="card">
              <h5 class="destination"><%=p2.getDestination()%></h5>
                <p class="expense-date"><%=p2.getExpenseDate()%></p>
                <p class="amount"><%=p2.getAmount()%></p>
                <p class="details"><%=p2.getDescriptionofExpense()%></p>
                <hr>
               
              </div>
                <%
        }
        %>
            </div>
       
        </section>
        
      </main>
    
      <footer>
        <p>&copy; 2023 Your Voyage Master</p>
      </footer>
</body>
</html>