package model.ability;

import utilities.Angle;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.projectile.Projectile;

public abstract class ProjectileAbility extends Ability {
	private Projectile projectile;
	
	public ProjectileAbility() {
		super();
	}
	
	public ProjectileAbility(Projectile projectile, int manaCost) {
		super(manaCost);
		setProjectile(projectile);
	}

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);

			Projectile projectile = this.getProjectile().clone();
			TileCoordinate avatarLocation = avatar.getLocation();
			Angle projectileDirection = avatar.getDirection();
			TileCoordinate projectileLocation = avatarLocation.nextLocation(projectileDirection);

			projectile.setDirection(projectileDirection);
			projectile.setLocation(projectileLocation);
			projectile.placeOnMap();
		}
	}

	public Projectile getProjectile() {
		return projectile;
	}

	public void setProjectile(Projectile projectile) {
		this.projectile = projectile;
	}

}
