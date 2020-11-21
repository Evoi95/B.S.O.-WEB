package database;

import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDefaultDb {

	private static boolean status ;
	private static Statement st = null ;
	private static Statement stmt = null ;
	private static String query ;
	private static String qSelect ;
	private static String qInsert ;
	
	public PopulateDefaultDb()
	{
		try 
		{
			
			if(ConnToDb.InitailConnection() && !ConnToDb.connection() ) 
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
						+ "      email Varchar(20), pwd varchar(20)"
						+ "	);"
						+ "\n"
						+ "Create table  if not exists LIBRO "
						+ "	( titolo VARCHAR(100), numeroPagine float, "
						+ "    Cod_isbn varchar(10), editore varchar(100) primary key,"
						+ "    autore varchar(100), lingua varchar(10),"
						+ "    categoria Varchar(60), dataPubblicazione date,"
						+ "    recensione text, copieVendute int, breveDescrizione text,"
						+ "    disponibilita' int, prezzo float"
						+ "    ,img longblob, copieRimanenti int);"
						+ "\n"
						+ "Create table  if not exists EDIOTRE "
						+ "	( Nome Varchar(20) ,Cognome Varchar(20), "
						+ "	  id int primary key auto_increment, "
						+ "      email Varchar(20), password Varchar(20), "
						+ "      casaEditrice Varchar(100),"
						+ "      NumeroPublicazioni int,"
						+ "      listaScritottoriAssociati varchar(200),"
						+ "      LibriPubblicati Varchar(200),"
						+ "      foreign key (LibriPubblicati) references libro(editore)); "
						+ "\n"
						+ "Create table  if not exists SCRITTORI"
						+ "	( Nome Varchar(20),Cognome Varchar(20),"
						+ "	  id int primary key auto_increment not null,"
						+ "      email Varchar(20), pwd Varchar(20),"
						+ "      nickName Varchar(20), descrizione text,"
						+ "      dataDiNascita Date, ListaDeiPreferiti Varchar(200),"
						+ "      ListaColleghiAssociati Varchar(200), "
						+ "      editore int,"
						+ "      foreign key (editore) references editore(id), "
						+ "      libriPubblicati varchar(20), numeroPublicazioni int);"
						+ "\n "
						+ "Create table if not exists USER "
						+ "	( Nome Varchar(20),Cognome Varchar(20),"
						+ "     id int primary key auto_increment not null, "
						+ "     email Varchar(20), password Varchar(20), "
						+ "     nickName Varchar(20), descrizione text,"
						+ "     dataDiNascita Date, listDeiPreferiti Varchar(200)"
						+ "     );"
						+ "     "
						+ "\n"
						+ "Create table if not exists PAGAMENTO "
						+ "	( id int primary key not null auto_increment,"
						+ "	  Metodo_pagamento int, esito int,"
						+ "      riepilogo text,"
						+ "      idUtente int ,"
						+ "      foreign key (idUtente) references utente(id)"
						+ "	);"
						+ "      ";
				st.executeUpdate(query);
				System.out.println("Tabella popolata");
				
				// popolo il db con utenti e dati  
				ConnToDb.conn.close();				
				
			}
			else if (ConnToDb.InitailConnection() && ConnToDb.connection())
			{
				System.out.println("Connesso a mysql workbench e al database 'ispw' ");
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
