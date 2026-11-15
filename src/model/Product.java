package model;

import java.math.BigDecimal;

public class Product {
	
	//Declarações de campo de instância
	private int id;
	private String name;
	private int qtyStock;
	private BigDecimal price;
	
	
	//Construtor padrão, permite o compilador iniciar os campos com os valores padrão
	public Product() { 
	
	}
	
	//Sobrecarga do método construtor para inicializar o objeto com as variáveis pré-definidas
	public Product(int id, String name, int qtyStock, BigDecimal price) {
		this.id = id;
		this.name = name;
		this.qtyStock = qtyStock;
		this.price = price;
	}
	
	
	//Retorna a descrição do produto
	public String toString() {
		String s = "Número do Item: " + getId() 
				 + "\nNome: " + getName()
				 + "\nQuantidade em estoque: " + getQtyStock()
				 + "\nPreço: R$" + getPrice();
		return s;
	}
	
	//Getters - Permitem retornar os valores das variáveis de instância
	//Setters - Permitem alterar os valores das variáveis de instância
	public int getId() {
		return this.id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQtyStock() {
		return this.qtyStock;
	}
	
	public void setQtyStock(int qtyStock) {
		this.qtyStock = qtyStock;
	}
	
	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
