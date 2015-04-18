package model.projectile.linear;

import utilities.Angle;
import model.area.RadialArea;
import model.event.Event;
import model.event.MovementModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class CripplingProjectile extends Projectile {
	
	public CripplingProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new MovementModifierEvent(5, -20);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public CripplingProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}

}
