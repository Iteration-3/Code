package model.projectile.linear;

import model.area.RadialArea;
import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class SilenceProjectile extends Projectile {
	
	public SilenceProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new ManaModifierEvent(10, -100);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public SilenceProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	public SilenceProjectile(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected String getType() {
		return "silenceProjectile";
	}

}
