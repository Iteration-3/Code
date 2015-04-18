package slots;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import model.entity.Smasher;
import model.entity.Sneak;
import model.item.Helmet;
import model.item.Shield;
import model.item.SmasherWeapon;
import model.item.SneakWeapon;
import model.item.SummonerWeapon;
import model.item.TakeableItem;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import model.slots.DoubleEquipmentSlot;
import model.slots.EquipmentSlot;
import model.slots.ItemManager;
import model.slots.SmasherWeaponSlot;
import model.slots.SneakWeaponSlot;
import model.slots.SummonerWeaponSlot;
import model.statistics.Statistics;

import org.junit.Test;

import view.item.BasicItemView;

public class EquipmentSlotTest {
	
	@Test
	public void testHasNot(){
		EquipmentSlot<Helmet> slot = new EquipmentSlot<Helmet>();
		assertFalse(slot.has());
	}
	
	@Test
	public void testHas(){
		EquipmentSlot<Helmet> slot = new EquipmentSlot<Helmet>();
		slot.equip(new Helmet(new BasicItemView(), new Statistics()));
		assertTrue(slot.has());
	}

	@Test
	public void testHasItemAndEquipItem(){
		EquipmentSlot<Helmet> slot = new EquipmentSlot<Helmet>();
		Helmet helmet = new Helmet(new BasicItemView(), new Statistics());
		slot.equip(helmet);
		assertTrue(slot.has(helmet));
	}
	
	@Test
	public void testHasNotItem(){
		EquipmentSlot<Helmet> slot = new EquipmentSlot<Helmet>();
		Helmet helmet = new Helmet(new BasicItemView(), new Statistics());
		assertFalse(slot.has(helmet));
	}
	
	@Test
	public void unequip(){
		EquipmentSlot<Helmet> slot = new EquipmentSlot<Helmet>();
		Helmet helmet = new Helmet(new BasicItemView(), new Statistics());
		slot.equip(helmet);
		Helmet other = slot.unequip();
		assertEquals(other,helmet);
	}
	
	@Test
	public void DoubleSlotsHasNot(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		assertFalse(THW.has());
	}
	
	@Test
	public void DoubleSlotsHas(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		THWSlot.equip(THW);
		assertTrue(THWSlot.has());
	}	
	
	@Test
	public void DoubleEquipFirst(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		THWSlot.equipFirstSlot(sw);
		assertTrue(weapon.has());
	}	
	
	@Test
	public void DoubleEquipSecond(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield sh = new Shield(new BasicItemView(), new Statistics());
		THWSlot.equipSecondSlot(sh);
		assertTrue(shield.has());
	}	
	
	@Test
	public void DoubleCantEquipIfItemInOneOfTheSlots(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield sh = new Shield(new BasicItemView(), new Statistics());
		THWSlot.equipSecondSlot(sh);
//		THWSlot.equipFirstSlot(sw);
		assertFalse(THWSlot.equip(THW));
	}	
	
	@Test
	public void DoubleCantEquipIfItemInSecondOfTheSlots(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield sh = new Shield(new BasicItemView(), new Statistics());
//		THWSlot.equipSecondSlot(sh);
		THWSlot.equipFirstSlot(sw);
		assertFalse(THWSlot.equip(THW));
	}		

	@Test
	public void DoubleCantEquipIfItemInBothOfTheSlots(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield sh = new Shield(new BasicItemView(), new Statistics());
		THWSlot.equipSecondSlot(sh);
		THWSlot.equipFirstSlot(sw);
		assertFalse(THWSlot.equip(THW));
	}
	
	@Test
	public void DoubleCanEquip(){
		SmasherWeaponSlot weapon = new SmasherWeaponSlot();
		EquipmentSlot<Shield> shield = new EquipmentSlot<Shield>();
		DoubleEquipmentSlot<TwoHandedWeapon,SmasherWeapon,Shield> THWSlot = new DoubleEquipmentSlot<TwoHandedWeapon, SmasherWeapon, Shield>(weapon, shield);
		TwoHandedWeapon THW = new TwoHandedWeapon(new BasicItemView(), new Statistics());
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield sh = new Shield(new BasicItemView(), new Statistics());
		assertTrue(THWSlot.equip(THW));
	}
	
	
	@Test
	public void testSummonerWeaponSlot(){
		SummonerWeaponSlot weapon = new SummonerWeaponSlot();
		SummonerWeapon sw = new SummonerWeapon(new BasicItemView(), new Statistics());
		weapon.equip(sw);
		assertTrue(weapon.has());
	}	
	
	@Test
	public void testSneakWeaponSlot(){
		SneakWeaponSlot weapon = new SneakWeaponSlot();
		SneakWeapon sw = new SneakWeapon(new BasicItemView(), new Statistics());
		weapon.equip(sw);
		assertTrue(weapon.has());
	}	
	
	@Test
	public void ItemManagerEquipWeapon(){
		Sneak avatar = new Sneak();
		ItemManager IM = new ItemManager(avatar);
		SneakWeapon sw = new SneakWeapon(new BasicItemView(), new Statistics());
		IM.equip(sw);
		IM.unequipWeapon();
		assertTrue(IM.inventoryHasItem(sw));
	}	
	
	@Test
	public void ItemManagerTHWEquipUnequip(){
		Smasher avatar = new Smasher();
		ItemManager IM = new ItemManager(avatar);
		SmasherWeapon sw = new SmasherWeapon(new BasicItemView(), new Statistics());
		Shield shield = new Shield(new BasicItemView(),new Statistics());
		IM.equip(sw);
		IM.equip(shield);
		TwoHandedWeapon thw = new TwoHandedWeapon(new BasicItemView(),new Statistics());
		IM.equip(thw);
		assertTrue(IM.inventoryHasItem(sw));
		assertTrue(IM.inventoryHasItem(shield));
		IM.unequipTHW();
		assertTrue(IM.inventoryHasItem(thw));
	}
	
}
