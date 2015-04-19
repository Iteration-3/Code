package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.projectile.Projectile;
import model.projectile.linear.FireProjectile;
import utilities.structuredmap.StructuredMap;

public final class Firebolt extends ProjectileAbility {
	
	public Firebolt() {
		super(10);
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
	
	public Projectile getProjectile() {
		return new FireProjectile();
	}
}
