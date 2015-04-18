package model.ability;

import factories.ProjectileFactory;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.projectile.Projectile;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public abstract class ProjectileAbility extends Ability {
	private Projectile projectile;
	
	public ProjectileAbility() {
		super();
	}
	
	public ProjectileAbility(Projectile projectile, int manaCost) {
		super(manaCost);
		setProjectile(projectile);
	}
	
	public ProjectileAbility(StructuredMap map) {
		super(map);
		this.projectile = ProjectileFactory.createProjectile(map.getStructuredMap("projectile"));
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
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("projectile", projectile.getStructuredMap());
		return map;
	}

}
