package model.entity.behavior.npc.observe;

import utilities.Angle;
import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.EntityManager;

public abstract class MovementChangingObservable implements ObservableBehaviorState {
	private Entity target;
	private Entity chosenOne;
	private Area area;
	private int ticker  = 500;
	private int count;
	private boolean found = false;
	private Angle move;
	
	public MovementChangingObservable(Entity entity,int radius,Entity target,Area area){
		this.chosenOne = entity;
		this.target = target;
		this.area = area;
		this.area.setRange(radius);
		this.area.setStartLocation(target.getLocation());
	}

	protected abstract Angle setMove(TileCoordinate chosen,TileCoordinate target);

	public final void observe() {
		if (count++ == ticker){
			if (EntityManager.getSingleton().findEntityFromLocations(area.getCoveredLocations(), 
					this.target)){
				TileCoordinate targetLocation = this.target.getLocation();
				TileCoordinate chosenLocation = this.chosenOne.getLocation();
				this.move = this.setMove(chosenLocation,targetLocation);
				this.setFound();
			}
			count = 0;
		}
	}
	
	public final Angle getMove(){
		Angle move = this.move;
		this.move = null;
		return move;
	}
	
	private final void setFound(){
		this.found = true;
	}
	
	private final void clearFound(){
		this.found = false;
	}
	
	public final boolean found(){
		if (this.found){
			this.clearFound();
			return true;
		}
		else{
			return false;
		}
	}

}
