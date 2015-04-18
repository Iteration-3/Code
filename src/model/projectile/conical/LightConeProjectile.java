package model.projectile.conical;

import utilities.Angle;
import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class LightConeProjectile extends ConicalProjectile {
	
	public LightConeProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -15);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public LightConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}
