package com.skilldistillery.jets.app;

public class CivAirliner extends Jet {

	public CivAirliner() {
		super();
	}

	public CivAirliner(String model, int speed, int range, long price) {
		super(model, speed, range, price);
	}

	@Override
	public void Fly() {
		System.out.println(getClass().getSimpleName() + " Flying!\n");
	}

	

	@Override
	public double getSpeedInMach() {
		return super.getSpeedInMach();
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