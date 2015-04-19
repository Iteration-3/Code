package model.projectile.linear;

import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class ShadowBlastProjectile extends Projectile {

	public ShadowBlastProjectile() {
		super();
		this.setLevel(1);
	}
	
	public ShadowBlastProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	
	@Override
	protected String getType() {
		return "shadowBlastProjectile";
	}

	public void setLevel(int x) {
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -40*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}

}
