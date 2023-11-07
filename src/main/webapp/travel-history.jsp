<%@page import="java.util.Iterator"%>
<%@page import="Model.Planer"%>
<%@page import="java.util.List"%>
<%@page import="dao.PlanerDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Travel History</title>
  <link rel="stylesheet" href="Style.css">
</head>
<body>
<header>
<%
PlanerDAO d = new PlanerDAO();
List<Planer> ls = d.getTravelHistory();
System.out.println("In History Page : "+ls);
Iterator<Planer> itr = ls.iterator();
%>
    <h1>Travel History</h1>
  </header>

  <main>
    <section class="travel-history-section">
      <h2>Your Travel History</h2>
      <div class="travel-card">
        <!-- <img src="travel_image_url" alt="Travel Destination 1"> -->
        <%
			while(itr.hasNext())
			{
				Planer p = itr.next();
				%>
          <div class="card">
            <h5 class="destination"><%=p.getDestination()%></h5>
            <p class="date"><%=p.getStartDate()%> - <%=p.getEndDate()%></p>
            <p class="budget">Budget: <%=p.getBudget()%></p>
            <p><%=p.getDescription()%></p>
             <div class="expenseBackground">  
              <a href="ViewExpenes?destination=<%= p.getDestination()%>">View Expenses</a>
            </div>
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