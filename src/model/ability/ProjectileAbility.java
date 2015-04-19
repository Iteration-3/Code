package model.ability;

import model.area.TileCoordinate;
import model.entity.Avatar;
import model.projectile.Projectile;
import utilities.Angle;

public abstract class ProjectileAbility extends Ability {
	
	public ProjectileAbility() {
		super();
	}
	
	public ProjectileAbility(int manaCost) {
		super(manaCost);
	}
	
	public abstract Projectile getProjectile();

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);

			Projectile projectile = getProjectile();
			TileCoordinate avatarLocation = avatar.getLocation();
			Angle projectileDirection = avatar.getDirection();
			TileCoordinate projectileLocation = avatarLocation.nextLocation(projectileDirection);

			projectile.setDirection(projectileDirection);
			projectile.move(projectileLocation);
			projectile.placeOnMap();
		}
	}
	


}
