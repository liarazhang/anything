import java.sql.*;



public class connectsql {
	public static void main(String[] args)
		      throws SQLException, ClassNotFoundException {
		    // Load the JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");
		    System.out.println("Driver loaded");

		    // Establish a connection
		    Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root", "zxyzxy");
		    System.out.println("Database connected");


		    // Create a statement
		    Statement statement = ((java.sql.Connection) connection).createStatement();

		    // Execute a statement
		    int resultSet = statement.executeUpdate("");
		    //ResultSet resultSet = statement.executeQuery
				     // "insert into user values(\"zhangsan\",\"lisi\")"
		    		//delete from user where name="zyx"
		    //select * from user;

		    // Iterate through the result and print the student names
		    //while (resultSet.next())
		     // System.out.println(resultSet.getString(1)+""+resultSet.getString(2));

		    // Close the connection
		    connection.close();
		    

		  }
}
