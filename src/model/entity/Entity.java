package model.entity;

import gameactions.GameActionMovementDown;
import gameactions.GameActionMovementDownLeft;
import gameactions.GameActionMovementDownRight;
import gameactions.GameActionMovementUp;
import gameactions.GameActionMovementUpLeft;
import gameactions.GameActionMovementUpRight;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.KeyStroke;

import controller.Listener;
import model.area.RealCoordinate;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.slots.ItemManager;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;
import utilities.Angle;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public abstract class Entity implements SavableLoadable {
    private ItemManager itemManager;
    private String name = null;
    private EntityStatistics stats = new EntityStatistics();
    private EntityView view = null;
    private RealCoordinate location = new RealCoordinate();
    private Angle direction = Angle.UP;

    public Entity(String name, EntityView view, RealCoordinate location) {
        this.name = name;
        this.view = view;
        this.location = location;
        this.setNecessities();
    }

    public Entity() {

    }

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

    public EntityStatistics getBaseStats() {
        return this.stats;
    }

    public EntityStatistics getDerivedStats() {
        EntityStatistics derivedStats = this.stats.clone();
        itemManager.merge(derivedStats);
        return derivedStats;
    };

    /**
     * NOT YET IMPLEMENTED Takes in the angle to move in, always moves one
     * hexagon
     * 
     * @param d
     */
    public void move(Angle angle) {
    	RealCoordinate nextLocation = this.getLocation().nextLocation(angle);
    	this.setLocation(nextLocation);
    	this.setDirection(angle);
    }
    
    public Collection<Listener> getListeners() {
    	Collection<Listener> listeners = new ArrayList<Listener>();
    	// TODO(jraviles) get these from the key preferences
    	listeners.add(new Listener(KeyStroke.getKeyStroke('1'), new GameActionMovementDownLeft(this)));
    	listeners.add(new Listener(KeyStroke.getKeyStroke('2'), new GameActionMovementDown(this)));
    	listeners.add(new Listener(KeyStroke.getKeyStroke('3'), new GameActionMovementDownRight(this)));
    	listeners.add(new Listener(KeyStroke.getKeyStroke('7'), new GameActionMovementUpLeft(this)));
    	listeners.add(new Listener(KeyStroke.getKeyStroke('8'), new GameActionMovementUp(this)));
    	listeners.add(new Listener(KeyStroke.getKeyStroke('9'), new GameActionMovementUpRight(this)));
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

    public RealCoordinate getLocation() {
        return location;
    }

    public void equip(EquipableItem item) {
        this.itemManager.equip(item);
    }

    public boolean addItem(TakeableItem item) {
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

    public void setLocation(RealCoordinate location) {
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
}
