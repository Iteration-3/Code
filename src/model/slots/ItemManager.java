package model.slots;

import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.EquipableItem;
import model.item.TakeableItem;
import model.item.Weapon;

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

	/************ INVENTORY ********************/
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
		return this.inventory.slotHasItem(item,index);
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
