package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import java.sql.ResultSet;
import java.sql.Statement;

import Model.Planer;
import connectivity.MyDBconnections;

public class PlanerDAO{
	MyDBconnections dbConnection =new MyDBconnections();
	Connection con;
	PreparedStatement stmt;
	ResultSet rs;
	
	public int addDetails(Planer p)
	{
		int status=0;
		System.out.println("Get Data from Browser");
		System.out.println("End: "+p.getEndDate());
		con=dbConnection.getMyConnection();
		System.out.println("Connection DAO "+con);
		try {
			stmt=con.prepareStatement("INSERT INTO travel_plans (Destination, StartDate, EndDate, Budget, Description) VALUE (?, ?, ?, ?, ?)");
			stmt.setString(1, p.getDestination());
			stmt.setString(2, p.getStartDate());
			stmt.setString(3, p.getEndDate());
			stmt.setDouble(4, p.getBudget());
			stmt.setString(5, p.getDescription());
			System.out.println("Sucessfully Inserted");
			status=stmt.executeUpdate();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public int addExpenses(Planer p)
	{
		int status=0;
		con=dbConnection.getMyConnection();
		System.out.println("Connection DAO "+con);
		
		try {
			stmt=con.prepareStatement("INSERT INTO expenses (destination,date,description,amount) VALUE (?, ?, ?, ?)");
			stmt.setString(1, p.getDestination());
			stmt.setString(2, p.getExpenseDate());
			stmt.setString(3, p.getDescriptionofExpense());
			stmt.setDouble(4, p.getAmount());
			System.out.println("Sucessfully Inserted");
			status=stmt.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	public List<Planer> getTravelHistory()
	{
		List <Planer> ls = new ArrayList<Planer>();
		con=dbConnection.getMyConnection();
		System.out.println("Outside Try...");
		try 
		{
			//stmt=con.prepareStatement("SELECT plan_id,destination, details FROM travel_plans");
			
			
			String str= "select * from travel_plans";
			Statement st= con.createStatement();
			rs=st.executeQuery(str);
			System.out.println("ONE");
			
			//System.out.println("Result Set : "+rs.next());
			while( rs.next()){
				{
//					    System.out.println("Plan ID: " + rs.getInt(1));
//					    System.out.println("Destination: " + rs.getString(2));
//					    System.out.println("Start Date: " + rs.getString(3));
//					    System.out.println("End Date: " + rs.getString("end_date"));
//					    System.out.println("Budget: " + rs.getDouble("budget"));
//					 System.out.println("Description: " + rs.getString("details"));
					//fetching data from rs.
					System.out.println("In loop");
					
					Planer p = new Planer();
//					p.setPlanId(rs.getInt("plan_id"));
//					p.setDestination(rs.getString("destination"));
//			    	p.setStartDate(rs.getString("start_date"));
//					p.setEndDate(rs.getString("end_date"));
//					p.setBudget(rs.getDouble("budget"));
//					p.setDescription(rs.getString("details"));
					//, , , , 
					p.setPlanId(rs.getInt(1));
					p.setDestination(rs.getString("Destination"));
			    	p.setStartDate(rs.getString("StartDate"));
					p.setEndDate(rs.getString("EndDate"));
					p.setBudget(rs.getDouble("Budget"));
					p.setDescription(rs.getString("Description"));
					
						ls.add(p);
					//System.out.println("Date is:"+rs.getString("start_date"));
				}			
			}
		}
		catch(Exception e)
		{
			System.out.println("****************** "+e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}
	public List<Planer> getDestinationName()
	{
		List <Planer> ls = new ArrayList<Planer>();
		con=dbConnection.getMyConnection();
		System.out.println("Outside Try...");
		try 
		{
			stmt=con.prepareStatement("SELECT destination FROM travel_plans");
			rs=stmt.executeQuery();
			System.out.println("ONE");
			
			//System.out.println("Result Set : "+rs.next());
			while( rs.next()){
				{
					//fetching data from rs.
					System.out.println("In loop");
					Planer p = new Planer();					
					p.setDestination(rs.getString("destination"));
					ls.add(p);
				}			
			}
		}
		catch(Exception e)
		{
//			System.out.println("****************** "+e.getMessage());
			e.printStackTrace();
		}
		return ls;
	}
	
	public List<Planer> getExpensesByDestination(String p)
	{
		System.out.println("Inside Get Expences...");
		
		List <Planer> ls = new ArrayList<Planer>();
		System.out.println("************"+p);
		con=dbConnection.getMyConnection();
		try
		{
			System.out.println("#1");
			stmt=con.prepareStatement("select `expense_id`, `destination`, `date`, `description`, `amount` from expenses where destination=?");
			stmt.setString(1, p);
			System.out.println("#2");
			
		ResultSet rs=	stmt.executeQuery();
			System.out.println("#3");
			
			while(rs.next())
			{
				System.out.println("Inside While Loop....");
				Planer p1 = new Planer();
				p1.setExpenseDate(rs.getString(3)); // date
				p1.setDescriptionofExpense(rs.getString(4));  // description
				p1.setAmount(rs.getDouble(5));  //amount
				
				ls.add(p1);
				
				System.out.println(rs.getString(3));
				System.out.println(rs.getString(4));
				System.out.println(rs.getDouble(5));
			}
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("###############"+e.getMessage());
		}
		System.out.println("before return"+ls);
		return ls;
	}

}
