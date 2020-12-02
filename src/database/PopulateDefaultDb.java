package database;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class PopulateDefaultDb {

	private static boolean status ;
	private static Statement st = null ;
	private static Statement stmt = null ;
	private static String query ;
	private static String qSelect ;
	private static String qInsert ;
	private static PreparedStatement prepQ = null;
    private BufferedImage slate;
	
	public PopulateDefaultDb() throws FileNotFoundException
	{
		try 
		{
			
			qInsert="INSERT INTO `ispw`.`libro`"
					+ "(`titolo`,"
					+ "`numeroPagine`,"
					+ "`Cod_isbn`,"
					+ "`editore`,"
					+ "`autore`,"
					+ "`lingua`,"
					+ "`categoria`,"
					+ "`dataPubblicazione`,"
					+ "`recensione`,"
					+ "`copieVendute`,"
					+ "`breveDescrizione`,"
					+ "`disp`,"
					+ "`prezzo`,"
					+ "`copieRimanenti`,"
					+ "`img`)"
					+ "  "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?) ";
			prepQ = ConnToDb.conn.prepareStatement(qInsert);

					
			prepQ.setString(1,"Kobane calling. Oggi"); // titolo varchar 
			prepQ.setInt(2, 312); // numero pagine int
			prepQ.setString(3,"8832734591"); // 
			prepQ.setString(4, "Bao Publishing");
			prepQ.setString(5,"Zerocalcare");
			prepQ.setString(6,"Italiano");
			prepQ.setString(7,"FumettiEManga");
			//ps.setDate(2, new java.sql.Date(endDate.getTime());
			prepQ.setDate(8, java.sql.Date.valueOf("2020-09-04"));  // date
			prepQ.setString(9,"assurdo"); // recensione
			prepQ.setInt(10, 2000); // copie vendute
			prepQ.setString(11, "ciao"); // breve drescizione
			prepQ.setInt(12,1);
			prepQ.setFloat(13, 12);
			prepQ.setInt (14, 15);
			FileInputStream fin = new FileInputStream("imagesBook/icon.png");
			prepQ.setBinaryStream(15, fin);
			prepQ.executeUpdate();
				System.out.println("Tabella popolata");
				
				// popolo il db con utenti e dati  
				ConnToDb.conn.close();				
				

		}
		catch(SQLException e1) 
		{
			e1.printStackTrace();
			System.err.println("ERRORE DI SQL ");
		}
	}

}
