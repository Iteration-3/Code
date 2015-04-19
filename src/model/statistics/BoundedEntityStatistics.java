package model.statistics;

import utilities.structuredmap.StructuredMap;
/**
 * 
 * An entity stat pack that prevents stats from going < 1.
 *
 */
public class BoundedEntityStatistics extends EntityStatistics{
	public BoundedEntityStatistics() {
		super();
		setLivesLeft(3);
		setExperience(0);
		setMovement(0);
		setCurrentHealth(getMaximumHealth());
		setCurrentMana(getMaximumMana());
		setMoney(30);
	}

	public BoundedEntityStatistics(StructuredMap map) {
		super(map);
		setLivesLeft(map.getInteger("livesLeft"));
		setExperience(map.getInteger("experience"));
		setMovement(map.getInteger("movement"));
		setCurrentHealth(map.getInteger("currentHealth"));
		setCurrentMana(map.getInteger("currentMana"));
		setMoney(map.getInteger("money"));
	}

	public BoundedEntityStatistics(int strength, int agility, 
			int intellect, int hardiness, int livesLeft, int experience,
			int movement, int currentHealth, int currentMana, int money) {
		super(strength, agility, intellect, hardiness,livesLeft,experience,movement,currentHealth,
				currentMana,money);
	}

	@Override
	public BoundedEntityStatistics clone() {
		BoundedEntityStatistics cloned = new BoundedEntityStatistics();
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

	@Override
	public void setLivesLeft(int livesLeft) {
		super.setLivesLeft(livesLeft);
		livesCheck();
	}
	@Override
	public void decrementLives(){
		super.decrementLives();
		livesCheck();
	}

	private void livesCheck(){
		if(this.getLivesLeft() <= 0){
			System.out.println("OUT OF LIVES, PERMA DEAD, PROB SHOULD DO SOMETHING");
		}
	}

	@Override
	public void setExperience(int experience) {
		super.setExperience(experience);
	}
	@Override
	public void setMovement(int movement) {
		super.setMovement(movement);
		movementCheck();
	}

	@Override
	public void setCurrentHealth(int currentHealth) {
		super.setCurrentHealth(currentHealth);
		this.healthCheck();
	}

	private void healthCheck(){
		if(this.getCurrentHealth() < 0){
			if(this.getMaximumHealth() < 0){System.err.println("NEGATIVE HP ERROR"); return;}
			this.setCurrentHealth(getMaximumHealth());
			this.decrementLives();
			System.out.println("You haved Died!");

		}
		if(this.getCurrentHealth() > this.getMaximumHealth()){
			this.setCurrentHealth(getMaximumHealth());
		}
	}

	@Override
	public void setMoney(int money) {
		super.setMoney(money);
	}

	@Override
	protected void setCurrentMana(int currentMana) {
		super.setCurrentMana(currentMana);
		this.manaCheck();
	}
	@Override
	public void addCurrentMana(int change) {
		super.addCurrentMana(change);
		this.manaCheck();
	}
	
	private void manaCheck(){
		if(this.getCurrentMana() < 0){
			this.setCurrentMana(0);
		}
		if(this.getCurrentMana() > this.getMaximumMana()){
			this.setCurrentMana(this.getMaximumMana());
		}
	}
	@Override
	public void addExperience(int experience) {
		super.addExperience(experience);
	}
	@Override
	public void addHealth(int health) {
		super.addHealth(health);
	}
	@Override
	public void addMovement(int movement) {
		super.addMovement(movement);
		movementCheck();
	}
	
	private void movementCheck(){
		if(this.getMovement() < 1){
			this.setMovement(1);
		}
	}
	
	@Override
	public void addLives(int lives) {
		super.addLives(lives);
		this.livesCheck();
	}


	@Override
	public void addMoney(int money) {
		super.addMoney(money);
	}
}
