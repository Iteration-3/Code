package factories;

import model.ability.Ability;
import model.ability.BindWounds;
import model.ability.smasher.SmasherWeaponAttack;
import model.ability.sneak.Creep;
import model.ability.sneak.DetectTrap;
import model.ability.sneak.PickPocket;
import model.ability.sneak.Ranged;
import model.ability.sneak.RemoveTrap;
import model.ability.summoner.bane.Firebolt;
import model.ability.summoner.bane.LightBeam;
import model.ability.summoner.bane.ShadowBlast;
import model.ability.summoner.boon.FlightBoon;
import model.ability.summoner.boon.HealBoon;
import model.ability.summoner.boon.MovementBoon;
import model.ability.summoner.boon.StrengthBoon;
import model.ability.summoner.enchantment.Cripple;
import model.ability.summoner.enchantment.Intimidate;
import model.ability.summoner.enchantment.Silence;
import utilities.structuredmap.StructuredMap;

public class AbilityFactory {

	public static Ability createAbility(StructuredMap ability) {
		switch (ability.getString("type")) {
		case "bindWounds":
			return new BindWounds(ability);
		case "smasherWeaponAttack":
			return new SmasherWeaponAttack(ability);
		case "creep" :
			return new Creep(ability);
		case "detectTrap" :
			return new DetectTrap(ability);
		case "pickPocket" :
			return new PickPocket(ability);
		case "ranged" :
			return new Ranged(ability);
		case "removeTrap" :
			return new RemoveTrap(ability);
		case "firebolt" :
			return new Firebolt(ability);
		case "lightBeam" :
			return new LightBeam(ability);
		case "shadowBlast" :
			return new ShadowBlast(ability);
		case "flightBoon" :
			return new FlightBoon(ability);
		case "healBoon" :
			return new HealBoon(ability);
		case "movementBoon" :
			return new MovementBoon(ability);
		case "strengthBoon" :
			return new StrengthBoon(ability);
		case "cripple" :
			return new Cripple(ability);
		case "intimidate" :
			return new Intimidate(ability);
		case "silence" : 
			return new Silence(ability);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}
}
