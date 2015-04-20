package factories;

import model.item.ConsumableItem;
import model.item.HPPotion;
import model.item.TakeableItem;
import utilities.structuredmap.StructuredMap;

public class TakeableItemFactory {
	public static TakeableItem createItem(StructuredMap map) {
		if (map == null) {
			return null;
		}

		switch (map.getString("type")) {
		case "consumeable":
			return createConsumeable(map);
		case "healItem":
			return new HPPotion(map);
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
