package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.projectile.conical.LightConeProjectile;

public final class LightBeam extends ProjectileAbility {
	
	public LightBeam() {
		super(new LightConeProjectile(), 20);
	}
	
	public LightBeam(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	protected String getType() {
		return "lightBeam";
	}
	
}
