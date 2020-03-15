

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class First_connection {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","ashutosh");
		 		
		PreparedStatement create= connection.prepareStatement("create table if not exists tables (id int ,FIRST varchar(25), last varchar(25));");
		 		create.execute();
		 		
		System.out.println("connected");
		connection.close();
	}
}
