package model.projectile.linear;

import model.area.TileCoordinate;
import model.projectile.Projectile;
import model.trigger.Trigger;
import utilities.Direction;
import model.area.Area;
import model.event.Event;

public class ThrowingKnife extends Projectile {
	
	public ThrowingKnife(TileCoordinate location, Direction direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}