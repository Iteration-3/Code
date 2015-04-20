package model.projectile.linear;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
}