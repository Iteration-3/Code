package model.entity;

import model.area.Location;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;
import model.slots.ItemManager;
import utilities.Angle;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public abstract class Entity implements SavableLoadable {
	public Entity(String name, EntityView view) {
		this.name = name;
		this.view = view;
		this.setNecessities();
	}

	public Entity() {

	}

	private ItemManager itemManager;
	private String name = null;
	private EntityStatistics stats = new EntityStatistics();
	private EntityView view = null;
	private Location location = new Location();

	/**
	 * Constructor Helpers
	 */

	private void setNecessities() {
		this.itemManager = this.createItemManager();
		// other things go here
	}

	protected abstract ItemManager createItemManager();

	/**
	 * Abstract methods
	 */
	public abstract void attack();

	public abstract StructuredMap getStructuredMap();

	public abstract void load(StructuredMap map);

	public abstract void update();

	// All entities have an ItemManager, but subclasses need specific ones, so
	// it can't be
	// Contained in the super class, subclasses provide a way to get it via
	// this.

	/**
	 * Concrete methods begin here
	 * 
	 */

	/**
	 * @param takeable
	 */
	protected EntityStatistics getDerivedStats() {
		return stats;
	};

	/**
	 * NOT YET IMPLEMENTED Takes in the angle to move in, always moves one
	 * square
	 * 
	 * @param d
	 */
	public void move(Angle d) {

	}

	/**
	 * Defaults to false, should be overridden for flying shit
	 * 
	 * @return
	 */
	public boolean isFlying() {
		return false;
	}

	protected EntityView getEntityView() {
		return view;
	}

	public String getName() {
		return name;
	}

	public Location getLocation() {
		return location;
	}

	public void equip(EquipableItem item) {
		this.itemManager.equip(item);
	}

	public boolean addItem(TakeableItem item) {
		return this.itemManager.addItem(item);
	}

	public void removeItem(int x, int y) {
		this.itemManager.removeItem(x, y);
	}

	public TakeableItem[][] getItems() {
		return this.itemManager.getInventoryItems();
	}

	public boolean hasItem(TakeableItem item) {
		return this.itemManager.inventoryHasItem(item);
	}

	public void unequipHelmet() {
		this.itemManager.unequipHelmet();
	}
	
	public void unequipProjectile(){
		this.itemManager.unequipProjectile();
	}
	
	public void unequipChestPiece(){
		this.itemManager.unequipChestPiece();
	}
	
	public void unequipWeapon(){
		this.itemManager.unequipWeapon();
	}
	
	public void unequipShield(){
		this.itemManager.unequipShield();
	}
	
	public void unequipLeggings(){
		this.itemManager.unequipLeggings();
	}
	
	public void unequipBoots(){
		this.itemManager.unequipBoots();
	}
	
	public void unequipGloves(){
		this.itemManager.unequipGloves();
	}
	
	public void setLocation(Location location) {
		this.location = location;
	}
	
	public void modifyStats(Statistics otherStats) {
		stats.mergeInto(otherStats);
	}

	public void addExperience(int experience) {
		stats.addExperience(experience);
	}
	
	public void addHealth(int health) {
		stats.addHealth(health);
	}

	public void addMovement(int movement) {
		stats.addMovement(movement);
	}

	public void addLives(int lives) {
		stats.addLives(lives);
	}

	public void addMana(int mana) {
		stats.addMana(mana);
	}

}
