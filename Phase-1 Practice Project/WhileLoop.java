package demo;

import java.util.Scanner;

public class WhileLoop {

	public static void main(String[] args) 
	{
		int PINinBankDB = 1234;
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Please enter your ATM PIN - ");
		int PINenteredByUser = scanner.nextInt();
		
		while(PINenteredByUser != PINinBankDB)
		{
			System.out.println("The ATM PIN you enterd is incorret. please try again ");
			PINenteredByUser = scanner.nextInt();
		}
		
		System.out.println("Welcome to ABC");

	}

}
