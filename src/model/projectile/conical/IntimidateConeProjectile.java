package model.projectile.conical;

import model.area.GrowingArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.trigger.Trigger;
import utilities.Direction;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile(TileCoordinate location, Direction direction, GrowingArea garea, Event event, double speed) {
		super(location, direction, garea, event, speed);
	}
}
