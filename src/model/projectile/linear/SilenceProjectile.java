package model.projectile.linear;

import model.area.Area;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.projectile.Projectile;
import model.trigger.Trigger;
import utilities.Angle;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile(TileCoordinate location, Angle direction, Area area, Event event, double speed) {
		super(location, direction, area, event, speed);
	}
}