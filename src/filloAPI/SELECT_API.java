package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class SELECT_API {

	public static void main(String[] args) throws FilloException {
		Fillo fillo=new  Fillo();
		Connection connection=fillo.getConnection("C:\\Book1.xlsx");
		
		String strquery="Select * from Sheet1";
		Recordset rs =connection.executeQuery(strquery); 
		
		while(rs.next()) {
			System.out.println(rs.getField("First Name"));
		}
		rs.close();
		connection.close();

}
}