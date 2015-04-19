package model.projectile.linear;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;

public class FireProjectile extends Projectile {
	
	public FireProjectile() {
		super();
		this.setLevel(1);
	}
	
	public FireProjectile(TileCoordinate tile, Angle direction, double speed, Trigger trigger) {
		super(direction, tile, speed, trigger);
	}
	
	
	@Override
	protected String getType() {
		return "fireProjectile";
	}


	public void setLevel(int x) {
		this.setSpeed(3*x);
		Event damageEvent = new HealthModifierEvent(0, -10*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
		
	}
}