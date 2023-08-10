package zookeeper;

import java.util.Scanner;

public class Zookeeper extends ZooInhabitants {

	private final static Scanner sc = new Scanner(System.in);
	private String userName;
	private String numberFormatExceptionMessage = """
			****************************************
			ERROR : Only Numeric Values Are Allowed.
			****************************************
			""";
	private String goodByeMessage = """
			^^^^^^^^^^^^^^^^^^^^^^
			See you later!
			^^^^^^^^^^^^^^^^^^^^^^
			""";

	private void welcomeMessage() {
		// Please don't touch this ASCII otherwise it may not be displayed properly on
		// the console
		System.out.println("" + "\r\n"
				+ " __    __     _                            _____        _____ _            _____            \r\n"
				+ "/ / /\\ \\ \\___| | ___ ___  _ __ ___   ___  /__   \\___   /__   \\ |__   ___  / _  / ___   ___  \r\n"
				+ "\\ \\/  \\/ / _ \\ |/ __/ _ \\| '_ ` _ \\ / _ \\   / /\\/ _ \\    / /\\/ '_ \\ / _ \\ \\// / / _ \\ / _ \\ \r\n"
				+ " \\  /\\  /  __/ | (_| (_) | | | | | |  __/  / / | (_) |  / /  | | | |  __/  / //\\ (_) | (_) |\r\n"
				+ "  \\/  \\/ \\___|_|\\___\\___/|_| |_| |_|\\___|  \\/   \\___/   \\/   |_| |_|\\___| /____/\\___/ \\___/ \r\n"
				+ "                                                                                            \r\n"

		);
		System.out.println("Please enter your name : ");
		userName = sc.nextLine();
		System.out.println("\nHi " + userName + ", I'm the zookeeper of this zoo. Let's explore the zoo together.");
	}

	private void mainMenu() {
		String choice = "";
		while (true) {
			System.out.println("\nPlease select a number from the menu");
			System.out.println("--------------------------------------");
			System.out.println("1. View a habitat.");
			System.out.println("2. Exit.");
			System.out.println("Enter your choice : ");
			choice = sc.nextLine();

			if (choice.equals("2")) {
				System.out.println(goodByeMessage);
				break;
			}

			checkExceptions(choice);

			if (choice.equals("1")) {
				habitatMenu();
				break;
			}
		}
	}

	private void checkExceptions(String choice) {
		try {
			// This will check if the user input is even a number. If not a number then
			// parsing it as a double number would throw NumberFormatException
			Double.parseDouble(choice);

			// This will check if the user input is either 1 or 2. If not then the user
			// defined exception will be thrown.
			if (!choice.equals("1") && !choice.equals("2")) {
				throw new PossibleExceptions();
			}
		} catch (PossibleExceptions e) {
			// Calling one of the methods in the user defined exception class
			e.AllowedNumericValuesAre1and2();
		} catch (NumberFormatException e) {
			System.out.print(numberFormatExceptionMessage);
		}
	}

	private void habitatMenu() {
		while (true) {
			System.out.println("\nPlease select a number from the below menu");
			System.out.println("--------------------------------------------");
			System.out.println("1. Enter the habitat number to view it.");
			System.out.println("2. Exit");
			String choice = "";

			System.out.println("Enter your choice : ");
			choice = sc.nextLine();

			if (choice.equals("2")) {
				System.out.println(goodByeMessage);
				break;
			}

			checkExceptions(choice);

			if (choice.equals("1")) {
				while (true) {
					System.out.println("\nPlease enter the habitat number : ");
					choice = sc.nextLine();
					try {
						// This will check if the user input is even a number. If not a number then
						// parsing it as a double number would throw NumberFormatException
						Double.parseDouble(choice);

						// This will check if the user input is from 1 to 6. If not then the user
						// defined exception will be thrown.
						if (!(Integer.parseInt(choice) >= 1 && Integer.parseInt(choice) <= 6)) {
							throw new PossibleExceptions();
						} else {
							// Proceeding with printing the habitat when everything is okay
							printHabitat(choice);
							break;
						}
					} catch (PossibleExceptions e) {
						// Calling one of the methods in the user defined exception class
						e.HabitatNumbersAreFrom1To6();
					} catch (NumberFormatException e) {
						System.out.print(numberFormatExceptionMessage);
					}
				} // end of inner while
			} // end of if
		} // end of outer while (true)
	}

	private void printHabitat(String choice) {
		// The elements of animals[] are data members of ZooInhabitants class.
		String[] animals = { camel, lion, deer, goose, bat, rabbit };
		int index = Integer.parseInt(choice) - 1;
		System.out.print("\n" + animals[index]);
	}

	public static void main(String[] args) {
		Zookeeper zkeeper = new Zookeeper();
		zkeeper.welcomeMessage();
		zkeeper.mainMenu();
	} // end of main()

} // end of class