package database;

import java.sql.*;

public class CreateDefaultDB 
{
	private static boolean status ;
	private static Statement st = null ;
	private static Statement stmt = null ;
	private static String query ;
	private static String qSelect ;
	private static String qInsert ;
	

	
	
	public static void createDefaulDB () throws SQLException, ClassNotFoundException
	{
	
		try 
		{
			status = ConnToDb.InitailConnection() ;
			if(status) 
			{
				st = ConnToDb.conn.createStatement();
				query="CREATE DATABASE IF NOT EXISTS ispw";
				st.execute(query);
		
				
			
				
			}
			else 
			{
				System.err.println("Errore di connesione al db");
			}
		}
		catch(SQLException e1) 
		{
			e1.printStackTrace();
			System.err.println("ERRORE DI SQL ");
		}
		
		
	}
}
