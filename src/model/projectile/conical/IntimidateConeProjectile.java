package model.projectile.conical;

import model.area.RadialArea;
import model.event.Event;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;
import model.trigger.SingleUseTrigger;
import model.trigger.Trigger;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public class IntimidateConeProjectile extends ConicalProjectile {

	public IntimidateConeProjectile() {
		super();
		this.setLevel(1);
	}
	
	public IntimidateConeProjectile(Angle direction, double speed, Trigger trigger) {
		super(direction, null, speed, trigger);
	}
	
	public IntimidateConeProjectile(StructuredMap map) {
		super(map);
	}
	
	@Override
	protected String getType() {
		return "intimidateConeProjectile";
	}

	public void setLevel(int x) {
		this.setSpeed(3*x);
		Event damageEvent = new StatisticModifierEvent(new Statistics(-20*x, 0, 0, 0), 5*x);
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		this.setTrigger(damageTrigger);
		
	}

}
