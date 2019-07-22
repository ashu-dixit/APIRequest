package filloAPI;

import org.apache.poi.common.usermodel.Fill;

import Exception.FilloException;
import Fillo.Connection;
import Fillo.Fillo;

public class Delete_query {

	public static void main(String[] args) throws FilloException {
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("E:\\fillo.xlsx");
		
		String strquery="Delete from Sheet1 where name='first3'";
		
		connection.executeUpdate(strquery);
		
		connection.close();
		
	}

}
