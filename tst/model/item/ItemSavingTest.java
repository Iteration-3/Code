package model.item;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileWriter;

import model.statistics.EntityStatistics;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;

public class ItemSavingTest {

	@Test
	public void testConsumable() {
		ConsumableItem item = new ConsumableItem(new BasicItemView(),
				new EntityStatistics(), 4.5);
		StructuredMap map = item.getStructuredMap();
		System.out.println(map.getJson());

		ConsumableItem testItem = new ConsumableItem(map);

		assertEquals(map.getJson(), testItem.getStructuredMap().getJson());
		
		try {
			map = testItem.getStructuredMap();
			
			File dir = new File("gamedata");
			dir.mkdir();
			File outFile = new File(dir, "filetest.txt");
			FileWriter writer = new FileWriter(outFile);
			writer.write(map.getJson());
			writer.flush();
			writer.close();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void testHelmet() {
		Helmet helmet = new Helmet(new BasicItemView(), new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		Helmet helmet2 = new Helmet(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

	@Test
	public void testChestPiece() {
		ChestPiece helmet = new ChestPiece(new BasicItemView(),
				new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		ChestPiece helmet2 = new ChestPiece(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

	@Test
	public void testLeggings() {
		Leggings helmet = new Leggings(new BasicItemView(), new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		Leggings helmet2 = new Leggings(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

	@Test
	public void testBoots() {
		Boots helmet = new Boots(new BasicItemView(), new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		Boots helmet2 = new Boots(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

	@Test
	public void testGloves() {
		Gloves helmet = new Gloves(new BasicItemView(), new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		Gloves helmet2 = new Gloves(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

	@Test
	public void testProjectile() {
		Projectile helmet = new Projectile(new BasicItemView(),
				new Statistics());
		StructuredMap map = helmet.getStructuredMap();
		System.out.println(map.getJson());

		Projectile helmet2 = new Projectile(map);
		assertEquals(map.getJson(), helmet2.getStructuredMap().getJson());
	}

}
