package headfirst.observer.weather;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class WeatherDatabaseJDC {
	public static void main(String[] args) {
		try {
			// register driver
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			// Establish a connection to a given database URL:
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			
			//Create a statement object for sending SQL statements to the database
			Statement stmt = con.createStatement();
			
						
			// Execute SQL:
			stmt.execute("SELECT * FROM WeatherDatabase");
			//Update Database
			stmt.execute("INSERT INTO WeatherDatabase (Temperature, Humidity, Pressure, Speed, windChillIndex) VALUES (10, 40, 30.50, 20, -9) ");
			stmt.execute("INSERT INTO WeatherDatabase (Temperature, Humidity, Pressure, Speed, windChillIndex) VALUES (0, 30, 30.70, 10, -16) ");
			stmt.execute("INSERT INTO WeatherDatabase (Temperature, Humidity, Pressure, Speed, windChillIndex) VALUES (-10, 20, 29.80, 15, -32) ");
			// get results from the executed SQL:
			ResultSet results = stmt.getResultSet();

			
			int rowCount = 0;
			
			ResultSetMetaData rsmd = results.getMetaData();
			int columnCount = rsmd.getColumnCount();
			
			// table header
			System.out.println("\t");
			for (int i = 0; i < columnCount; i++) {
			  System.out.print("\t" + rsmd.getColumnLabel(i + 1) + "\t");
			  }
			System.out.println("\n");
			
			// the data
			while (results.next()) {
			 rowCount++;
			 System.out.println("\n");
			 for (int i = 0; i < columnCount; i++) {
			   System.out.print("\t" + results.getString(i + 1) + "\t" );
			   }
			 System.out.println("\n");
			 }
			
			// Close the connection:
			con.close();
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
	}
}
