package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;

public class Update_Query {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("E:\\fillo.xlsx");
		
		String strquery="Update Sheet1 set name='Ashu' where name ='first1' and lastname ='second2' ";
		
		connection.executeUpdate(strquery);
		connection.close();
	}

}
