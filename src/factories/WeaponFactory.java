package factories;

import model.item.SmasherWeapon;
import model.item.SneakWeapon;
import model.item.SummonerWeapon;
import model.item.TwoHandedWeapon;
import model.item.Weapon;
import utilities.structuredmap.StructuredMap;

public class WeaponFactory {

	public static Weapon createWeapon(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "smasher":
			return new SmasherWeapon(structuredMap);
		case "sneak":
			return new SneakWeapon(structuredMap);
		case "summoner":
			return new SummonerWeapon(structuredMap);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}
	
	public static TwoHandedWeapon createTwoHandedWeapon(StructuredMap map) {
		return new TwoHandedWeapon(map);
	}

}
