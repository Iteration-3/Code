package model.projectile.conical;

import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class LightConeProjectile extends ConicalProjectile {
	
	public LightConeProjectile() {
		super();
		this.setLevel(1);
	}
	
	public LightConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	public LightConeProjectile(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected String getType() {
		return "lightConeProjectile";
	}

	public void setLevel(int x) {
		this.setSpeed(3*x);
		Event damageEvent = new HealthModifierEvent(0, -15*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
		
	}

}
