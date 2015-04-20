package model.projectile.conical;

import model.area.GrowingArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.projectile.Projectile;
import utilities.Direction;

public class ConicalProjectile extends Projectile {

	private boolean isSafe;
	
	public ConicalProjectile(TileCoordinate location, Direction direction, GrowingArea garea, Event event, double speed) {
		super(location, direction, garea, event, speed);
	}

	@Override
	public void advance() {
		GrowingArea garea = ((GrowingArea) getTrigger().getArea());
		if (!isTimedOut() && garea.canGrow()) {
			garea.grow();
			timeOutProjectile();
			notifySubscribers();
		}
		if (isTimedOut() && !garea.canGrow()) {
			garea.grow();
			//notifySubscribers(); // dispose handles this
			isSafe = true;
		}
	}

	@Override
	public boolean hasExpired() {
		return getTrigger().hasExpired() || (!((GrowingArea) getTrigger().getArea()).canGrow() && isSafe && isTimedOut());
	}
}