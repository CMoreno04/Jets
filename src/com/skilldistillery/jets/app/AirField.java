package com.skilldistillery.jets.app;

import java.util.ArrayList;
import java.util.List;

public class AirField {
	private List<Jet> jets = new ArrayList<Jet>();

	public void addJets(Jet t) {
		jets.add(t);
	}

	public List<Jet> getJets() {
		List<Jet> jetCopy;

		jetCopy = new ArrayList<Jet>();
		jetCopy.addAll(jets);

		return jetCopy;
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
