package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.projectile.linear.ShadowBlastProjectile;

public final class ShadowBlast extends ProjectileAbility {

	public ShadowBlast() {
		super(new ShadowBlastProjectile(), 50);
	}
	
	public ShadowBlast(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	protected String getType() {
		return "shadowBlast";
	}
}
