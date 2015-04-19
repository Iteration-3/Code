package model.entity.behavior.npc.observe;

import utilities.Angle;
import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;

public class TargetEntity extends MovementChangingObservable {
	private boolean reset;
	
	public TargetEntity(Entity entity,Entity target,Area area,Boolean continuousAreaReset ){
		super(entity,target,area);
		this.reset = continuousAreaReset;
	}
	
	@Override
	protected Angle setMove(TileCoordinate chosenLocation, TileCoordinate targetLocation){
		return Angle.PRODUCE_A_ANGLE.getNearestAngleTowardTarget(chosenLocation, targetLocation);
	}

	@Override
	protected boolean setResetAreaValue() {
		return reset;
	}
}
