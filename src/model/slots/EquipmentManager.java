package model.slots;

import factories.WeaponFactory;
import factories.WeaponSlotFactory;
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
import model.item.SmasherWeapon;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import model.statistics.Statistics;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.EquipmentView;
import view.SlotView;
import view.item.BasicItemView;

public class EquipmentManager implements Saveable {
	private EquipmentSlot<Helmet> helmetSlot;
	private EquipmentSlot<ChestPiece> chestPieceSlot;
	private EquipmentSlot<Leggings> leggingsSlot;
	private WeaponSlot<?> weaponSlot;
	private EquipmentSlot<Shield> shieldSlot;
	private EquipmentSlot<Boots> bootsSlot;
	private EquipmentSlot<Gloves> glovesSlot;
	private EquipmentSlot<Projectile> projectileSlot;
	private DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield> THWSlot;

	private EquipmentView equipmentView;

	public EquipmentManager(Smasher avatar) {
		SmasherWeaponSlot weaponSlot = new SmasherWeaponSlot();
		this.weaponSlot = weaponSlot;
		this.setSlots();
		this.THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield>(
				weaponSlot, this.shieldSlot);
		this.registerSlots();
	}

	public EquipmentManager(StructuredMap map) {
		this.setSlots();
		
		this.weaponSlot = WeaponSlotFactory.createWeaponSlot(map
				.getStructuredMap("weaponSlotType"));

		if (map.getStructuredMap("helmetSlot") != null) {
			helmetSlot.equip(new Helmet(new BasicItemView(), map
					.getStructuredMap("helmetSlot")));
		}
		if (map.getStructuredMap("chestPieceSlot") != null) {
			chestPieceSlot.equip(new ChestPiece(new BasicItemView(), map
					.getStructuredMap("chestPieceSlot")));
		}
		if (map.getStructuredMap("leggingsSlot") != null) {
			leggingsSlot.equip(new Leggings(new BasicItemView(), map
					.getStructuredMap("leggingsSlot")));
		}
		if (map.getStructuredMap("bootsSlot") != null) {
			bootsSlot.equip(new Boots(new BasicItemView(), map
					.getStructuredMap("bootsSlot")));
		}
		if (map.getStructuredMap("glovesSlot") != null) {
			glovesSlot.equip(new Gloves(new BasicItemView(), map
					.getStructuredMap("glovesSlot")));
		}
		if (map.getStructuredMap("projectileSlot") != null) {
			projectileSlot.equip(new Projectile(new BasicItemView(), map
					.getStructuredMap("projectileSlot")));
		}
		if (map.getStructuredMap("shieldSlot") != null) {
			shieldSlot.equip(new Shield(new BasicItemView(), map
					.getStructuredMap("shieldSlot")));
		}

		if (map.getStructuredMap("weaponSlot") != null) {
			weaponSlot.equip(WeaponFactory.createWeapon(map
					.getStructuredMap("weaponSlot")));
		}
		//If we can't equip two handed weapons it's definitely here
		//TODO
		if(map.getBoolean("hasThwSlot")) {
			this.THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield>(
					new SmasherWeaponSlot(), this.shieldSlot);
			if(map.getStructuredMap("thwSlot") != null) {
				THWSlot.equip(WeaponFactory.createTwoHandedWeapon(map.getStructuredMap("thwSlot")));
			}
		}

	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();

		map.put("helmetSlot", helmetSlot.get() == null ? null : helmetSlot
				.get().getStructuredMap());

		map.put("chestPieceSlot", chestPieceSlot.get() == null ? null
				: chestPieceSlot.get().getStructuredMap());

		map.put("leggingsSlot", leggingsSlot.get() == null ? null
				: leggingsSlot.get().getStructuredMap());

		map.put("shieldSlot", shieldSlot.get() == null ? null : shieldSlot
				.get().getStructuredMap());

		map.put("bootsSlot", bootsSlot.get() == null ? null : bootsSlot.get()
				.getStructuredMap());

		map.put("glovesSlot", glovesSlot.get() == null ? null : glovesSlot
				.get().getStructuredMap());

		map.put("projectileSlot", projectileSlot.get() == null ? null
				: projectileSlot.get().getStructuredMap());

		map.put("weaponSlotType", weaponSlot.getStructuredMap());

		map.put("weaponSlot", weaponSlot.get() == null ? null : weaponSlot
				.get().getStructuredMap());
		boolean result = THWSlot != null;
		map.put("hasThwSlot", result);
		if (result) {
			map.put("thwSlot", THWSlot.get() == null ? null : THWSlot.get()
					.getStructuredMap());
		}

		// TODO Weapon and TWO handed weapon
		return map;
	}

	public EquipmentManager(Summoner avatar) {
		this.weaponSlot = new SummonerWeaponSlot();
		this.setSlots();
		this.registerSlots();
	}

	public EquipmentManager(Sneak avatar) {
		this.weaponSlot = new SneakWeaponSlot();
		this.setSlots();
		this.registerSlots();
	}

	public EquipmentManager(NPC npc) {
		this.weaponSlot = new NPCWeaponSlot();
		this.setSlots();
	}

	private void setSlots() { 
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

	public void merge(Statistics statistics) {
		if (hasTHW()) {
			this.THWSlot.merge(statistics);
		}
		helmetSlot.merge(statistics);
		chestPieceSlot.merge(statistics);
		leggingsSlot.merge(statistics);
		weaponSlot.merge(statistics);
		shieldSlot.merge(statistics);
		bootsSlot.merge(statistics);
		glovesSlot.merge(statistics);
		projectileSlot.merge(statistics);
	}

	public void registerSlots() {
		this.equipmentView = new EquipmentView();
		this.equipmentView.registerBoots(this.setSlotView(this.bootsSlot));
		this.equipmentView.registerChestPiece(this
				.setSlotView(this.chestPieceSlot));
		this.equipmentView
				.registerLeggings(this.setSlotView(this.leggingsSlot));
		this.equipmentView.registerHelmet(this.setSlotView(this.helmetSlot));
		this.equipmentView.registerGloves(this.setSlotView(this.glovesSlot));
		this.equipmentView.registerShield(this.setSlotView(this.shieldSlot));
		this.equipmentView.registerWeapon(this.setSlotView(this.weaponSlot));
		this.equipmentView.registerProjectile(this
				.setSlotView(this.projectileSlot));
	}

	private SlotView setSlotView(EquipmentSlot<?> slot) {
		SlotView slotView = new SlotView();
		slot.setView(slotView);
		return slotView;
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

	public TwoHandedWeapon unequipTHW() {
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

	public boolean equip(TwoHandedWeapon item) {
		if (this.hasTHW()) {
			return this.THWSlot.equip(item);
		} else {
			return false;
		}
	}

	public boolean equip(Shield item) {
		if (this.hasTHW()) {
			return this.THWSlot.equipSecondSlot(item);
		} else {
			return this.shieldSlot.equip(item);
		}
	}

	public boolean equip(Weapon item) {
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

	public EquipmentView getView() {
		return this.equipmentView;
	}

	public boolean THWSlotHasItem() {
		if (hasTHW()) {
			return this.THWSlot.has();
		}
		return false;
	}
	
	public EquipableItem getHelmet(){
		return this.helmetSlot.get();
	}
	public EquipableItem getLeggings(){
		return this.leggingsSlot.get();
	}
	public EquipableItem getGloves(){
		return this.glovesSlot.get();
	}
	public EquipableItem getBoots(){
		return this.bootsSlot.get();
	}
	public EquipableItem getProjectile(){
		return this.helmetSlot.get();
	}
	public EquipableItem getShield(){
		return this.shieldSlot.get();
	}
	public EquipableItem getWeapon(){
		return this.weaponSlot.get();
	}
	public EquipableItem getChestPiece(){
		return this.chestPieceSlot.get();
	}

}
