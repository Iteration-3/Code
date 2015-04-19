package factories;

import model.item.ConsumableItem;
import model.item.TakeableItem;
import model.statistics.EntityStatistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class TakeableItemFactory {
	public static TakeableItem createItem(StructuredMap map) {
		if(map == null) {
			return null;
		}
		try {
			
		
		
		switch (map.getString("type")) {
		case "consumeable":
			return createConsumeable(map);
		case "noItem":
			return null;
		default:
			return EquipableItemFactory.createItem(map);
		}
		}
		catch (Exception e) {
			StructuredMap tempMap = map;
			System.out.println(map.getJson());
			return null;
		}
	}

	private static TakeableItem createConsumeable(StructuredMap map) {
		return new ConsumableItem(map);
	}
}
