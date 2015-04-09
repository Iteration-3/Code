package model.slots;

import utilities.Point;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.item.Weapon;

public class InventoryEquipment {
	private EquipmentManager equipment;
	private Inventory inventory;

	public InventoryEquipment(Summoner avatar) {
		this.equipment = new EquipmentManager(avatar);
		this.inventory = new Inventory();
	}

	public InventoryEquipment(Sneak avatar) {
		this.equipment = new EquipmentManager(avatar);
		this.inventory = new Inventory();
	}

	public InventoryEquipment(Smasher avatar) {
		this.equipment = new EquipmentManager(avatar);
		this.inventory = new Inventory();
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
	private boolean tryToEquip(EquipableItem item){
		return item.equip (this.equipment);
	}
	
	
	public void equip(EquipableItem item) {
		if (this.tryToEquip(item)) {
			return;
		}
		else{
			this.inventory.addItem(item);
		}
	}

	public void unequipProjectile(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipProjectile();
		}
	}
	
	public void unequipGloves(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipProjectile();
		}
	}
	
	public void unequipBoots(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipBoots();
		}
	}
	
	public void unequipShield(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipShield();
		}
	}
	
	public void unequipWeapon(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipWeapon();
		}
	}
	
	public void unequipLeggings(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipLeggings();
		}
	}
	
	public void unequipChestPiece(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipChestPiece();
		}
	}
	
	public void unequipHelmet(){
		if (this.inventory.hasEmptySlot()){
			this.equipment.unequipHelmet();
		}
	}
	
	public boolean canEquipWeapon(Weapon weapon){
		return this.equipment.canEquip(weapon);
	}
}