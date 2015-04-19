package model.factories;

import static org.junit.Assert.assertEquals;
import model.item.ConsumableItem;
import model.item.TakeableItem;
import model.statistics.EntityStatistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;
import factories.TakeableItemFactory;

public class TakeableFactoryTest {

	@Test
	public void test() {
		ConsumableItem cons = new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.5);

		StructuredMap map = cons.getStructuredMap();

		TakeableItem item = TakeableItemFactory.createItem(map);

		assertEquals(map.getJson(), item.getStructuredMap().getJson());
	}
	
	

}
