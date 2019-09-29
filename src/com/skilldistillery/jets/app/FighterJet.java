package com.skilldistillery.jets.app;

public class FighterJet extends Jet implements CombatMissionReady {

	public FighterJet() {
		super();
	}

	public FighterJet(String model, int speed, int range, long price, String pilot, String nationality) {
		super(model, speed, range, price, pilot, nationality);
	}

	@Override
	public void fight() {
		System.out.print(super.getModel() + " " + "Checking-In As Fragged!");
		System.out.println("Tally, Two Hostiles, 2 by Fox-Two!\n");
	}

	@Override
	public double getSpeedInMach() {
		return super.getSpeedInMach();
	}

	@Override
	public void Fly() {
		int playTime = super.getRange() / super.getSpeed();
		System.out.println(super.getModel() + " " + getClass().getSimpleName() + " Flying!");
		System.out.println("The Jet PlayTime is: " + playTime + " hrs\n");
	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public String toSave() {
		return super.toSave();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

}
