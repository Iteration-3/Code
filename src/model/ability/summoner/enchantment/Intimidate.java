package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.projectile.conical.IntimidateConeProjectile;

public class Intimidate extends ProjectileAbility {
	
	public Intimidate() {
		super(new IntimidateConeProjectile(), 15);
	}
	
	public Intimidate(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	protected String getType() {
		return "intimidate";
	}
}
