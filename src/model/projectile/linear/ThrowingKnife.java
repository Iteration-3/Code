package model.projectile.linear;

import utilities.Angle;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class ThrowingKnife extends Projectile {

	public ThrowingKnife() {
		super();
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -10);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(null, damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public ThrowingKnife(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}
