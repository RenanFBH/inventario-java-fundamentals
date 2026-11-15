package Tester;

import java.math.BigDecimal;
import java.util.Scanner;

import model.Product;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int[] tempId = new int[6];
		String[] tempName = new String[6];
		int[] tempQtyStock = new int[6];
		BigDecimal[] tempPrice = new BigDecimal[6];
		
		
		
		System.out.print("================================================\n");
		System.out.print("Adicionando produtos 1 e 2\n");
		
		for(int i = 0; i < 2; i++) {
			try {
				System.out.print("================================================");
				
				System.out.print("\n\nInforme o id do produto " + (i+1) + ": ");
				tempId[i] = in.nextInt();
				
				in.nextLine();
				System.out.print("Informe o nome do produto" + (i+1) + ": ");
				tempName[i] = in.nextLine();
				
				System.out.print("Informe a quantidade em estoque do produto " + (i+1) + ": ");
				tempQtyStock[i] = in.nextInt();
				
				System.out.print("Informe o preço do produto " + (i+1) + ": ");
				tempPrice[i] = in.nextBigDecimal();
				
			} catch(Exception e) {
				
				System.out.print("================================================");
				System.out.println("Valor inválido: " + e.getMessage());
				System.out.print("================================================");
				break;
			}
							
		}
		
		in.close();
		
		System.out.print("\n\n================================================\n");
		System.out.print("Listando produtos\n");
		System.out.print("================================================\n\n");
		
		Product p1 = new Product(tempId[0], tempName[0], tempQtyStock[0], tempPrice[0]);
		Product p2 = new Product(tempId[1], tempName[1], tempQtyStock[1], tempPrice[1]);
		Product p3 = new Product(10006, "Grand Theft Auto VI", 95, new BigDecimal("550.00"));
		Product p4 = new Product(10004, "Red Dead Redemption II", 1376, new BigDecimal("250.00"));
		Product p5 = new Product(10005, "Resident Evil 4 Remake", 650, new BigDecimal("160.00"));
		Product p6 = new Product(10001, "The Witcher 3", 8329, new BigDecimal("100.00"));
		
		p6.setActive(false);
		
		Product[] products = {p1, p2, p3, p4, p5, p6};
		
		for(Product p: products) {
			System.out.println(p + "\n");
		}
		
	}

}
