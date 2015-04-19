package model.entity;

import java.util.ArrayList;
import java.util.Collection;

import model.KeyPreferences;
import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.state.StateMachine;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.observers.MobileObject;
import model.slots.ItemManager;
import model.statistics.BoundedEntityStatistics;
import model.statistics.Statistics;
import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.EntityView;
import view.EquipmentView;
import view.InventoryView;
import controller.listener.Listener;

public abstract class Entity extends MobileObject implements Saveable {
	
    private ItemManager itemManager;
    private String name = null;
    private BoundedEntityStatistics stats = new BoundedEntityStatistics();
    private EntityView view = null;
	private boolean isFlying = false;
	private StateMachine state;

    protected Entity() {
    	super(new TileCoordinate(0, 0));
    }

    public Entity(String name, EntityView view, TileCoordinate location) {
    	super(location);
        this.name = name;
        this.view = view;
        setLocation(location);
        this.setNecessities();
        setDirection(Angle.UP);
        this.state = new StateMachine(this);
    }

    public Entity(String name, EntityView view, TileCoordinate location,Behaviorable behavior) {
    	super(location);
        this.name = name;
        this.view = view;
        setLocation(location);
        this.setNecessities();
        setDirection(Angle.UP);
        this.state = new StateMachine(this);
        this.state.push(behavior);
    }
    
    
    
    public Entity(StructuredMap map) {
    	super(new TileCoordinate(map.getIntArray("location")[0], map.getIntArray("location")[1]));
        this.name = map.getString("name");
        int[] locationArray = map.getIntArray("location");
        setLocation(new TileCoordinate(locationArray[0], locationArray[1]));
        this.stats = new BoundedEntityStatistics(map.getStructuredMap("stats"));
        setDirection(Angle.values()[map.getInteger("direction")]);
        this.itemManager = new ItemManager(map.getStructuredMap("itemManager"));
        this.isFlying = map.getBoolean("flying");
    }

    private void setNecessities() {
        this.itemManager = this.createItemManager();
        // other things go here
    }
    
    /***********STATES***************/
    public void perform(){
    	this.state.perform();
    }
    
    public void interact(Entity entity){
    	this.state.interact(entity);
    }
    
    public void onDamage(){
    	this.state.onDamage();
    }
    
    public void observe(){
    	this.state.observe();
    }
    
    public void push(Behaviorable state){
    	this.state.push(state);
    }
    
    public Behaviorable pop(){
    	return this.state.pop();
    }

    protected abstract ItemManager createItemManager();

    public abstract void attack();

    public StructuredMap getStructuredMap() {
        int[] locationArray = new int[2];
        locationArray[0] = getLocation().getX();
        locationArray[1] = getLocation().getY();
        StructuredMap map = new StructuredMap();

        map.put("name", name);
        map.put("location", locationArray);
        map.put("stats", stats.getStructuredMap());
        map.put("direction", getDirection().ordinal());
        map.put("itemManager", itemManager.getStructuredMap());
        map.put("type", getType());
        map.put("flying", isFlying);

        return map;
    }
    
    public abstract String getType();

    public abstract void load(StructuredMap map);

    public abstract void update();

    // All entities have an ItemManager, but subclasses need specific ones, so
    // it can't be
    // Contained in the super class, subclasses provide a way to get it via
    // this.

    public BoundedEntityStatistics getBaseStats() {
        return this.stats;
    }

    public BoundedEntityStatistics getDerivedStats() {
        BoundedEntityStatistics derivedStats = this.stats.clone();
        itemManager.merge(derivedStats);
        return derivedStats;
    }

    public void move(Angle angle) {
        TileCoordinate nextLocation = nextLocation(angle);
        this.setLocationNoNotify(nextLocation);
        this.setDirectionNoNotify(angle);
        this.notifySubscribers();
        System.out.println("MOVE TO: "+nextLocation);
    }
    
    public TileCoordinate nextLocation() {
    	return nextLocation(this.getDirection());
    }
    
    public TileCoordinate nextLocation(Angle angle) {
        return this.getLocation().nextLocation(angle);
    }

    public Collection<Listener> getListeners(KeyPreferences preferences) {
        Collection<Listener> listeners = new ArrayList<Listener>();
        return listeners;
    }
    
    public boolean hasTHW() {
    	return false;
    }
    
    public boolean hasOHW() {
    	return false;
    }

    /**
     * Defaults to false, should be overridden for flying shit
     * 
     * @return
     */
    public boolean isFlying() {
        return isFlying;
    }
    
    public void setFlight(Boolean flight){
    	isFlying = flight;
    	System.out.println("Flight status " + isFlying);
    }

    protected EntityView getEntityView() {
        return view;
    }
    
    public void toggleView() {
    	getEntityView().toggle();
    	getEntityView().setLocation(getLocation());
    }

    public String getName() {
        return name;
    }

    public void equip(EquipableItem item) {
        this.itemManager.equip(item);
    }

    public boolean addItem(TakeableItem item) {
        System.out.println("Added Item!");
        return this.itemManager.addItem(item);
    }

    public TakeableItem removeItem(int index) {
        return this.itemManager.removeItem(index);
    }

    public TakeableItem[] getItems() {
        return this.itemManager.getInventoryItems();
    }
    
    public TakeableItem getItem(int slotNumber) {
    	return this.itemManager.getInventoryItem(slotNumber);
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
    	super.setLocation(location);
    	if (this.getEntityView() != null)
    		this.getEntityView().setLocation(location);//TODO: FIX
    }
    
    public void setDirection(Angle angle){
    	super.setDirection(angle);
    	if(this.getEntityView()!=null){
    		this.getEntityView().setDirection(angle);
    	}
    }
    
    protected void setLocationNoNotify(TileCoordinate location) {
    	super.setLocationNoNotify(location);
    	if (this.getEntityView() != null)
    		this.getEntityView().setLocation(location);//TODO: FIX
    }
    
    protected void setDirectionNoNotify(Angle angle){
    	super.setDirectionNoNotify(angle);
    	if(this.getEntityView()!=null){
    		this.getEntityView().setDirection(angle);
    	}
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

    public void addCurrentMana(int mana) {
        stats.addCurrentMana(mana);
    }

    public boolean containsItem(TakeableItem item) {
        return itemManager.inventoryHasItem(item);
    }

    // DELETE ME AFTER FIXING FOR TESTING PURPOSES

    public InventoryView getInventoryView() {
        return this.itemManager.getInventoryView();
    }

    public EquipmentView getEquipmentView() {
        return itemManager.getEquipmentView();
    }
    
    public ItemManager getItemManager(){
    	return this.itemManager;
    }

}
