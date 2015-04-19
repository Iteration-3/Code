package model.projectile.linear;

import utilities.Angle;
import model.area.RadialArea;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class ThrowingKnife extends Projectile {

	public ThrowingKnife() {
		super();
		setLevel(1);
		
	}
	
	public ThrowingKnife(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	
	@Override
	protected String getType() {
		return "throwingKnife";
	}
	
	public void setLevel(int x){
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -10*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}

}
