package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.projectile.conical.IntimidateConeProjectile;
import utilities.structuredmap.StructuredMap;

public class Intimidate extends ProjectileAbility {
	
	public Intimidate() {
		super(new IntimidateConeProjectile(), 15);
	}
	
	public Intimidate(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public Intimidate(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "intimidate";
	}
}
