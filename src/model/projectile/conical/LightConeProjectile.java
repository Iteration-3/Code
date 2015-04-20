package model.projectile.conical;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class LightConeProjectile extends ConicalProjectile {
	
	public LightConeProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
}