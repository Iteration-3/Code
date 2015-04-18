package model.factories;

import static org.junit.Assert.assertEquals;
import model.item.EquipableItem;
import model.item.Helmet;
import model.statistics.Statistics;

import org.junit.Test;

import factories.EquipableItemFactory;
import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;

public class EquipableFactoryTest {

	@Test
	public void testHelemt() {
		Helmet met = new Helmet(new BasicItemView(), new Statistics());
		StructuredMap map = met.getStructuredMap();
		System.out.println(map.getJson());
		System.out.println(map.getStructuredMap("helmet"));
		
		EquipableItem testHelmet = EquipableItemFactory.createItem("helmet", map.getStructuredMap("helmet"));
		assertEquals(met.getStructuredMap().getJson(), testHelmet.getStructuredMap().getJson());
		
	}

}
