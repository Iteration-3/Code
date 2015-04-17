package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.projectile.linear.CripplingProjectile;

public class Cripple extends ProjectileAbility {
	
	public Cripple() {
		super(new CripplingProjectile(), 15);
	}
	
	public Cripple(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

}