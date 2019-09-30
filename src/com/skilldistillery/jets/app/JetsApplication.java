package com.skilldistillery.jets.app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class JetsApplication {
	private AirField AF = new AirField();
	private Scanner kb = new Scanner(System.in);

	public static void main(String[] args) throws Exception{
		JetsApplication app = new JetsApplication();

		app.launch();
	}

	private void launch() {
		int i = 0, j = 1;
		AF.parkPlanes();
		do {
			String input = displayUserMenu(kb);
			switch (input) {
			case "1":
				listFleet();
				break;

			case "2":
				flyAllJets();
				break;

			case "3":
				getFastestJet();
				break;

			case "4":
				getLongestRangeJet();
				break;

			case "5":
				loadCargoPlanes();
				break;

			case "6":
				dogfight();
				break;

			case "7":
				addJets();
				break;

			case "8":
				removeJet();
				break;

			case "9":
				flyJet();
				break;

			case "10":
				hirePilot();
				break;

			case "11":
				AF.saveFile(kb);
				break;

			case "12":
				System.out.println("\nFLY, FIGHT, WIN!");
				System.out.println("GOODBYE!");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid Entry!");
				break;
			}
			i++;
			j++;
		} while (i < j);
		kb.close();
	}

	private String displayUserMenu(Scanner kb) {
		System.out.println("\nPlease select an option from the menu:");
		System.out.println("1.List fleet");
		System.out.println("2.Fly all jets");
		System.out.println("3.View fastest jet");
		System.out.println("4.View jet with longest range");
		System.out.println("5.Load all Cargo Jets");
		System.out.println("6.Dogfight!");
		System.out.println("7.Add a jet to Fleet");
		System.out.println("8.Remove a jet from Fleet");
		System.out.println("9.Choose a jet to fly");
		System.out.println("10.Hire pilot");
		System.out.println("11.Save To Text File");
		System.out.println("12.Quit");
		String input = kb.next();
		return input;
	}

	private void listFleet() {
		System.out.println();
		for (Jet element : AF.getJets()) {
			System.out.println(element.toString());
		}
	}

	private void flyAllJets() {
		System.out.println();
		for (Jet element : AF.getJets()) {
			element.Fly();
		}
	}

	private void getFastestJet() {
		int fast = 0;
		String jetIndx = " ";
		for (Jet jet : AF.getJets()) {
			int current = jet.getSpeed();
			String currentStr = jet.toString();
			if (current > fast) {
				fast = current;
				jetIndx = currentStr;
			}
		}
		System.out.println("The fastest jet is: \n");
		System.out.println(jetIndx);
	}

	private void getLongestRangeJet() {
		int range = 0;
		String jetIndx = " ";
		for (Jet jet : AF.getJets()) {
			int current = jet.getRange();
			String currentStr = jet.toString();
			if (current > range) {
				range = current;
				jetIndx = currentStr;
			}
		}
		System.out.println("The jet with the most range is: \n");
		System.out.println(jetIndx);
	}

	private void loadCargoPlanes() {
		for (Jet jet2 : AF.getJets()) {
			if (jet2 instanceof CargoPlane) {
				CargoPlane e = (CargoPlane) jet2;
				e.loadCargo();
			}
		}
	}

	private void dogfight() {
		for (Jet jet2 : AF.getJets()) {
			if (jet2 instanceof FighterJet) {
				FighterJet e = (FighterJet) jet2;
				e.fight();
			}
		}
	}

	private void addJets() {
		System.out.println("Would you like to create a Fighter (F), Cargo (C) or Civilian(Civ) Jet?");
		String input = kb.next().toLowerCase();
		System.out.println("Please enter Model: ");
		String model = kb.next();
		System.out.println("Please enter Max Speed (Mph): ");
		int speed = kb.nextInt();
		System.out.println("Please enter Max Range: ");
		int range = kb.nextInt();
		System.out.println("Please enter Price: ");
		long price = kb.nextLong();
		String pilot = AF.getPilot();
		String nation = AF.getNation();

		AF.addJet(input, model, speed, range, price, pilot, nation);
	}

	private void removeJet() {
		int i = 0;
		do {
			System.out.println("Please enter the index number you would like to remove: \n");
			for (Jet element : AF.getJets()) {
				System.out.println("Index: " + i);
				System.out.println(element.toString());
				i++;
			}
			System.out.print("Model: ");
			int input = kb.nextInt();

			try {
				AF.removeJet(input);
			}

			catch (InputMismatchException e) {
				e.getMessage();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (i < 0);
	}

	private void flyJet() {
		int i = 0;
		do {
			System.out.println("Please enter the index number of aicraft you would like to fly: \n");
			for (Jet element : AF.getJets()) {
				System.out.println("Index: " + i);
				System.out.println(element.toString());
				i++;
			}
			System.out.print("Index: ");
			int input = kb.nextInt();

			try {
				AF.getJet(input).Fly();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (i < 0);
	}

	private void hirePilot() {
		int i = 0;
		do {
			System.out.println("Please enter the index number of aicraft you would like to hire a pilot for: \n");
			for (Jet element : AF.getJets()) {
				System.out.println("Index: " + i);
				System.out.println(element.toString());
				i++;
			}
			System.out.print("Index: ");
			int input = kb.nextInt();
			kb.nextLine();
			System.out.println("Please enter pilot name: ");
			String name = kb.nextLine();
			System.out.println("Please enter pilot nationality: ");
			String nationality = kb.nextLine();

			try {
				AF.hirePilots(input, name, nationality);
			} catch (Exception e) {
				e.printStackTrace();
			}

		} while (i < 0);
	}

}
