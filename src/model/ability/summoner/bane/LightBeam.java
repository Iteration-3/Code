package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.projectile.conical.LightConeProjectile;
import utilities.structuredmap.StructuredMap;

public final class LightBeam extends ProjectileAbility {
	
	public LightBeam() {
		super(new LightConeProjectile(), 20);
	}
	
	public LightBeam(StructuredMap map) {
		super(map);
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
