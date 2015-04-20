package factories;

import model.item.Door;
import model.item.Item;
import model.item.ObstacleItem;
import model.item.OneShotItem;
import model.item.Trap;
import utilities.structuredmap.StructuredMap;

public class ItemFactory {

	public static Item createItem(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "trap":
			return new Trap(structuredMap);
		case "obstacleItem":
			return new ObstacleItem(structuredMap);
		case "oneShot":
			return new OneShotItem(structuredMap);
		case "door" :
			return new Door(structuredMap);
		default:
			return TakeableItemFactory.createItem(structuredMap);
		}
	}

}
