package database;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.List;

public class CreateDefaultDB 
{
	private static boolean status ;
	private static Statement st = null ;
	private static Statement stmt = null ;
	private static String query ;
	private static String qSelect ;
	private static String qInsert ;
	private static PreparedStatement prepQ = null;
    private BufferedImage slate;


	//private static CallableStatement cStmt;

	
	public static void createDefaultDB () throws SQLException, ClassNotFoundException, FileNotFoundException
	{
		try 
		{
			
			if(ConnToDb.InitailConnection() && !ConnToDb.connection()) 
			{
				System.out.println("Connesso a mysql workbench, ma non ho torvato il database 'ispw' ");
				System.out.println("Creo il database 'ispw' ");
				st = ConnToDb.conn.createStatement();
				query="CREATE DATABASE IF NOT EXISTS ispw ";
				st.execute(query);
				query = "USE ispw ";
				st.execute(query);
				System.out.println("Database creato");
				System.out.println("Chiamo la Stored Procedure, per creare le tabelle");
				//cStmt = ConnToDb.conn.prepareCall("call createTableDB");
				
				query=	"CREATE TABLE if not exists ADMIN "
						+ "	( Nome Varchar(20),Cognome Varchar(20),"
						+ "	  id INT primary key auto_increment not null,"
						+ "      email Varchar(30), pwd varchar(20)"
						+ "	);";
				st.executeUpdate(query);
				System.out.println("Creata tabella Admin");
				
				query=	"Create table  if not exists LIBRO "
						+ "	( titolo VARCHAR(200), numeroPagine int, "
						+ "    Cod_isbn varchar(10) primary key, editore varchar(200) ,"
						+ "    autore varchar(200), lingua varchar(10),"
						+ "    categoria Varchar(60), dataPubblicazione date,"
						+ "    recensione text, copieVendute int, breveDescrizione text,"
						+ "    disp int, prezzo float,"
						+ "    copieRimanenti int,img longblob);";
				st.executeUpdate(query);
				System.out.println("Creata tabella Libro");
				
				query=	"Create table  if not exists EDITORE "
						+ "	( Nome Varchar(20) ,Cognome Varchar(20), "
						+ "	  id int primary key auto_increment, "
						+ "      email Varchar(30), password Varchar(20), "
						+ "      casaEditrice Varchar(200),"
						+ "      NumeroPublicazioni int,"
						+ "      listaScritottoriAssociati varchar(200),"
						+ "      LibriPubblicati Varchar(200)"
						+ "      ); ";
				st.executeUpdate(query);				
				System.out.println("Creata tabella Editore");
				
				query=	"Create table  if not exists SCRITTORI"
						+ "	( Nome Varchar(20),Cognome Varchar(20),"
						+ "	  id int primary key auto_increment not null,"
						+ "      email Varchar(30), pwd Varchar(20),"
						+ "      nickName Varchar(20), descrizione text,"
						+ "      dataDiNascita Date, ListaDeiPreferiti Varchar(200),"
						+ "      ListaColleghiAssociati Varchar(200), "
						+ "      editore int,"
						+ "      libriPubblicati varchar(20), numeroPublicazioni int);";
				st.executeUpdate(query);
				System.out.println("Creata tabella Scrittori");
				
				query=	"Create table if not exists USER "
						+ "	( Nome Varchar(20),Cognome Varchar(20),"
						+ "     id int primary key auto_increment not null, "
						+ "     email Varchar(30), password Varchar(20), "
						+ "     nickName Varchar(20), descrizione text,"
						+ "     dataDiNascita Date, listDeiPreferiti Varchar(200)"
						+ "     );";
				st.executeUpdate(query);
				System.out.println("Creata tabella User");
				
				query=	"Create table if not exists PAGAMENTO "
						+ "	( id int primary key not null auto_increment,"
						// metto un int perche psso avere 3 pagametni 0 carta di credito, 1 contanti, -1 errore
						+ "	  Metodo_pagamento int, esito int,"
						+ "      riepilogo text,"
						+ "      idUtente int);";
				st.executeUpdate(query);
				System.out.println("Creata tabella Pagamento");
				
				query=	"Create table if not exists RIVISTA "
						+ "	( titolo VARCHAR(200),tipologia Varchar(60),"
						+ "	autore varchar(200), lingua varchar(10),"
						+ "	 editore varchar(200) ,"
						+ "	Descrizione text, dataPubblicazione date,"
						+ " disp int,"
						+ "	prezzo float,"
						+ "	copieRimanenti int,img longblob,"
						+ "id int primary key not null auto_increment);";
				st.executeUpdate(query);
				System.out.println("Creata tabella RIVISTA");
				
				query=	"Create table if not exists GIORNALE "
						+ "	( titolo VARCHAR(200),tipologia Varchar(60),"
						+ "	lingua varchar(10),"
						+ "	editore varchar(200) ,"
						+ "	dataPubblicazione date,"
						+ " copiRim int, "
						+ "	disp int,"
						+ "	prezzo float,"
						+ " img longblob,"
						+ " id int primary key not null auto_increment);";
				st.executeUpdate(query);
				System.out.println("Creata tabella GIORNALE");
				
				
				System.out.println("Tabelle create!");
				PopulateDefaultDb.populateDefaultDb();
				System.out.println("Tabella populata con valori di default");
				ConnToDb.conn.close();
				System.out.println("Connesione chiusa col db");
				
				
			}
			else if (ConnToDb.InitailConnection() && ConnToDb.connection())
			{
				
				ConnToDb.conn.close();		
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
