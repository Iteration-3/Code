package model.projectile.conical;

import model.area.GrowingArea;
import model.area.TileCoordinate;
import model.event.Event;
import utilities.Angle;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile(TileCoordinate location, Angle direction, GrowingArea garea, Event event, double speed) {
		super(location, direction, garea, event, speed);
	}
}
