package model.projectile.linear;

import model.area.RadialArea;
import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile() {
		super();
		this.setLevel(1);
	}
	
	public SilenceProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	
	@Override
	protected String getType() {
		return "silenceProjectile";
	}

	public void setLevel(int x) {
		this.setSpeed(3*x);
		Event damageEvent = new ManaModifierEvent(10*x, -100*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
		
	}

}
