package factories;

import model.item.Boots;
import model.item.ChestPiece;
import model.item.EquipableItem;
import model.item.Gloves;
import model.item.Helmet;
import model.item.Leggings;
import model.item.Shield;
import utilities.structuredmap.StructuredMap;

public class EquipableItemFactory {
	public static EquipableItem createItem(StructuredMap map) {
		if(map == null) {
			return null;
		}
		switch (map.getString("type")) {
		case "helmet":
			return new Helmet(map);
		case "chestPiece":
			return new ChestPiece(map);
		case "leggings":
			return new Leggings(map);
		case "gloves":
			return new Gloves( map);
		case "boots":
			return new Boots(map);
		case "shield":
			return new Shield( map);
		case "THW" :
			return WeaponFactory.createTwoHandedWeapon(map);
		default:
			return WeaponFactory.createWeapon(map);
		}
	}
}
