package statistics;

public class EntityStatistics extends Statistics{
	private int livesLeft;
	private int experience;
	private int movement;
	private int currentHealth;
	private int currentMana;

	public EntityStatistics() {
		super();
		this.livesLeft = 3;
		this.experience = 0;
		this.movement = 5;
		this.currentHealth = getMaximumHealth();
		this.currentMana = getMaximumMana();
	}

	public EntityStatistics(int strength, int agility, int intellect,
			int hardiness, int livesLeft, int experience, int movement,
			int currentHealth, int currentMana) {
		super(strength, agility, intellect, hardiness);
		this.livesLeft = livesLeft;
		this.experience = experience;
		this.movement = movement;
		this.currentHealth = currentHealth;
		this.currentMana = currentMana;
	}
	
	public int getOffensiveRating() {
		return (getStrength() + getAgility())/2;
	}
	
	public int getDefensiveRating() {
		return (getHardiness() + getAgility())/2;
	}
	
	public int getArmorRating() {
		return (getHardiness() + getCurrentHealth())/2;
	}
	
	public EntityStatistics clone() {
		EntityStatistics cloned = new EntityStatistics();
		cloned.setStrength(this.getStrength());
		cloned.setAgility(this.getAgility());
		cloned.setIntellect(this.getIntellect());
		cloned.setHardiness(this.getHardiness());
		cloned.setLivesLeft(this.getLivesLeft());
		cloned.setExperience(this.getExperience());
		cloned.setMovement(this.getMovement());
		cloned.setCurrentHealth(this.getCurrentHealth());
		cloned.setCurrentMana(this.getCurrentMana());
		return cloned;
	}
	
	public int getLevel() {
		return (experience % 100) + 1;
	}

	public int getLivesLeft() {
		return livesLeft;
	}

	public void setLivesLeft(int livesLeft) {
		this.livesLeft = livesLeft;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public int getMovement() {
		return movement;
	}

	public void setMovement(int movement) {
		this.movement = movement;
	}

	public int getCurrentHealth() {
		return currentHealth;
	}

	public void setCurrentHealth(int currentHealth) {
		this.currentHealth = currentHealth;
	}
	
	public int getMaximumHealth() {
		return getStrength() * 100;
	}

	public int getCurrentMana() {
		return currentMana;
	}

	public void setCurrentMana(int currentMana) {
		this.currentMana = currentMana;
	}
	
	public int getMaximumMana() {
		return getIntellect() * 100;
	}
}
