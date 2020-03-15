package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Select_like_api {

	public static void main(String[] args) throws FilloException {
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("E:\\fillo.xlsx");
		
		String strquery="Select * from Sheet1 where Name like '%1'";
		Recordset rs=connection.executeQuery(strquery);
		
		while(rs.next()) {
			System.out.println(rs.getField("Marks"));
		}
		rs.close();
		connection.close();
	}

}
