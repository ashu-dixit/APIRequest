package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Select_where_API {

	public static void main(String[] args) throws FilloException {
		Fillo fillo= new Fillo();
		Connection con=fillo.getConnection("E:\\Book1.xlsx");
		
		String strquery="Select * from Sheet1 where firstname='Amit' and lastname='srivastav' ";
		Recordset rs = con.executeQuery(strquery);
		
		while(rs.next()) {
			System.out.println(rs.getField("FirstName")+" "+rs.getField("LastName")+" "+rs.getField("max marks")+" "+rs.getField("marksobtain")+" "+rs.getField("Marks"));
		}
		rs.close();
		con.close();
	}

}
