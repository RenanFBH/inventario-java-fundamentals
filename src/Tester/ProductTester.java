package Tester;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.Product;

public class ProductTester {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int maxSize, menuChoice;
		
		maxSize = getNumProducts(in);
		
		if(maxSize == 0) {
			
			System.out.println("\n--------------------------------------------------------");
			System.out.println("Não há produtos");
			System.out.println("--------------------------------------------------------\n");
			
		} else {
			
			Product[] products = new Product[maxSize];
			
			addToInventory(in, products);
			
			do {
				
				menuChoice = getMenuOption(in);
				executeMenuChoice(menuChoice, products, in);
				
			} while(menuChoice != 0);
			
		}
		
		in.close();
		
	}
	
	public static void addToInventory(Scanner in, Product[] products) {
		
		int[] tempId = new int[6];
		String[] tempName = new String[6];
		int[] tempQtyStock = new int[6];
		BigDecimal[] tempPrice = new BigDecimal[6];
		
		boolean isCreated = false;
		
		for(int i = 0; i < products.length; i++) {
			
			while(!isCreated) {
				
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
					
					isCreated = true;
					
				} catch(Exception e) {
					
					System.out.print("\n\n--------------------------------------------------------");
					System.out.println("\nValor inválido: " + e.getMessage());
					System.out.print("--------------------------------------------------------\n\n");
					in.nextLine();
					
				}
				
			}
							
		}
		
	}
	
	public static void displayInventory(Product[] products) {
		System.out.println();
		System.out.println("--------------------------------------------------------");
		System.out.print("Listando produtos\n");
		System.out.println("--------------------------------------------------------\n");
		for(Product product: products) {
			System.out.println(product + "\n");
		}
	}
	
	public static int getNumProducts(Scanner in) {
		
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
		
		return maxSize;
		
	}

	public static int getMenuOption(Scanner in) {
		
		int choose = -1;
		
		System.out.println("\n\n\n========================================================");
		System.out.println("Menu");
		System.out.println("========================================================");
		System.out.println("1. Exibir inventário");
		System.out.println("2. Adicionar estoque");
		System.out.println("3. Deduzir estoque");
		System.out.println("4. Descontinuar produto");
		System.out.println("0. Sair");
		System.out.print("Insira uma opção de menu: ");
		while(choose < 0 || choose > 4) {
			try {
				choose = in.nextInt();
				if(choose < 0 || choose > 4) {
					System.out.println("\n--------------------------------------------------------");
					System.out.println("Valor incorreto inserido!");
					System.out.println("--------------------------------------------------------\n");
				}
			} catch (Exception e) {
				System.out.println("\n--------------------------------------------------------");
				System.out.println("Tipo incorreto de dados inserido: " + e.getMessage());
				System.out.println("--------------------------------------------------------\n");
				in.nextLine();
			}
		}
		
		return choose;
	}
	
	public static int getProductNumber(Scanner in, Product[] products) {
		
		int productChoice = -1;
		
		System.out.println("\n--------------------------------------------------------");
		System.out.println("Exibindo lista de produtos!");
		System.out.println("--------------------------------------------------------\n");
		for(int i = 0; i < products.length; i++) {
			System.out.println("[" + i + "] " + products[i].getName());
		}
		while (productChoice < 0 || productChoice >= products.length) {
			
			try {
				System.out.println("--------------------------------------------------------\n");
				System.out.print("Informe o número do produto: ");
				productChoice = in.nextInt();
				if(productChoice < 0 || productChoice >= products.length) {
					System.out.println("\n--------------------------------------------------------");
					System.out.println("Valor incorreto inserido!");
					System.out.println("--------------------------------------------------------\n");
				}
			} catch (Exception e) {
				System.out.println("========================================================");
				System.out.println("\n--------------------------------------------------------");
				System.out.println("Tipo incorreto de dados inserido: " + e.getMessage());
				System.out.println("--------------------------------------------------------\n");
				in.nextLine();	
			}
			
		}
		
		for(int i = 0; i < products.length; i++) {
			if(productChoice == products[i].getId()) {
				System.out.println(products[i] + "\n");
			}
		}
			
		return productChoice;
	
	}
	
	public static void addInventory(Scanner in, Product[] products) {
		
		int productChoice, updateValue = -1;
		
		productChoice = getProductNumber(in, products);
		
		while (updateValue < 0) {
			
			try {
				System.out.println("\n--------------------------------------------------------");
				System.out.print("Quantos produtos deseja adicionar? ");
				updateValue = in.nextInt();
				if(updateValue < 0) {
					System.out.println("\n--------------------------------------------------------");
					System.out.println("Valor incorreto inserido!");
					System.out.println("--------------------------------------------------------\n");
				}
			} catch (Exception e) {
				System.out.println("\n--------------------------------------------------------");
				System.out.println("Tipo incorreto de dados inserido: " + e.getMessage());
				System.out.println("--------------------------------------------------------\n");
				in.nextLine();	
			}
			
		}
		
		products[productChoice].addToInventory(updateValue);
		
	}
	
	public static void deductInventory(Scanner in, Product[] products) {
		
		int productChoice, updateValue = -1;
		
		productChoice = getProductNumber(in, products);
		
		while (updateValue < 0 || updateValue > products[productChoice].getQtyStock()) {
			
			try {
				System.out.println("\n--------------------------------------------------------");
				System.out.print("Quantos produtos deseja deduzir? ");
				updateValue = in.nextInt();
				if(updateValue < 0 || updateValue > products[productChoice].getQtyStock()) {
					System.out.println("\n--------------------------------------------------------");
					System.out.println("Valor inserido incorreto!");
					System.out.println("--------------------------------------------------------\n");
				}
			} catch (Exception e) {
				System.out.println("\n--------------------------------------------------------");
				System.out.println("Tipo incorreto de dados inserido: " + e.getMessage());
				System.out.println("--------------------------------------------------------\n");
				in.nextLine();	
			}
			
		}
		
		products[productChoice].deductFromInventory(updateValue);
		
	}
	
	public static void discontinueInventory(Scanner in, Product[] products) {
		
		int productChoice;
		
		productChoice = getProductNumber(in, products);
		
		products[productChoice].setActive(false);
		
	}

	public static void executeMenuChoice(int choose, Product[] products, Scanner in) {
		
		
		switch(choose) {
			case 1:
				System.out.println("\n\n\n========================================================");
				System.out.println("Exibir Lista de Produtos");
				System.out.println("========================================================");
				displayInventory(products);
				break;
			case 2:
				System.out.println("\n\n\n========================================================");
				System.out.println("Adicionar Estoque");
				System.out.println("========================================================");
				addInventory(in, products);
				break;
			case 3:
				System.out.println("\n\n\n========================================================");
				System.out.println("Deduzir Estoque");
				System.out.println("========================================================");
				deductInventory(in, products);
				break;
			case 4:
				System.out.println("\n\n\n========================================================");
				System.out.println("Descontinuar Estoque");
				System.out.println("========================================================");
				discontinueInventory(in, products);
				break;
		}
		
	}
	
}
