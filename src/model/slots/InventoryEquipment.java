package model.slots;

import utilities.Point;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.Equipable;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Projectile;
import model.item.Shield;
import model.item.TakeableItem;
import model.item.Weapon;

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
	
	public Projectile unequipProjectile(){
		return this.equipment.unequipProjectile();
	}
	
	public Gloves unequipGloves(){
		return this.equipment.unequipGloves();
	}
	
	public Boots unequipBoots(){
		return this.equipment.unequipBoots();
	}
	
	public Shield unequipShield(){
		return this.equipment.unequipShield();
	}
	
	public Weapon unequipWeapon(){
		return this.equipment.unequipWeapon();
	}
	
	public Leggings unequipLeggings(){
		return this.equipment.unequipLeggings();
	}
	
	public ChestPiece unequipChestPiece(){
		return this.equipment.unequipChestPiece();
	}
	
	public Helmet unequipHelmet(){
		return this.equipment.unequipHelmet();
	}
}
