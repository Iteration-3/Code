package factories;

import model.item.ConsumableItem;
import model.item.TakeableItem;
import model.statistics.EntityStatistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class TakeableItemFactory {
	public static TakeableItem createItem(StructuredMap map) {
		if (map == null) {
			return null;
		}

		switch (map.getString("type")) {
		case "consumeable":
			return createConsumeable(map);
		case "noItem":
			return null;
		default:
			return EquipableItemFactory.createItem(map);
		}

	}

	private static TakeableItem createConsumeable(StructuredMap map) {
		return new ConsumableItem(map);
	}
}
