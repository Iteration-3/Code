package factories;

import model.item.Boots;
import model.item.ChestPiece;
import model.item.EquipableItem;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Shield;
import utilities.structuredmap.StructuredMap;
import view.item.BasicItemView;

public class EquipableItemFactory {
	public static EquipableItem createItem(StructuredMap map) {
		switch (map.getString("type")) {
		case "helmet":
			return new Helmet(new BasicItemView(), map);
		case "chestPiece":
			return new ChestPiece(new BasicItemView(), map);
		case "leggings":
			return new Leggings(new BasicItemView(), map);
		case "gloves":
			return new Gloves(new BasicItemView(), map);
		case "boots":
			return new Boots(new BasicItemView(), map);
		case "shield":
			return new Shield(new BasicItemView(), map);
		default:
			throw new IllegalArgumentException("Fuck this");

		}
	}
}
