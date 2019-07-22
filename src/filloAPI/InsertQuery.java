package filloAPI;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;

public class InsertQuery {

	public static void main(String[] args) throws FilloException {
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("E:\\fillo.xlsx");
		
		String strquery="INSERT Into Sheet1(name,lastname,marks,percentage) VALUES('first7','Second7','440','88')";
		connection.executeUpdate(strquery);
	}

}
