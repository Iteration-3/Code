package factories;

import model.item.ConsumableItem;
import model.item.TakeableItem;
import model.statistics.EntityStatistics;
import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;

public class TakeableItemFactory {

	public static TakeableItem createItem(String key, StructuredMap map) {
		switch (key) {
			case "consumableItem":
				return createConsumeable(map);
			case "noItem":
				return null;
			default:
				return EquipableItemFactory.createItem(key, map);
		}
	}

	private static TakeableItem createConsumeable(StructuredMap map) {
		StructuredMap statisitics = map.getStructuredMap("stats");
		
		double duration = map.getDouble("duration");
		return new ConsumableItem(new BasicItemView(), new EntityStatistics(
				statisitics), duration);
	}
}
