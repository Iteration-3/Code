package model.entity.behavior.npc.observe;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import utilities.Direction;

public class CowardFromEntity extends MovementChangingObservable {
	boolean reset;

	public CowardFromEntity(Entity entity, Entity target, Area area,Boolean continuousAreaReset) {
		super(entity, target, area);
		this.reset = continuousAreaReset;
	}

	@Override
	protected Direction setMove(TileCoordinate chosenLocation,TileCoordinate targetLocation) {
		return Direction.PRODUCE_A_ANGLE.getFarthestAngleFromTarget(chosenLocation , targetLocation);
	}

	@Override
	protected boolean setResetAreaValue() {
		return this.reset;
	}
}
