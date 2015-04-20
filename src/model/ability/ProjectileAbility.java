package model.ability;

import model.entity.Avatar;
import model.entity.Entity;
import model.projectile.Projectile;

public abstract class ProjectileAbility extends Ability {
	
	public ProjectileAbility() {
		super();
	}
	
	public ProjectileAbility(int manaCost) {
		super(manaCost);
	}
	
	public abstract Projectile getProjectile(Entity ent);

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);

			Projectile projectile = getProjectile(avatar);
			projectile.placeOnMap();
		}
	}
	


}
