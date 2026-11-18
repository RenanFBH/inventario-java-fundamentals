package model;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class DVD extends Product {

	private int durationMinutes;
	private int ageRating;
	private String filmStudio;
	
	public DVD(int id, String name, int qtyStock, BigDecimal price, int durationMinutes, int ageRating, String filmStudio) {
		super(id, name, qtyStock, price);
		this.durationMinutes = durationMinutes;
		this.ageRating = ageRating;
		this.filmStudio = filmStudio;
	}
	
	public BigDecimal getInventoryValue() {
		return super.getInventoryValue().multiply(new BigDecimal("1.05"));
	}
	
	public String toString() {
		DecimalFormat real =  new DecimalFormat("0.00");
		String s = "Número do Item: " + super.getId() 
				 + "\nNome: " + super.getName()
				 + "\nDuração do Filme: " + this.getDurationMinutes()
				 + "\nClassificação etária: " + this.getAgeRating()
				 + "\nEstúdio Cinematográfico: " + this.getFilmStudio()
				 + "\nQuantidade em estoque: " + super.getQtyStock()
				 + "\nPreço: R$ " + real.format(super.getPrice()) 
				 + "\nValor do estoque: R$" + real.format(this.getInventoryValue())
				 + "\nStatus do produto: " + (super.getActive() ? "Ativo" : "Descontinuado");
		return s;
	}
	
	public int getDurationMinutes() {
		return this.getDurationMinutes();
	}
	
	public void setDurationMinutes(int durationMinutes) {
		this.durationMinutes = durationMinutes;
	}
	
	public int getAgeRating() {
		return this.ageRating;
	}
	
	public void setAgeRating(int ageRating) {
		this.ageRating = ageRating;
	}
	
	public String getFilmStudio() {
		return this.filmStudio;
	}
	
	public void setFilmStudio(String filmStudio) {
		this.filmStudio = filmStudio;
	}
	
}
