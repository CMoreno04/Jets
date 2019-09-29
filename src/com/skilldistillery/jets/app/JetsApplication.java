package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JetsApplication {
	private AirField AF = new AirField();
	private Scanner kb = new Scanner(System.in);
	private List<Jet> jet = new ArrayList<Jet>(AF.getJets());

	public static void main(String[] args) {
		JetsApplication app = new JetsApplication();
		app.launch();
	}

	private void launch() {
		int i = 0, j = 1;

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
		System.out.println("10.Quit");
		String input = kb.next();
		return input;
	}

	private void listFleet() {
		System.out.println();
		for (Jet element : jet) {
			System.out.println(element.toString());
		}
	}

	private void flyAllJets() {
		System.out.println();
		for (Jet element : jet) {
			element.Fly();
		}
	}

	private void getFastestJet() {
		int fast = 0;
		String jetIndx = " ";
		for (Jet jet : jet) {
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
		for (Jet jet : jet) {
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
		for (Jet jet2 : jet) {
			if (jet2 instanceof CargoPlane) {
				CargoPlane e = (CargoPlane) jet2;
				e.loadCargo();
			}
		}
	}

	private void dogfight() {
		for (Jet jet2 : jet) {
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

		switch (input) {

		case "f":
			Jet f = new FighterJet(model, speed, range, price);
			jet.add(f);
			break;
		case "c":
			Jet c = new CargoPlane(model, speed, range, price);
			jet.add(c);
			break;
		case "civ":
			Jet civ = new CargoPlane(model, speed, range, price);
			jet.add(civ);
			break;
		}
	}

	private void removeJet() {
		int i = 0;
		do {
			System.out.println("Please enter the index number you would like to remove: \n");
			for (Jet element : jet) {
				System.out.println("Index: " + i);
				System.out.println(element.toString());
				i++;
			}
			System.out.print("Index: ");
			int input = kb.nextInt();

			jet.remove(input);

		} while (i < 0);
	}

	private void flyJet() {
		int i = 0;
		do {
			System.out.println("Please enter the index number of aicraft you would like to fly: \n");
			for (Jet element : jet) {
				System.out.println("Index: " + i);
				System.out.println(element.toString());
				i++;
			}
			System.out.print("Index: ");
			int input = kb.nextInt();

			jet.get(input).Fly();

		} while (i < 0);
	}

}
