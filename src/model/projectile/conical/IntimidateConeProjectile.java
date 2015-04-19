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
		this.setLevel(1);
	}
	
	public IntimidateConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

	public void setLevel(int x) {
		this.setSpeed(3);
		Event damageEvent = new StatisticModifierEvent(new Statistics(-20*x, 0, 0, 0), 5*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
}
