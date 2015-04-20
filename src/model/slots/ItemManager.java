package model.slots;

import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.EquipableItem;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Projectile;
import model.item.Shield;
import model.item.TakeableItem;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import model.statistics.Statistics;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.EquipmentView;
import view.InventoryView;

public class ItemManager implements Saveable {

    private EquipmentManager equipment;
    private Inventory inventory;

    public ItemManager(Summoner avatar) {
        this.equipment = new EquipmentManager(avatar);
        this.inventory = new Inventory();
    }

    public ItemManager(Sneak avatar) {
        this.equipment = new EquipmentManager(avatar);
        this.inventory = new Inventory();
    }

    public ItemManager(Smasher avatar) {
        this.equipment = new EquipmentManager(avatar);
        this.inventory = new Inventory();
    }

    public ItemManager(NPC npc) {
        this.equipment = new EquipmentManager(npc);
        this.inventory = new Inventory();
    }

    public ItemManager(StructuredMap map) {
		this.equipment = new EquipmentManager(map.getStructuredMap("equipment"));
		this.inventory = new Inventory(map.getStructuredMap("inventory"));
	}

	public void merge(Statistics statistitcs) {
        this.equipment.merge(statistitcs);
    }

    public boolean addItem(TakeableItem item) {
        return this.inventory.addItem(item);
    }

    public TakeableItem removeItem(TakeableItem item) throws Exception {
        return this.inventory.removeItem(item);
    }

    public TakeableItem removeItem(int index) {
        return this.inventory.removeItem(index);
    }

    public TakeableItem[] getInventoryItems() {
        return this.inventory.getItems();
    }

    public TakeableItem getInventoryItem(int index) {
        return this.inventory.get(index);
    }

    public boolean inventoryHas(int index) {
        return this.inventory.slotHas(index);
    }

    public boolean inventoryHasItem(TakeableItem item, int index) {
        return this.inventory.slotHasItem(item, index);
    }

    public boolean inventoryHasItem(TakeableItem item) {
        return this.inventory.hasItem(item);
    }

    public boolean equip(EquipableItem item) {
    	System.out.println(item);
        // the item must unequip all the slots that it needs to equip itself
        return item.equip(this);
    }
    
    public boolean equipToSlot(Boots item){
    	this.unequipBoots();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Weapon item){
    	this.unequipWeapon();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Leggings item){
    	this.unequipLeggings();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(ChestPiece item){
    	this.unequipChestPiece();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Gloves item){
    	this.unequipGloves();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Projectile item){
    	this.unequipProjectile();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Helmet item){
    	this.unequipHelmet();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(Shield item){
    	this.unequipShield();
    	return this.equipment.equip(item);
    }
    public boolean equipToSlot(TwoHandedWeapon item){
    	this.unequipTHW();
    	return this.equipment.equip(item);
    }

    public void unequipProjectile() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipProjectile());
        }
    }

    public void unequipGloves() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipProjectile());
        }
    }

    public void unequipBoots() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipBoots());
        }
    }

    public void unequipShield() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipShield());
        }
    }

    public void unequipWeapon() {
        if (this.inventory.hasEmptySlot()) {
        	if (this.equipment.hasTHW()){
        		if (this.equipment.THWSlotHasItem()){
        			this.inventory.addItem(this.equipment.unequipTHW());
        		}
        	}
        	else{
        		this.inventory.addItem(this.equipment.unequipWeapon());
        	}
        }
    }

    public void unequipLeggings() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipLeggings());
        }
    }

    public void unequipChestPiece() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipChestPiece());
        }
    }

    public void unequipHelmet() {
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipHelmet());
        }
    }

    public void unequipTHW() {
        this.unequipShield();
        this.unequipWeapon();
        if (this.inventory.hasEmptySlot()) {
            this.inventory.addItem(this.equipment.unequipTHW());
        }
    }

    public boolean canEquipWeapon(Weapon weapon) {
        return this.equipment.canEquip(weapon);
    }

    public InventoryView getInventoryView() {
        return this.inventory.getView();
    }

    public EquipmentView getEquipmentView() {
        return this.equipment.getView();
    }
    
    public EquipmentManager getEquipment(){
    	return this.equipment;
    }

    @Override
    public StructuredMap getStructuredMap() {
        StructuredMap map = new StructuredMap();
        map.put("equipment", equipment.getStructuredMap());
        map.put("inventory", inventory.getStructuredMap());
        return map;
    }

}
