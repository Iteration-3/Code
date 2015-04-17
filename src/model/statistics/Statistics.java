package model.statistics;

public class Statistics implements Cloneable {
	private int strength;
	private int agility;
	private int intellect;
	private int hardiness;
	
	public Statistics() {
		strength = 10;
		agility = 10;
		intellect = 10;
		hardiness = 10;
	}
	
	public Statistics(int strength, int agility, int intellect, int hardiness) {
		this.strength = strength;
		this.agility = agility;
		this.intellect = intellect;
		this.hardiness = hardiness;
	}
	
	/**
	 * @param statistics Statistics object to merge into
	 */
	public void merge(Statistics statistics) {
		statistics.strength += this.strength;
		statistics.agility += this.agility;
		statistics.intellect += this.intellect;
		statistics.hardiness += this.hardiness;
	}
	
	public void mergeInto(Statistics statistics) {
		this.strength += statistics.strength;
		this.agility += statistics.agility;
		this.intellect += statistics.intellect;
		this.hardiness += statistics.hardiness;
	}
	
	public Statistics clone() {
		Statistics cloned = new Statistics();
		cloned.strength = this.strength;
		cloned.agility = this.agility;
		cloned.intellect = this.intellect;
		cloned.hardiness = this.hardiness;
		return cloned;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getAgility() {
		return agility;
	}

	public void setAgility(int agility) {
		this.agility = agility;
	}

	public int getIntellect() {
		return intellect;
	}

	public void setIntellect(int intellect) {
		this.intellect = intellect;
	}

	public int getHardiness() {
		return hardiness;
	}

	public void setHardiness(int hardiness) {
		this.hardiness = hardiness;
	}
	
	@Override
	public String toString() {
		String contents = "Strength: " + strength + "\n"
				+ "Agility: " + agility + "\n"
				+ "Intellect: " + intellect + "\n"
				+ "Hardiness: " + hardiness + "\n";
		return contents;
	}
}
