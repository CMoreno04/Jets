package com.skilldistillery.jets.app;

public abstract class Jet {
	private String model;
	private int speed;
	private int range;
	private long price;

	public Jet() {

	}

	public Jet(String model, int speed, int range, long price) {
		super();
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
	}

	public String getModel() {
		return model;
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

	public void setModel(String model) {
		this.model = model;
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

	public abstract void Fly();

	public double getSpeedInMach() {
		double mach = this.speed / 761.21;
		return mach;
	}

	@Override
	public String toString() {
		return "Model: " + model + "\nSpeed: " + speed + "\nRange: " + range + "\nPrice: " + price + "\n";
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
