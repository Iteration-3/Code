package model.itemmanager;

import static org.junit.Assert.assertEquals;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.Smasher;
import model.entity.Summoner;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.ConsumableItem;
import model.item.Gloves;
import model.item.Leggings;
import model.item.Shield;
import model.item.SmasherWeapon;
import model.slots.EquipmentManager;
import model.slots.Inventory;
import model.slots.ItemManager;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.EntitySpriteFactory;
import view.EntityView;
import view.item.BasicItemView;
import factories.EntityFactory;

public class ItemManagerTest {

	@Test
	public void testItemManagerSaving() {
		ItemManager manager = new ItemManager(new Smasher("kyle",
				new EntityView(EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5)));

		manager.equipToSlot(new Boots(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new ChestPiece(new BasicItemView(),
				new Statistics()));

		manager.equipToSlot(new Leggings(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new Shield(new BasicItemView(), new Statistics()));

		manager.addItem(new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.6));
		manager.addItem(new Gloves(new BasicItemView(), new Statistics()));

		ItemManager managerTest = new ItemManager(manager.getStructuredMap());
		assertEquals(manager.getStructuredMap().getJson(), managerTest
				.getStructuredMap().getJson());

	}

	@Test
	public void testInventory() {
		Inventory inventory = new Inventory();
		inventory.addItem(new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.6));
		inventory.addItem(new Gloves(new BasicItemView(), new Statistics()));

		StructuredMap map = inventory.getStructuredMap();

		Inventory newInventory = new Inventory(map);
		assertEquals(map.getJson(), newInventory.getStructuredMap().getJson());

	}

	@Test
	public void testEquipmentManager() {

		EquipmentManager manager = new EquipmentManager(new Smasher("kyle",
				new EntityView(EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5)));
		manager.equip(new Boots(new BasicItemView(), new Statistics()));
		manager.equip(new ChestPiece(new BasicItemView(), new Statistics()));
		manager.equip(new SmasherWeapon(new BasicItemView()));
		manager.equip(new Shield(new BasicItemView(), new Statistics()));

		StructuredMap map = manager.getStructuredMap();

		System.out.println(map.getJson());

		EquipmentManager newEquipmentManager = new EquipmentManager(map);
		assertEquals(map.getJson(), newEquipmentManager.getStructuredMap()
				.getJson());

	}

	@Test
	public void testEntitySave() {
		Avatar avatar = new Summoner("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());
		Avatar avatar2 = EntityFactory.createAvatar(avatar.getStructuredMap());
		assertEquals(avatar.getStructuredMap().getJson(), avatar2
				.getStructuredMap().getJson());

	}
}
