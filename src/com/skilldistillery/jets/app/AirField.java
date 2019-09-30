package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirField {
	private List<Jet> jets = new ArrayList<Jet>();

	public AirField() {

	}

	public Jet getJet(int index) {
		return jets.get(index);
	}

	public void addJet(String input, String model, int speed, int range, long price, String pilot, String nation) {
		switch (input) {

		case "f":
			Jet f = new FighterJet(model, speed, range, price, pilot, nation);
			jets.add(f);
			break;
		case "c":
			Jet c = new CargoPlane(model, speed, range, price, pilot, nation);
			jets.add(c);
			break;
		case "civ":
			Jet civ = new Airliner(model, speed, range, price, pilot, nation);
			jets.add(civ);
			break;
		}
	}

	public void removeJet(int index) {
		jets.remove(index);
	}

	public void hirePilots(int input, String name, String nationality) {
		jets.get(input).setPilot(name);
		jets.get(input).setNationality(nationality);
	}

	public List<Jet> getJets() {
		List<Jet> jetCopy = new ArrayList<Jet>(jets);

		return jetCopy;
	}

	public void parkPlanes() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetsRecord = line.split(", ");
				String type = jetsRecord[0];
				String model = jetsRecord[1];
				int speed = Integer.parseInt(jetsRecord[2]);
				int range = Integer.parseInt(jetsRecord[3]);
				long price = Long.parseLong(jetsRecord[4]);
				String pilot = jetsRecord[5];
				String nation = jetsRecord[6];

				switch (type) {

				case "FighterJet":
					Jet j = new FighterJet(model, speed, range, price, pilot, nation);
					jets.add(j);
					break;
				case "CargoPlane":
					Jet c = new CargoPlane(model, speed, range, price, pilot, nation);
					jets.add(c);
					break;
				case "Airliner":
					Jet civ = new Airliner(model, speed, range, price, pilot, nation);
					jets.add(civ);
					break;
				}
			}
		}

		catch (FileNotFoundException e) {
			System.err.println(e);
		}

		catch (IOException e) {
			System.err.println(e);
		}
	}

	private String returnPilot() {
		List<String> names = new ArrayList<String>();

		names.add("James");
		names.add("Jockey");
		names.add("Jaws");
		names.add("Fish");
		names.add("TopDog");
		names.add("Vanquisher");
		names.add("Terminator");
		names.add("BigHelper");
		names.add("WarTiger");
		names.add("Aniquilator");

		String pilot = names.get((int) (Math.random() * 11));

		return pilot;
	}

	private String returnNation() {
		List<String> nations = new ArrayList<String>();

		nations.add("American");
		nations.add("Argentinian");
		nations.add("Chinese");
		nations.add("German");
		nations.add("Japanese");
		nations.add("Dutch");
		nations.add("Mexican");
		nations.add("PuertoRican");
		nations.add("Dominican");

		String pilot = nations.get((int) (Math.random() * 11));

		return pilot;
	}

	public String getPilot() {
		return returnPilot();

	}

	public String getNation() {
		return returnNation();
	}

	public void saveFile(Scanner kb) {
		System.out.println("Please enter file name: ");
		String fileName = kb.next();

		BufferedWriter output = null;
		File file=new File(fileName + ".txt");
		if (!file.exists()) {

			try {
				output = new BufferedWriter(new FileWriter(file));
				for (Jet jet2 : jets) {
					output.write(jet2.toSave());
				}

				output.close();
			}

			catch (FileAlreadyExistsException e) {
				e.getMessage();

			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (output != null) {
					try {
						output.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		} else {
			System.err.println("Already Exists Try Again!");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((jets == null) ? 0 : jets.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AirField other = (AirField) obj;
		if (jets == null) {
			if (other.jets != null)
				return false;
		} else if (!jets.equals(other.jets))
			return false;
		return true;
	}

}
