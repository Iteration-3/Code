package model.projectile.linear;

import model.area.Area;
import model.area.TileCoordinate;
import model.event.Event;
import model.projectile.Projectile;
import model.trigger.Trigger;
import utilities.Direction;

public class ShadowBlastProjectile extends Projectile {
	
	public ShadowBlastProjectile(TileCoordinate location, Direction direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}