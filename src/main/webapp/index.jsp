<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Travel Planner</title>
  <link rel="stylesheet" href="Style.css">
</head>
<body>
<header>
    <h1>Voyage Master</h1>
  </header>
  <main>
    <section class="destination-section">
      <h2>Plan Your Travel</h2>
      <form id="travelForm" action="TravelPlannerServlet" method="get">
  <label for="destination">Destination:</label>
  <input type="text" id="destination" name="destination" placeholder="Enter your destination">
  <div class="dates">
    <label for="Start-date">Start Dates:</label>
    <div class="input-container-start-date">
      <input type="date" id="start-date" name="start-date" required>
    </div>
    <label for="End-Date">End Dates:</label>
    <div class="input-container-end-date">
      <input type="date" id="end-date" name="end-date" required>
    </div>
  </div>
  <label for="budget">Budget:</label>
  <input type="number" id="budget" name="budget" placeholder="Enter your budget" required>
  <section class="description-section">
    <label for="Description">Add Description:</label>
    <br><br>
    <textarea id="description" name="description" rows="4" cols="40" style="resize: none;" placeholder="Enter your description"></textarea>
  </section>
  <button type="submit">Submit</button>
      </form>
      </section>
      </main>

    <section class="action-section">
      <a href="expense-entry.jsp">
        <img src="expense_entry_image_url" alt="Expense Entry">
        <h3>Expense Entry</h3>
      </a>
      <a href="travel-history.jsp">
        <img src="travel_history_image_url" alt="Travel History">
        <h3>Travel History</h3>
      </a>
    </section>
  </main>
  <footer>
    <p>&copy; 2023 Your Voyage Master</p>
  </footer>
</body>
</html>