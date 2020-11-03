package database;

import java.sql.SQLException;

public class Main {
	

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		Config c=new Config();
		c.InitailConnection();
		c.connection();
		
	  }

}
