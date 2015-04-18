package model.itemmanager;

import model.entity.Smasher;
import model.item.Boots;
import model.item.ChestPiece;
import model.item.ConsumableItem;
import model.item.Gloves;
import model.item.Leggings;
import model.item.Shield;
import model.slots.ItemManager;
import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Test;

import view.item.BasicItemView;

public class ItemManagerTest {

	@Test
	public void testItemManagerSaving() {
		ItemManager manager = new ItemManager(new Smasher());
		manager.equipToSlot(new Boots(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new ChestPiece(new BasicItemView(),	new Statistics()));
		manager.equipToSlot(new Leggings(new BasicItemView(), new Statistics()));
		manager.equipToSlot(new Shield(new BasicItemView(), new Statistics()));
		
		manager.addItem(new ConsumableItem(new BasicItemView(), new EntityStatistics(), 4.6));
		manager.addItem(new Gloves(new BasicItemView(), new Statistics()));

		System.out.println(manager.getStructuredMap().getJson());
		
		
	}

}
