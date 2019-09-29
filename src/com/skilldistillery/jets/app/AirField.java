package com.skilldistillery.jets.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<Jet>();

	public AirField() {
	}

	public List<Jet> getJets() {
		List<Jet> jetCopy = new ArrayList<Jet>();

		parkPlanes();
		jetCopy.addAll(jets);

		return jetCopy;
	}

	private void parkPlanes() {
		try (BufferedReader bufIn = new BufferedReader(new FileReader("Jets.txt"))) {
			String line;
			while ((line = bufIn.readLine()) != null) {
				String[] jetsRecord = line.split(", ");
				String type = jetsRecord[0];
				String model = jetsRecord[1];
				int speed = Integer.parseInt(jetsRecord[2]);
				int range = Integer.parseInt(jetsRecord[3]);
				long price = Long.parseLong(jetsRecord[4]);

				switch (type) {

				case "Fighter":
					Jet j = new FighterJet(model, speed, range, price);
					jets.add(j);
					break;

				case "Cargo":
					Jet c = new CargoPlane(model, speed, range, price);
					jets.add(c);
					break;
				case "CivAir":
					Jet civ = new CivAirliner(model, speed, range, price);
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
