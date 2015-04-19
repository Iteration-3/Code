package model.ability.sneak;

import model.ability.ProjectileAbility;
import model.projectile.Projectile;
import model.projectile.linear.ThrowingKnife;
import utilities.structuredmap.StructuredMap;

public class Ranged extends ProjectileAbility {
	
	public Ranged() {
		super(10);
	}
	
	public Ranged(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public Ranged(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "ranged";
	}
	
	public Projectile getProjectile() {
		return new ThrowingKnife();
	}
}
