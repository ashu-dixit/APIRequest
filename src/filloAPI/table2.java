package filloAPI;


import java.sql.Timestamp;
import java.util.Scanner;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.*;

public class table2 {

	public static void main(String[] args) throws FilloException {
		Scanner scn = new Scanner(System.in);
		Fillo fillo = new Fillo();
//		setting table initial value
		System.setProperty("Row", "1");
		System.setProperty("Column", "1");

		Connection connection = fillo.getConnection("E:\\Workbook.xlsx");

		System.out.println("Please enter table name");
		String tablename = scn.next();

//		from line 23 to 29 we are checking if table is present or not if not we vreate a new table
		boolean if_already_present = false;
		for (String str : connection.getMetaData().getTableNames()) {
			if (str.toUpperCase().equals(tablename.toUpperCase())) {
				if_already_present = true;
				break;
			}
		}

		if (!if_already_present) {
			connection.createTable(tablename, new String[] { "Serialno", "Name", "Time", "marks" });
		}
		
//		From line 36 to 46 we are getting next serial no on begning of program
		String strQuery1 = "Select * from " + tablename;
		int serialno = 1;
		Recordset recordset = null;
		try {
			recordset = connection.executeQuery(strQuery1);
			recordset.moveLast();
			serialno = Integer.valueOf((recordset.getField("Serialno"))) + 1;
		} catch (Exception e) {

		}

		String userinput = "YES";

//		in this loop we are going to get user input and put it in the excel sheet using insert query 
		while (userinput.equals("YES")) {
			System.out.print("Please enter name:-");
			String name = scn.next();
			System.out.print("Please enter Marks:-");
			String marks = scn.next();

			Timestamp time = new Timestamp(System.currentTimeMillis());

			String strquery = "INSERT Into " + tablename + "(Serialno,Name,Time,marks) VALUES('" + serialno + "','" + name
					+ "','" + time + "','" + marks + "')";
			connection.executeUpdate(strquery);
			System.out.println("if you want to Add more data(yes/no)");
			userinput = scn.next();
			userinput = userinput.toUpperCase();
			serialno++;
		}

		scn.close();
		connection.close();
	}

}

