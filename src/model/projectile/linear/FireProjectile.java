package model.projectile.linear;

import model.area.Area;
import model.area.TileCoordinate;
import model.event.Event;
import model.projectile.Projectile;
import utilities.Direction;

public class FireProjectile extends Projectile {
	
	public FireProjectile(TileCoordinate location, Direction direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}