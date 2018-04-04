package com.nokos.assignment;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import com.google.api.services.drive.model.File;

public class NokosApp {

	public static void main(String[] args) throws IOException {

		int userChoice = 0;
		do {
			userChoice = showMenu();
			switch (userChoice) {
			case 1:
				String filePath = getFilePath();
				if (filePath != null) {

				}
				break;
			case 2:
				GoogleDriveHelper driveHelper = new GoogleDriveHelper();
				List<File> files = driveHelper.getFiles();
				if (files == null || files.isEmpty()) {
					System.out.println("No files found.");
				} else {
					System.out.println("Files:");
					for (File file : files) {
						System.out.printf("%s (%s)\n", file.getName(), file.getId());
					}
				}

				break;
			case 3:
				System.exit(0);
				break;
			default:
				showMenu();
			}
		} while (userChoice != 3);

	}

	private static String getFilePath() {
		String filePath = null;
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		System.out.println("Enter file path:");
		filePath = input.next();
		return filePath;
	}

	public static int showMenu() {

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
