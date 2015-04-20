package model.projectile.linear;

import model.area.Area;
import model.area.TileCoordinate;
import model.event.Event;
import model.projectile.Projectile;
import utilities.Angle;

public class FireProjectile extends Projectile {
	
	public FireProjectile(TileCoordinate location, Angle direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}