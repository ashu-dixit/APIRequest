package filloAPI;

import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

import java.sql.Timestamp;
import java.util.Scanner;

import Exception.FilloException;
//in this program computer ask if user want to add more data 
//if yes then then loop proceed further and add the user data to the insert stringquery 

public class Table {

	public static void main(String[] args) throws FilloException {
		Scanner scn = new Scanner(System.in);
		Fillo fillo = new Fillo();

		Connection connection = fillo.getConnection("E:\\table.xlsx");
//		this is to get the last serial number
		String strQuery1="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery1);
		recordset.moveLast();
		
		
		String UserInput = "YES";
		
		while (UserInput.equals("YES")) {
//			this is to get the last serial number and determining the next serial number on that basis
			String s_no =String.valueOf(Integer.valueOf((recordset.getField("SNO")))+1);
			
//			this is for time stamp
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String time=String.valueOf(timestamp.getMonth());

//			Adding serial no timestamp and other data to the insert query
			String strQuery2 = "INSERT Into Sheet1(SNO,TIMESTAMP) VALUES("+s_no+","+time+")";
			connection.executeUpdate(strQuery2);
			
			
//			Asking user if he want to add more data and proceding further
			System.out.println("Do You Want to add more data?");
			UserInput = scn.next();
			UserInput.toUpperCase();
		}

		connection.close();
	}
}