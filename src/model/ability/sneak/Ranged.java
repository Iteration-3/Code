package model.ability.sneak;

import model.ability.ProjectileAbility;
import model.projectile.Projectile;
import model.projectile.linear.ThrowingKnife;
import model.skillmanager.SneakSkillManager;

public class Ranged extends ProjectileAbility {
	
	private SneakSkillManager manager;
	
	public Ranged(SneakSkillManager sneakSkillManager) {
		super(10);
		this.manager = sneakSkillManager;
	}
	
	
	public Projectile getProjectile() {
		ThrowingKnife knife =  new ThrowingKnife();
		knife.setLevel(1);
		return knife;
	}
}
