package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.projectile.Projectile;
import model.projectile.linear.CripplingProjectile;
import utilities.structuredmap.StructuredMap;

public class Cripple extends ProjectileAbility {
	
	public Cripple() {
		super(15);
	}
	
	public Cripple(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public Cripple(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "cripple";
	}

	public Projectile getProjectile() {
		return new CripplingProjectile();
	}
}
