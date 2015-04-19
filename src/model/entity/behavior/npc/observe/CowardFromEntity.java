package model.entity.behavior.npc.observe;

import utilities.Angle;
import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;

public class CowardFromEntity extends MovementChangingObservable {

	public CowardFromEntity(Entity entity, int radius, Entity target, Area area) {
		super(entity, radius, target, area);
	}

	@Override
	protected Angle setMove(TileCoordinate chosenLocation,TileCoordinate targetLocation) {
		return Angle.PRODUCE_A_ANGLE.getFarthestAngleFromTarget(chosenLocation , targetLocation);
	}

}
