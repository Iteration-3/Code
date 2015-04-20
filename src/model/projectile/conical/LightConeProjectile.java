package model.projectile.conical;

import model.area.GrowingArea;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.trigger.Trigger;
import utilities.Angle;

public class LightConeProjectile extends ConicalProjectile {
	
	public LightConeProjectile(TileCoordinate location, Angle direction, GrowingArea garea, Event event, double speed) {
		super(location, direction, garea, event, speed);
	}
}