package db_Managment;

public class MYSQL_Client {

	public static void main(String[] args) throws Exception {
		
		Connection1 mysql=new Connection1("test");
		
//		mysql.createtable("ashu");
//		mysql.post("ashu");
		System.out.println(mysql.get("ashu"));
		
	}

}
