package model.projectile.linear;

import model.area.TileCoordinate;
import model.projectile.Projectile;
import utilities.Angle;
import model.area.Area;
import model.event.Event;

public class ThrowingKnife extends Projectile {
	
	public ThrowingKnife(TileCoordinate location, Angle direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}