package model.slots;

import model.item.Boots;
import model.item.ChestPiece;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Projectile;
import model.item.Shield;
import model.item.Weapon;

public class EquipmentManager {
	private EquipmentSlot<Helmet> helmetSlot;
	private EquipmentSlot<ChestPiece> chestPieceSlot;
	private EquipmentSlot<Leggings> leggingsSlot;
	private EquipmentSlot<Weapon> weaponSlot;
	private EquipmentSlot<Shield> shieldSlot;
	private EquipmentSlot<Boots> bootsSlot;
	private EquipmentSlot<Gloves> glovesSlot;
	private EquipmentSlot<Projectile> projectileSlot;
	
	public EquipmentManager(){ //TODO (AvatarTypes)
		this.setSlots(); //TODO (WeaponType)
	}
	
	private void setSlots(){  //TODO (Weapon)
		this.helmetSlot = new EquipmentSlot<Helmet>();
		this.chestPieceSlot = new EquipmentSlot<ChestPiece>();	
		this.leggingsSlot = new EquipmentSlot<Leggings>();
		this.weaponSlot = new EquipmentSlot<Weapon>(); 
		this.shieldSlot = new EquipmentSlot<Shield>();
		this.bootsSlot = new EquipmentSlot<Boots>();
		this.glovesSlot = new EquipmentSlot<Gloves>();
		this.projectileSlot = new EquipmentSlot<Projectile>();
	}
	
	/************************* 	UNEQUIP************************************/
	public Projectile unequipProjectile(){
		return this.projectileSlot.unequip();
	}
	
	public Gloves unequipGloves(){
		return this.glovesSlot.unequip();
	}
	
	public Boots unequipBoots(){
		return this.bootsSlot.unequip();
	}
	
	public Shield unequipShield(){
		return this.shieldSlot.unequip();
	}
	
	public Weapon unequipWeapon(){
		return this.weaponSlot.unequip();
	}
	
	public Leggings unequipLeggings(){
		return this.leggingsSlot.unequip();
	}
	
	public ChestPiece unequipChestPiece(){
		return this.chestPieceSlot.unequip();
	}
	
	public Helmet unequipHelmet(){
		return this.helmetSlot.unequip();
	}

	/*************************EQUIP**************************/
	
	public void equip(Projectile item){
		this.projectileSlot.equip(item);
	}
	
	public void equip(Gloves item){
		this.glovesSlot.equip(item);
	}
	
	public void equip(Boots item){
		this.bootsSlot.equip(item);
	}
	
	public void equip(Shield item){
		this.shieldSlot.equip(item);
	}
	
	public void equip(Weapon item){  //TODO    special case
		this.weaponSlot.equip(item);
	}
	
	public void equip(Leggings item){
		this.leggingsSlot.equip(item);
	}
	
	public void equip(ChestPiece item){
		this.chestPieceSlot.equip(item);
	}
	
	public void equip(Helmet item){
		this.helmetSlot.equip(item);
	}
}
