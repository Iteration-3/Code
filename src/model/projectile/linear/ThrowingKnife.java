package model.projectile.linear;

import utilities.Angle;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;

public class ThrowingKnife extends Projectile {
	
	public ThrowingKnife(TileCoordinate location, Angle direction, Trigger trigger, double speed) {
		super(location, direction, trigger, speed);
	}
	
	/*public void setLevel(int x){
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -10*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
	}*/
}