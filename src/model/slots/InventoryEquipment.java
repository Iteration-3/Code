package model.slots;

import utilities.Point;
import model.item.Equipable;
import model.item.TakeableItem;

public class InventoryEquipment {
	private EquipmentManager equipment;
	private Inventory inventory;

	public InventoryEquipment() { // TODO
		this.equipment = new EquipmentManager();
		this.inventory = new Inventory();
	}

	/************ INVENTORY ********************/
	public boolean insert(TakeableItem item) {
		return this.inventory.insert(item);
	}

	public TakeableItem remove(TakeableItem item) throws Exception {
		return this.inventory.remove(item);
	}

	public TakeableItem remove(int x, int y) {
		return this.inventory.remove(x, y);
	}

	public TakeableItem remove(Point point) {
		return this.inventory.remove(point);
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

	/***************************** EQUIPMENT ********************************/
	public void equip(Equipable item) {
		if (item.equip (this.equipment)) {
			return;
		}
		else{
			this.inventory.insert(item);
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
}
