package database;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager;
public class Config {
	
	private String host,user,pwd,database,port,driver,url;
	private  Connection conn=null;

	
	public Config()
	{
		this.host="localhost";
		this.user="root";
		this.pwd="root";
		this.database="ispw";
		this.port="3306";
		this.driver="com.mysql.cj.jdbc.Driver";
		this.url="jdbc:mysql://localhost/sys?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	}
	
	
	public String getHost()
	{
		return this.host;
	}
	public String getUser()
	{
		return this.user;
	}
	public String getPwd()
	{
		return this.pwd;
	}
	public String getDB()
	{
		return this.database;
	}
	public String getPort()
	{
		return this.port;
	}
	public String getDriver()
	{
		return this.driver;
	}
	
	public String getUrl()
	{
		return this.url;
	}
	
	public  boolean InitailConnection() {
		
		try {
		Class.forName(getDriver());
		System.out.print("Tentativo di conessione al server..........\n");
		conn = DriverManager.getConnection(getUrl(), getUser(),getPwd());
		System.out.print("Connesso initial..........\n");
		return true;
		
		} catch (SQLException e1) {
		e1.printStackTrace();
		System.err.println("ERRORE DI SQL");
		} catch (ClassNotFoundException e2) {
		e2.printStackTrace();
		System.err.println("ERRORE ");
		}
		return false;
		}

	
	
	
				    

			public  boolean connection() throws SQLException {

			try {
			String serverURL_2 = "jdbc:mysql://localhost/ispw?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			Class.forName(getDriver());
			System.out.print("Tentativo di conessione al server..........\n");
			conn = DriverManager.getConnection(serverURL_2, getUser(),getPwd());
			System.out.print("Connesso standard..........\n");
			return true;
			} catch (SQLException e1) {
			e1.printStackTrace();
			System.err.println("ERRORE DI SQL");
			} catch (ClassNotFoundException e2) {
			e2.printStackTrace();
			System.err.println("ERRORE");
			}			
				//	}
		//return esito;
			return false;
	}

}
