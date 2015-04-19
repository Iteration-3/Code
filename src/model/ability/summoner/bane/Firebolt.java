package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.projectile.linear.FireProjectile;
import utilities.structuredmap.StructuredMap;

public final class Firebolt extends ProjectileAbility {
	
	public Firebolt() {
		super(new FireProjectile(), 10);
	}
	
	public Firebolt(StructuredMap map) {
		super(map);
	}
	
	public Firebolt(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	protected String getType() {
		return "firebolt";
	}
	

}
