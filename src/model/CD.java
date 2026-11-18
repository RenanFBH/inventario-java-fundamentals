package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class CD extends Product {

	private String artist;
	private int numberSongs;
	private String stamp;
	
	public CD(int id, String name, int qtyStock, BigDecimal price, String artist, int numberSongs, String stamp) {
		super(id, name, qtyStock, price);
		this.artist = artist;
		this.numberSongs = numberSongs;
		this.stamp = stamp;
	}
	
	
	public String toString() {
		DecimalFormat real =  new DecimalFormat("0.00");
		String s = "Número do Item: " + super.getId() 
				 + "\nNome: " + super.getName()
				 + "\nArtista: " + this.getArtist()
				 + "\nMúsicas do Álbum: " + this.getNumberSongs()
				 + "\nSelo de gravação: " + this.getStamp()
				 + "\nQuantidade em estoque: " + super.getQtyStock()
				 + "\nPreço: R$ " + real.format(super.getPrice()) 
				 + "\nValor do estoque: R$" + real.format(this.getInventoryValue())
				 + "\nStatus do produto: " + (super.getActive() ? "Ativo" : "Descontinuado");
		return s;
	}
	
	public String getArtist() {
		return this.artist;
	}
	
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	public int getNumberSongs() {
		return this.numberSongs;
	}
	
	public void setNumberSongs(int numberSongs) {
		this.numberSongs = numberSongs;
	}
	
	public String getStamp() {
		return this.stamp;
	}
	
	public void setStamp(String stamp) {
		this.stamp = stamp;
	}
	
	
}
