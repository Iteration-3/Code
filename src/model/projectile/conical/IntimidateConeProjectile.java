package model.projectile.conical;

import model.area.RadialArea;
import model.event.Event;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new StatisticModifierEvent(new Statistics(-20, 0, 0, 0), 5);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public IntimidateConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}
