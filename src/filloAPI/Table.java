package filloAPI;

import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

import java.sql.Timestamp;
import java.util.Scanner;

import Exception.FilloException;

public class Table {

	public static void main(String[] args) throws FilloException {
		Scanner scn = new Scanner(System.in);
		Fillo fillo = new Fillo();

		Connection connection = fillo.getConnection("E:\\table.xlsx");
		String strQuery1="Select * from Sheet1";
		Recordset recordset=connection.executeQuery(strQuery1);
		recordset.moveLast();
		
		String Str = "yes";
		
		while (Str.equals("yes") || Str.equals("YES")) {
			
			String s_no =String.valueOf(Integer.valueOf((recordset.getField("SNO")))+1);
			System.out.println(s_no);
			Timestamp timestamp = new Timestamp(System.currentTimeMillis());
			String time=String.valueOf(timestamp.getMonth());

			String strQuery2 = "INSERT Into Sheet1(SNO,TIMESTAMP) VALUES("+s_no+","+time+")";
			connection.executeUpdate(strQuery2);
			System.out.println("Do You Want to add more data?");
			Str = scn.next();
			
		}

		connection.close();
	}
}