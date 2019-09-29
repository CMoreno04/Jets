package com.skilldistillery.jets.app;

public abstract class Jet {
	private String model;
	private String pilot;
	private String nationality;
	private int speed;
	private int range;
	private long price;

	public Jet() {

	}

	public Jet(String model, int speed, int range, long price, String pilot, String nationality) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = pilot;
		this.nationality = nationality;
	}

	public String getModel() {
		return model;
	}

	public String getPilot() {
		return pilot;
	}

	public int getSpeed() {
		return speed;
	}

	public int getRange() {
		return range;
	}

	public long getPrice() {
		return price;
	}

	public String getNationality() {
		return nationality;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public void setPilot(String pilot) {
		this.pilot = pilot;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String toSave() {
		return getClass().getSimpleName() + ", " + model + ", " + speed + ", " + range + ", " + price + ", " + pilot
				+ ", " + nationality+"\n";
	}

	public abstract void Fly();

	public double getSpeedInMach() {
		double mach = this.speed / 761.21;
		return mach;
	}

	public String toString() {

		return "Pilot: " + pilot + "\nNationality: " + nationality + "\nModel: " + model + "\nSpeed Mach: "
				+ String.format("%.1f", getSpeedInMach()) + "\nRange: " + range + " Miles" + "\nPrice: " + price + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((model == null) ? 0 : model.hashCode());
		result = prime * result + (int) (price ^ (price >>> 32));
		result = prime * result + range;
		result = prime * result + speed;
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
		Jet other = (Jet) obj;
		if (model == null) {
			if (other.model != null)
				return false;
		} else if (!model.equals(other.model))
			return false;
		if (price != other.price)
			return false;
		if (range != other.range)
			return false;
		if (speed != other.speed)
			return false;
		return true;
	}

}
