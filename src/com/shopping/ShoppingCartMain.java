package com.shopping;



import java.util.Scanner;
import java.util.logging.Logger;
import java.util.logging.*;


public class ShoppingCartMain {
	
	private static final Logger logger=Logger.getLogger(ShoppingCartMain.class.getName());

	// Fields used through program so it has static access modifier
	static int totalItems;
	static String[] items;
	static double[] prices;
	static int[] quantity;
	
	//Methods
	private static double getItemPrice(String m) {
		System.out.print(m);
		Scanner scan=new Scanner(System.in);
		return scan.nextDouble();
	}
	
	private static String getItemName(String m) {
		System.out.print(m);
		Scanner scan=new Scanner(System.in);
		return scan.nextLine();
	}
	
	private static int getItemQuantity(String m) {
		System.out.print(m);
		Scanner scan=new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static int getNumberOfItems(String m) {
		System.out.print(m);
		Scanner scan=new Scanner(System.in);
		return scan.nextInt();
	}
	
	private static void getItemDetails(int index) {
		items[index]=getItemName("What is the name of item #"+(index+1)+"?");
		prices[index]=getItemPrice("What is the price of item #"+(index+1)+"?");
		quantity[index]=getItemQuantity("How many of item #"+(index+1)+" do you want to buy? ");
		
	}
	
	private static void displayCart() {
		System.out.println("###########################");
		System.out.println("Shopping Cart Details........");
		System.out.println("############################"+"\n");
		System.out.println("Quantity"+" -- "+"Item"+"................"+"Item Price"+" = Item Total Price");
		
		try {
		for(int i=0;i< totalItems;i++) {
			showlineItem(i);
			}
		System.out.println("\n");
		System.out.println("###############################");
		}catch(ArrayIndexOutOfBoundsException e) {
		logger.log(Level.INFO,"ArrayIndexOutOfBoundsException" );
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	private static void showlineItem(int index) {
		String quantityText=quantity[index]+"\t--\t";
		String itemText= items[index]+".................";
		String priceText=prices[index]+" = "+"$"+prices[index]*quantity[index];
		
		
		System.out.println(quantityText+itemText+priceText);
	}
	
	
	public static void main(String[] args) {
		System.out.println("Welcome to my store");
		System.out.println("--XXXX----XXX---XXX----");
		try {
		totalItems=getNumberOfItems("How many items do you want to buy? ");
		}catch(Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Only number is accepted here as input.");
			totalItems=getNumberOfItems("How many items do you want to buy? ");
		}
		items=new String[totalItems];
		prices=new double[totalItems];
		quantity=new int[totalItems];
		
		int count=0;
		while(count < totalItems) {
			getItemDetails(count);
			count++;
		}
		System.out.println("\n"+"\n");
		
		displayCart();
		
	}
	
	
	

}
