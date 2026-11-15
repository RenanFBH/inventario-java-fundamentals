package Tester;

import java.math.BigDecimal;

import model.Product;

public class ProductTester {

	public static void main(String[] args) {
		
		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product(10006, "Grand Theft Auto VI", 95, new BigDecimal("550.00"));
		Product p4 = new Product(10004, "Red Dead Redemption II", 1376, new BigDecimal("250.00"));
		Product p5 = new Product(10005, "Resident Evil 4 Remake", 650, new BigDecimal("160.00"));
		Product p6 = new Product(10001, "The Witcher 3", 8329, new BigDecimal("100.00"));
		
		Product[] products = {p1, p2, p3, p4, p5, p6};
		
		for(Product p: products) {
			System.out.println(p + "\n");
		}
		
	}

}
