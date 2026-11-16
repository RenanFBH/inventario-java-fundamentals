package Tester;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Product;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int[] tempId = new int[6];
		String[] tempName = new String[6];
		int[] tempQtyStock = new int[6];
		BigDecimal[] tempPrice = new BigDecimal[6];
		int maxSize = -1;
		
		
		while(maxSize < 0) {
			try {
				System.out.println("========================================================");
				System.out.println("Insira o número de produtos que gostaria de adicionar ");
				System.out.print("Insira 0 (zero) se não quiser adicionar produtos: ");
				maxSize = in.nextInt();
				System.out.println("========================================================");
				if(maxSize < 0) {
					System.out.println("\n--------------------------------------------------------");
					System.out.println("Valor incorreto inserido!");
					System.out.println("--------------------------------------------------------\n");
				}
			} catch(Exception e) {
				System.out.println("========================================================");
				System.out.println("\n--------------------------------------------------------");
				System.out.println("Tipo incorreto de dados inserido: " + e.getMessage());
				System.out.println("--------------------------------------------------------\n");
				in.nextLine();
			}
		}
		
		if(maxSize <= 0) {
			System.out.println("\n--------------------------------------------------------");
			System.out.println("Não há produtos1");
			System.out.println("--------------------------------------------------------\n");
		} else {
			
			Product[] products = new Product[maxSize];
			
			for(int i = 0; i < products.length; i++) {
				try {
					
					System.out.printf("\nProduto: %d\n", (i+1));
					System.out.print("Informe o id do produto " + (i+1) + ": ");
					tempId[i] = in.nextInt();
					
					in.nextLine();
					System.out.print("Informe o nome do produto " + (i+1) + ": ");
					tempName[i] = in.nextLine();
					
					System.out.print("Informe a quantidade em estoque do produto " + (i+1) + ": ");
					tempQtyStock[i] = in.nextInt();
					
					System.out.print("Informe o preço do produto " + (i+1) + ": ");
					tempPrice[i] = in.nextBigDecimal();
					
					products[i] = new Product(tempId[i], tempName[i], tempQtyStock[i], tempPrice[i]);
					
				} catch(Exception e) {
					
					System.out.print("========================================================");
					System.out.println("Valor inválido: " + e.getMessage());
					System.out.print("========================================================");
					break;
				}
								
			}
			
			System.out.println();
			System.out.println("--------------------------------------------------------");
			System.out.print("Listando produtos\n");
			System.out.println("--------------------------------------------------------\n");
			for(Product product: products) {
				System.out.println(product + "\n");
			}
			
		}
		
		in.close();
		
	}

}
