package model.itemmanager;

import java.io.File;
import java.io.FileWriter;

import model.area.TileCoordinate;
import model.entity.Avatar;
import model.entity.Summoner;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import view.EntitySpriteFactory;
import view.EntityView;

public class ItemManagerTest {
	/*
	 * @Test public void testItemManagerSaving() { ItemManager manager = new
	 * ItemManager( new Smasher("kyle", new
	 * EntityView(EntitySpriteFactory.getBaldySpriteHolder()), new
	 * TileCoordinate(5, 5)));
	 * 
	 * manager.equipToSlot(new Boots(new BasicItemView(), new Statistics()));
	 * manager.equipToSlot(new ChestPiece(new BasicItemView(), new
	 * Statistics()));
	 * 
	 * manager.equipToSlot(new Leggings(new BasicItemView(), new Statistics()));
	 * manager.equipToSlot(new Shield(new BasicItemView(), new Statistics()));
	 * 
	 * manager.addItem(new ConsumableItem(new BasicItemView(), new
	 * EntityStatistics(), 4.6)); manager.addItem(new Gloves(new
	 * BasicItemView(), new Statistics()));
	 * 
	 * System.out.println(manager.getStructuredMap().getJson());
	 * 
	 * ItemManager managerTest = new ItemManager(manager.getStructuredMap());
	 * assertEquals(manager.getStructuredMap().getJson(),
	 * managerTest.getStructuredMap().getJson());
	 * 
	 * }
	 * 
	 * @Test public void testInventory() { Inventory inventory = new
	 * Inventory(); inventory.addItem(new ConsumableItem(new BasicItemView(),
	 * new EntityStatistics(), 4.6)); inventory.addItem(new Gloves(new
	 * BasicItemView(), new Statistics()));
	 * 
	 * StructuredMap map = inventory.getStructuredMap();
	 * 
	 * //System.out.println(map.getJson());
	 * 
	 * Inventory newInventory = new Inventory(map); assertEquals(map.getJson(),
	 * newInventory.getStructuredMap().getJson());
	 * 
	 * }
	 *//*
		 * @Test public void testEquipmentManager() {
		 * 
		 * EquipmentManager manager = new EquipmentManager( new Smasher("kyle",
		 * new EntityView(EntitySpriteFactory.getBaldySpriteHolder()), new
		 * TileCoordinate(5, 5))); manager.equip(new Boots(new BasicItemView(),
		 * new Statistics())); manager.equip(new ChestPiece(new BasicItemView(),
		 * new Statistics())); manager.equip(new SmasherWeapon(new
		 * BasicItemView())); manager.equip(new Shield(new BasicItemView(), new
		 * Statistics()));
		 * 
		 * StructuredMap map = manager.getStructuredMap();
		 * 
		 * System.out.println(map.getJson());
		 * 
		 * EquipmentManager newEquipmentManager = new EquipmentManager(map);
		 * assertEquals(map.getJson(), newEquipmentManager.getStructuredMap()
		 * .getJson());
		 * 
		 * }
		 */
	@Test
	public void testEntitySave() {
		Avatar avatar = new Summoner("kyle", new EntityView(
				EntitySpriteFactory.getBaldySpriteHolder()),
				new TileCoordinate(5, 5));
		System.out.println(avatar.getStructuredMap());

		try {
			StructuredMap map = avatar.getStructuredMap();
			
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

}
