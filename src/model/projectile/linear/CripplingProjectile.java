package model.projectile.linear;

import model.area.RadialArea;
import model.event.Event;
import model.event.MovementModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class CripplingProjectile extends Projectile {
	
	public CripplingProjectile() {
		super();
		this.setLevel(1);
	}
	public void setLevel(int x){
		this.setSpeed(3*x);
		Event damageEvent = new MovementModifierEvent(5*x, -20*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public CripplingProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	public CripplingProjectile(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected String getType() {
		return "cripplingProjectile";
	}

}
