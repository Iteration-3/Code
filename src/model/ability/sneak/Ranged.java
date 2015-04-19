package model.ability.sneak;

import model.ability.ProjectileAbility;
import model.projectile.Projectile;
import model.projectile.linear.ThrowingKnife;

public class Ranged extends ProjectileAbility {
	
	public Ranged() {
		super(10);
	}
	
	public Ranged(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	
	public Projectile getProjectile() {
		return new ThrowingKnife();
	}
}
