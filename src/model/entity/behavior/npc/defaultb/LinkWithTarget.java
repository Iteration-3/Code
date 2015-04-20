package model.entity.behavior.npc.defaultb;

import model.entity.Entity;
import utilities.Angle;

public class LinkWithTarget implements DefaultableBehaviorState {
	private Entity chosen;
	private Entity target;
	private int ticker = 300;
	private int count;

	public LinkWithTarget(Entity chosen, Entity target) {
		this.chosen = chosen;
		this.target = target;
	}

	@Override
	public void perform() {
		if (count++ == ticker){
			if (! this.chosen.getLocation().nextTo(target.getLocation())){
				this.chosen.move(Angle.PRODUCE_A_ANGLE.getNearestAngleTowardTarget(
						this.chosen.getLocation(), this.target.getLocation()));
			}
			count = 0;
		}
	}

}
