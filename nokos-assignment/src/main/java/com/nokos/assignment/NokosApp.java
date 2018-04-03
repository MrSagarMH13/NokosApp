package com.nokos.assignment;

import java.util.Scanner;

public class NokosApp {

	public static void main(String[] args) {

		int userChoice;
		userChoice = menu();
		System.out.println("Choice is" + userChoice);

	}

	public static int menu() {

		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);

		System.out.println("Choose from these choices");
		System.out.println("-------------------------\n");
		System.out.println("1 - Upload document");
		System.out.println("2 - List down all documents");
		System.out.println("3 - Quit");

		return input.nextInt();
	}

}
