package model.projectile.linear;

import model.area.RadialArea;
import model.area.TileCoordinate;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.Projectile;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class FireProjectile extends Projectile {
	
	public FireProjectile() {
		super();
		this.setSpeed(3);
		Event damageEvent = new HealthModifierEvent(0, -10);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(0, null), damageEvent);
		this.setTrigger(damageTrigger);
	}
	
	public FireProjectile(TileCoordinate tile, Angle direction, double speed, Trigger trigger) {
		super(direction, tile, speed, trigger);
	}
	
	public FireProjectile(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected String getType() {
		return "fireProjectile";
	}
}