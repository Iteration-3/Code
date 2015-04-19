package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.projectile.linear.SilenceProjectile;
import utilities.structuredmap.StructuredMap;


public class Silence extends ProjectileAbility {
	
	public Silence() {
		super(new SilenceProjectile(), 10);
	}
	
	public Silence(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public Silence(StructuredMap map) {
		super(map);
	}

	@Override
	protected String getType() {
		return "silence";
	}

}
