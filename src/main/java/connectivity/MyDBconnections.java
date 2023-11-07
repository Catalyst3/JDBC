package connectivity;
import java.sql.Connection;
import java.sql.DriverManager;

public class MyDBconnections {
	Connection con;
	public Connection getMyConnection()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/travelmanagementdb","root","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("IN my connection"+con);
		return con;
	}

}