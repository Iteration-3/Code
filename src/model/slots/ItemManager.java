package model.slots;

import utilities.Point;
import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.item.Weapon;
import model.statistics.Statistics;

public class ItemManager {
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
	
	public ItemManager(NPC npc){
		this.equipment = new EquipmentManager(npc);
		this.inventory = new Inventory();
	}
	
	public void merge(Statistics statistitcs) {
		this.equipment.merge(statistitcs);
	}

	/************ INVENTORY ********************/
	public boolean addItem(TakeableItem item) {
		return this.inventory.addItem(item);
	}

	public TakeableItem removeItem(TakeableItem item) throws Exception {
		return this.inventory.removeItem(item);
	}

	public TakeableItem removeItem(int x, int y) {
		return this.inventory.removeItem(x, y);
	}

	public TakeableItem removeItem(Point point) {
		return this.inventory.removeItem(point);
	}

	public TakeableItem[][] getInventoryItems() {
		return this.inventory.getItems();
	}

	public TakeableItem getInventoryItem(int x, int y) {
		return this.inventory.get(x, y);
	}

	public TakeableItem getInventoryItem(Point point) {
		return this.inventory.get(point);
	}

	public boolean inventoryHas(int x, int y) {
		return this.inventory.slotHas(x, y);
	}

	public boolean inventoryHas(Point point) {
		return this.inventory.slotHas(point);
	}

	public boolean inventoryHasItem(TakeableItem item, int x, int y) {
		return this.inventory.slotHasItem(item, x, y);
	}

	public boolean inventoryHasItem(TakeableItem item, Point point) {
		return this.inventory.slotHasItem(item, point);
	}
	
	public boolean inventoryHasItem(TakeableItem item){
		return this.inventoryHasItem(item);
	}

	/***************************** EQUIPMENT ********************************/
	//this is used to equip a item, it can always fail
	private boolean tryToEquip(EquipableItem item){
		return item.equip (this.equipment);
	}
	
	public void equip(EquipableItem item) {
		//the item must unequip all the slots that it needs to equip itself
		item.unequip(this);
		if (this.tryToEquip(item)) {
			return;
		}
		else{
			this.inventory.addItem(item);
		}
	}

	public void unequipProjectile(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipProjectile());
		}
	}
	
	public void unequipGloves(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipProjectile());
		}
	}
	
	public void unequipBoots(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipBoots());
		}
	}
	
	public void unequipShield(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipShield());
		}
	}
	
	public void unequipWeapon(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipWeapon());
		}
	}
	
	public void unequipLeggings(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipLeggings());
		}
	}
	
	public void unequipChestPiece(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipChestPiece());
		}
	}
	
	public void unequipHelmet(){
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipHelmet());
		}
	}
	
	public void unequipTHW(){
		this.unequipShield();
		this.unequipWeapon();
		if (this.inventory.hasEmptySlot()){
			this.inventory.addItem(this.equipment.unequipTHW());
		}
	}
	
	public boolean canEquipWeapon(Weapon weapon){
		return this.equipment.canEquip(weapon);
	}
}
