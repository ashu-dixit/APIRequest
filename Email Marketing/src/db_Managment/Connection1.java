package db_Managment;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Connection1 {

	 private String DBname;
	 private Scanner scn = new Scanner(System.in);
	 private  Connection connection;

	 
	public Connection1( String DBname) throws Exception {
		this.DBname = DBname;
//		whenever class intance is created it established the connection it self
		this.connection = getconnection();

	}

	
//	this function select data from select data from database
	public ArrayList<String> get(String tablename) throws SQLException {
		PreparedStatement ps=this.connection.prepareStatement("select FIRST, last from "+tablename);
		
		ResultSet rs=ps.executeQuery();
		ArrayList<String> last=new ArrayList<>();
//		loop adding data to arraylist
		while(rs.next()) {
		
//			System.out.print(rs.getString("FIRST")+" ");
//			System.out.print(rs.getString("last")+", ");
			last.add(rs.getString("FIRST")+" "+rs.getString("last"));
			
		}
		return last;
	}
	
//	this function estblish connection with database 
//	and return its value	
	private Connection getconnection() throws Exception {
		System.out.println("Enter root password = ");
		String password = scn.next();
		System.out.println("loading driver");
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("getting connection...");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + DBname + "", "root",
				password);
		System.out.println("connected");
		
		return connection;
	}

//	this function is closes the connection
	public void closeconnection() throws Exception {

		this.connection.close();
	}
//this function create table if it does not exists and add specific number of coloumn 
	public void createtable(String tablename) throws SQLException {

		try {
			PreparedStatement create = this.connection.prepareStatement(
					"create table " + tablename + " (id int AUTO_INCREMENT primary key ,FIRST varchar(25), last varchar(25));");
			create.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

//	this function post data on the table 
	public void post(String tablename) {
		System.out.println("Enter first name");
		String firstname = scn.next();
		System.out.println("Enter last name");
		String Lastname = scn.next();

		try {
			PreparedStatement ps = this.connection.prepareStatement(
					"INSERT INTO "+tablename+" (FIRST, last) VALUES ('"+firstname+"', '"+Lastname+"');");
			ps.executeUpdate();
			System.out.println("insert completed");
		} catch (Exception e) {
			System.out.println(e);
		} 
	}

	public ArrayList<String> Deletedata(String tablename){
		ArrayList<String> arr=new ArrayList<>();
		
		try {
			PreparedStatement ps =this.connection.prepareStatement("DELETE from "+tablename+" where 'FIRST'=ashu");
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return arr;
	}
}
