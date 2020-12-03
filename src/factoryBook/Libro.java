package factoryBook;

import java.awt.Image;
import java.io.InputStream;
import java.sql.Date;


public class Libro implements Raccolta {
	
	private String titolo;
	private int numPag;
	private String codIsbn,editore,autore,lingua,categoria;
	private Date dataPubb;
	private String recensione;
	private int nrCopie;
	private String desc;
	private int disponibilita;
	private float prezzo;
	private int copieRim;
	private Image Img;
	
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public int getNumPag() {
		return numPag;
	}
	public void setNumPag(int numPag) {
		this.numPag = numPag;
	}
	public String getCodIsbn() {
		return codIsbn;
	}
	public void setCodIsbn(String codIsbn) {
		this.codIsbn = codIsbn;
	}
	public String getEditore() {
		return editore;
	}
	public void setEditore(String editore) {
		this.editore = editore;
	}
	public String getAutore() {
		return autore;
	}
	public void setAutore(String autore) {
		this.autore = autore;
	}
	public String getLingua() {
		return lingua;
	}
	public void setLingua(String lingua) {
		this.lingua = lingua;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public Date getDataPubb() {
		return dataPubb;
	}
	public void setDataPubb(Date dataPubb) {
		this.dataPubb = dataPubb;
	}
	public String getRecensione() {
		return recensione;
	}
	public void setRecensione(String recensione) {
		this.recensione = recensione;
	}
	public int getNrCopie() {
		return nrCopie;
	}
	public void setNrCopie(int nrCopie) {
		this.nrCopie = nrCopie;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getDisponibilita() {
		return disponibilita;
	}
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}
	public float getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}
	public int getCopieRim() {
		return copieRim;
	}
	public void setCopieRim(int copieRim) {
		this.copieRim = copieRim;
	}
	public Image getImg() {
		return Img;
	}
	public void setImg(Image img) {
		Img = img;
	}
	
	public Libro(String titolo, int numPag, String codIsbn, String editore, String autore, String lingua,
			String categoria, Date dataPubb, String recensione, int nrCopie, String desc, int disponibilita,
			float prezzo, int copieRim, Image img) {
		this.titolo = titolo;
		this.numPag = numPag;
		this.codIsbn = codIsbn;
		this.editore = editore;
		this.autore = autore;
		this.lingua = lingua;
		this.categoria = categoria;
		this.dataPubb = dataPubb;
		this.recensione = recensione;
		this.nrCopie = nrCopie;
		this.desc = desc;
		this.disponibilita = disponibilita;
		this.prezzo = prezzo;
		this.copieRim = copieRim;
		Img = img;
	}
	@Override
	public void compra() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void scarica() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void leggi() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
