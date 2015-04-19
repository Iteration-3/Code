package model.itemmanager;

import java.awt.Color;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import model.entity.Smasher;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.ConsumableItem;
import model.item.Gloves;
import model.item.Leggings;
import model.item.Shield;
import model.slots.Inventory;
import model.slots.ItemManager;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.EntityView;
import view.item.BasicItemView;

public class ItemManagerTest {

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

	}

	@Test
	public void testInventory() {
		Inventory inventory = new Inventory();
		inventory.addItem(new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.6));
		inventory.addItem(new Gloves(new BasicItemView(), new Statistics()));

		StructuredMap map = inventory.getStructuredMap();

		System.out.println(map.getJson());
	}

}
