package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.area.TileCoordinate;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.slots.ItemManager;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;
import utilities.Angle;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import view.EntityView;
import view.InventoryView;
import controller.listener.Listener;

public abstract class Entity implements SavableLoadable {
    private ItemManager itemManager;
    private String name = null;
    private EntityStatistics stats = new EntityStatistics();
    private EntityView view = null;
    private TileCoordinate location = new TileCoordinate();
    private Angle direction = Angle.UP;

    public Entity(String name, EntityView view, TileCoordinate location) {
        this.name = name;
        this.view = view;
        this.location = location;
        this.setNecessities();
    }

    public Entity() {
    	
    }

    private void setNecessities() {
        this.itemManager = this.createItemManager();
        // other things go here
    }

    protected abstract ItemManager createItemManager();

    public abstract void attack();

    public abstract StructuredMap getStructuredMap();

    public abstract void load(StructuredMap map);

    public abstract void update();

    // All entities have an ItemManager, but subclasses need specific ones, so
    // it can't be
    // Contained in the super class, subclasses provide a way to get it via
    // this.

    public EntityStatistics getBaseStats() {
        return this.stats;
    }

    public EntityStatistics getDerivedStats() {
        EntityStatistics derivedStats = this.stats.clone();
        itemManager.merge(derivedStats);
        return derivedStats;
    }

    public void move(Angle angle) {
        TileCoordinate nextLocation = nextLocation(angle);
        this.setLocation(nextLocation);
        this.setDirection(angle);
        System.out.println(nextLocation.toString());
    }
    
    public TileCoordinate nextLocation(Angle angle) {
    	return this.getLocation().nextLocation(angle);
    }

    public Collection<Listener> getListeners() {
    	Collection<Listener> listeners = new ArrayList<Listener>();
    	return listeners;
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

    public TileCoordinate getLocation() {
        return location;
    }

    public void equip(EquipableItem item) {
        this.itemManager.equip(item);
    }

    public boolean addItem(TakeableItem item) {
    	System.out.println("Added Item!");
        return this.itemManager.addItem(item);
    }

    public void removeItem(int index) {
        this.itemManager.removeItem(index);
    }

    public TakeableItem[] getItems() {
        return this.itemManager.getInventoryItems();
    }

    public boolean hasItem(TakeableItem item) {
        return this.itemManager.inventoryHasItem(item);
    }

    public void unequipHelmet() {
        this.itemManager.unequipHelmet();
    }

    public void unequipProjectile() {
        this.itemManager.unequipProjectile();
    }

    public void unequipChestPiece() {
        this.itemManager.unequipChestPiece();
    }

    public void unequipWeapon() {
        this.itemManager.unequipWeapon();
    }

    public void unequipShield() {
        this.itemManager.unequipShield();
    }

    public void unequipLeggings() {
        this.itemManager.unequipLeggings();
    }

    public void unequipBoots() {
        this.itemManager.unequipBoots();
    }

    public void unequipGloves() {
        this.itemManager.unequipGloves();
    }

    public void setLocation(TileCoordinate location) {
        this.location = location;
        this.getEntityView().setLocation(location);
    }

    public Angle getDirection() {
        return this.direction;
    }

    public void setDirection(Angle angle) {
        this.direction = angle;
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
    
    
    //DELETE ME AFTER FIXING    FOR TESTING PURPOSES
    
    public InventoryView getInventoryView(){
    	return this.itemManager.getInventoryView();
    }

	public boolean containsItem(TakeableItem item) {
		return itemManager.inventoryHasItem(item);
	}
    
    
}
