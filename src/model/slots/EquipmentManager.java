package model.slots;

import model.entity.NPC;
import model.entity.Smasher;
import model.entity.Sneak;
import model.entity.Summoner;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Projectile;
import model.item.Shield;
import model.item.TwoHandedWeapon;
import model.item.Weapon;

public class EquipmentManager {
	private EquipmentSlot<Helmet> helmetSlot;
	private EquipmentSlot<ChestPiece> chestPieceSlot;
	private EquipmentSlot<Leggings> leggingsSlot;
	private WeaponSlot<?> weaponSlot;
	private EquipmentSlot<Shield> shieldSlot;
	private EquipmentSlot<Boots> bootsSlot;
	private EquipmentSlot<Gloves> glovesSlot;
	private EquipmentSlot<Projectile> projectileSlot;
	private DoubleEquipmentSlot<TwoHandedWeapon,Weapon,Shield> THWSlot;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EquipmentManager(Smasher avatar) {
		this.weaponSlot = new SmasherWeaponSlot();
		this.setSlots();
		this.THWSlot = new DoubleEquipmentSlot(this.weaponSlot, this.shieldSlot);
	}

	public EquipmentManager(Summoner avatar) {
		this.weaponSlot = new SummonerWeaponSlot();
		this.setSlots();
	}

	public EquipmentManager(Sneak avatar) {
		this.weaponSlot = new SneakWeaponSlot();
		this.setSlots();
	}

	public EquipmentManager(NPC npc) {
		this.weaponSlot = new NPCWeaponSlot();
		this.setSlots();
	}

	private void setSlots() { // TODO (Weapon)
		this.helmetSlot = new EquipmentSlot<Helmet>();
		this.chestPieceSlot = new EquipmentSlot<ChestPiece>();
		this.leggingsSlot = new EquipmentSlot<Leggings>();
		this.shieldSlot = new EquipmentSlot<Shield>();
		this.bootsSlot = new EquipmentSlot<Boots>();
		this.glovesSlot = new EquipmentSlot<Gloves>();
		this.projectileSlot = new EquipmentSlot<Projectile>();
	}

	protected boolean hasTHW() {
		return this.THWSlot != null;
	}

	/************************* UNEQUIP ************************************/
	public Projectile unequipProjectile() {
		return this.projectileSlot.unequip();
	}

	public Gloves unequipGloves() {
		return this.glovesSlot.unequip();
	}

	public Boots unequipBoots() {
		return this.bootsSlot.unequip();
	}

	public Shield unequipShield() {
		return this.shieldSlot.unequip();
	}

	public Weapon unequipWeapon() {
		return this.weaponSlot.unequip();
	}

	public Leggings unequipLeggings() {
		return this.leggingsSlot.unequip();
	}

	public ChestPiece unequipChestPiece() {
		return this.chestPieceSlot.unequip();
	}

	public Helmet unequipHelmet() {
		return this.helmetSlot.unequip();
	}
	
	public TwoHandedWeapon unequipTHW(){
		return this.THWSlot.unequip();
	}

	/************************* EQUIP **************************/

	public boolean equip(Projectile item) {
		return this.projectileSlot.equip(item);
	}

	public boolean equip(Gloves item) {
		return this.glovesSlot.equip(item);
	}

	public boolean equip(Boots item) {
		return this.bootsSlot.equip(item);
	}
	
	public boolean equip(TwoHandedWeapon item){
		if (this.hasTHW()){
			return this.THWSlot.equip(item);
		}
		else{
			return false;
		}
	}

	public boolean equip(Shield item) {
		if (this.hasTHW()) {
			return this.THWSlot.equipSecondSlot(item);
		}
		else{
			return this.shieldSlot.equip(item);
		}
	}

	public boolean equip(Weapon item) {
		if (this.hasTHW()){
			return this.THWSlot.equipFirstSlot(item);
		}
		return this.weaponSlot.equip(item);
	}
	
	public boolean equip(Leggings item) {
		return this.leggingsSlot.equip(item);
	}

	public boolean equip(ChestPiece item) {
		return this.chestPieceSlot.equip(item);
	}

	public boolean equip(Helmet item) {
		return this.helmetSlot.equip(item);
	}

	public boolean canEquip(Weapon weapon) {
		return this.weaponSlot.canEquip(weapon);
	}
}
