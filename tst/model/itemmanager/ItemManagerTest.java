package model.itemmanager;

import static org.junit.Assert.assertEquals;

import java.awt.Color;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Smasher;
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
import view.EntitySpriteHolder;
import view.EntityView;
import view.Sprite;
import view.item.BasicItemView;

public class ItemManagerTest {
/*
	@Test
	public void testItemManagerSaving() {
		ItemManager manager = new ItemManager(
				new Smasher("kyle", new EntityView(Color.RED, Color.BLACK,
						new RealCoordinate(5, 5)), new TileCoordinate(5, 5)));

		manager.equipToSlot(new Boots(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new ChestPiece(new BasicItemView(),
				new Statistics()));

		manager.equipToSlot(new Leggings(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new Shield(new BasicItemView(), new Statistics()));

		manager.addItem(new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.6));
		manager.addItem(new Gloves(new BasicItemView(), new Statistics()));

		System.out.println(manager.getStructuredMap().getJson());
		
		ItemManager managerTest = new ItemManager(manager.getStructuredMap());
		assertEquals(manager.getStructuredMap().getJson(), managerTest.getStructuredMap().getJson());

	}
*/
	@Test
	public void testInventory() {
		Inventory inventory = new Inventory();
		inventory.addItem(new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.6));
		inventory.addItem(new Gloves(new BasicItemView(), new Statistics()));

		StructuredMap map = inventory.getStructuredMap();

		System.out.println(map.getJson());

		Inventory newInventory = new Inventory(map);
		assertEquals(map.getJson(), newInventory.getStructuredMap().getJson());

	}

	@Test
	public void testEquipmentManager() {
		EquipmentManager manager = new EquipmentManager(
				new Smasher("kyle", new EntityView(new SummonerSpriteHolder()), new TileCoordinate(5, 5));
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

}
