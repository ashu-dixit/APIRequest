package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;
import Fillo.Recordset;

public class Select_where_Method {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("C:\\fillo.xlsx");
		
		String strquery="Select * from sheet1";
		
		Recordset rs=connection.executeQuery(strquery);
		
	}

}
