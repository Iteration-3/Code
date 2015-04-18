package model.statistics;

import utilities.structuredmap.StructuredMap;

public class EntityStatistics extends Statistics {
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

    public EntityStatistics(StructuredMap map) {
        super(map);
        setLivesLeft(map.getInteger("livesLeft"));
        setExperience(map.getInteger("experience"));
        setMovement(map.getInteger("movement"));
        setCurrentHealth(map.getInteger("currentHealth"));
        setCurrentMana(map.getInteger("currentMana"));
    }

    public EntityStatistics(int strength, int agility, int intellect, int hardiness, int livesLeft, int experience,
            int movement, int currentHealth, int currentMana) {
        super(strength, agility, intellect, hardiness);
        this.livesLeft = livesLeft;
        this.experience = experience;
        this.movement = movement;
        this.currentHealth = currentHealth;
        this.currentMana = currentMana;
    }

    public int getOffensiveRating() {
        return (getStrength() + getAgility()) / 2;
    }

    public int getDefensiveRating() {
        return (getHardiness() + getAgility()) / 2;
    }

    public int getArmorRating() {
        return (getHardiness() + getCurrentHealth()) / 2;
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
        return (experience / 100) + 1;
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

    public void addCurrentMana(int change) {
        this.currentMana += change;
    }

    public int getMaximumMana() {
        return getIntellect() * 100;
    }

    public void addExperience(int experience) {
        this.experience += experience;
    }

    public void addHealth(int health) {
        this.currentHealth += health;
    }

    public void addMovement(int movement) {
        this.movement += movement;
    }

    public void addLives(int lives) {
        this.livesLeft += lives;
    }

    public void addMana(int mana) {
        this.currentMana += mana;
    }

    @Override
    public String toString() {
        String contents = super.toString() + "Lives Left: " + livesLeft + "\n" + "Experience: " + experience + "\n"
                + "Movement: " + movement + "\n" + "Current Health: " + currentHealth + "\n" + "Current Mana: "
                + currentMana + "\n";
        return contents;
    }

    @Override
    public StructuredMap getStructuredMap() {
        StructuredMap map = super.getStructuredMap();
        map.put("livesLeft", getLivesLeft());
        map.put("experience", getExperience());
        map.put("movement", getMovement());
        map.put("currentHealth", getCurrentHealth());
        map.put("currentMana", getCurrentMana());

        return map;
    }
}
