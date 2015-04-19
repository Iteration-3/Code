package model.projectile.conical;

import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class LightConeProjectile extends ConicalProjectile {
	
	public LightConeProjectile() {
		super();
		this.setLevel(1);
	}
	
	public LightConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

	public void setLevel(int x) {
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -15*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
		
	}
}