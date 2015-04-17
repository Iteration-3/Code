package model.projectile.linear;

import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new ManaModifierEvent(10, -100);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(null, damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public SilenceProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}
