package model.entity.behavior.npc.observe;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import utilities.Direction;

public class StopAtTarget extends MovementChangingObservable {

	public StopAtTarget(Entity entity, Entity target, Area area,
			Boolean continuousAreaReset) {
		super(entity, target, area);
	}

	@Override
	protected Direction setMove(TileCoordinate chosen, TileCoordinate target) {
		if (chosen.nextTo(target)){
			return null;
		}
		else{
			return Direction.PRODUCE_A_ANGLE.getNearestAngleTowardTarget(chosen, target);
		}
	}

	@Override
	protected boolean setResetAreaValue() {
		return false;
	}

}
