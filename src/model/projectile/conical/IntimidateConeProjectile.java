package model.projectile.conical;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
}
