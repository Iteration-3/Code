package model.projectile.linear;

import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class FireProjectile extends Projectile {
	
	public FireProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -10);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public FireProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}