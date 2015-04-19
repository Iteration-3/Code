package model.factories;

import static org.junit.Assert.assertEquals;
import model.item.ChestPiece;
import model.item.EquipableItem;
import model.item.Helmet;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;
import factories.EquipableItemFactory;

public class EquipableFactoryTest {

	@Test
	public void testHelmet() {
		Helmet met = new Helmet(new BasicItemView(), new Statistics());
		StructuredMap map = met.getStructuredMap();

		EquipableItem testHelmet = EquipableItemFactory.createItem( map);
		assertEquals(met.getStructuredMap().getJson(), testHelmet.getStructuredMap().getJson());
		
	}
	
	@Test
	public void testChestPiece() {
		ChestPiece met = new ChestPiece(new BasicItemView(), new Statistics());
		StructuredMap map = met.getStructuredMap();
		
		EquipableItem testHelmet = EquipableItemFactory.createItem(map);
		assertEquals(met.getStructuredMap().getJson(), testHelmet.getStructuredMap().getJson());
		
	}

}
