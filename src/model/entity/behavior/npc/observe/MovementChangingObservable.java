package model.entity.behavior.npc.observe;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.EntityManager;
import utilities.Angle;

public abstract class MovementChangingObservable implements ObservableBehaviorState {
	private Entity target;
	private Entity chosenOne;
	private Area area;
	private int ticker  = 500;
	private int count;
	private boolean found = false;
	private Angle move;
	private boolean reset;
	
	public MovementChangingObservable(Entity entity,Entity target,Area area){
		this.chosenOne = entity;
		this.target = target;
		this.area = area;
	}

	protected abstract Angle setMove(TileCoordinate chosen,TileCoordinate target);
	protected abstract boolean setResetAreaValue();

	@Override
	public final void observe() {
		if (count++ == ticker){
			if (EntityManager.getSingleton().findEntityFromLocations(this.area.getCoveredLocations(), 
					this.target)){
				TileCoordinate targetLocation = this.target.getLocation();
				TileCoordinate chosenLocation = this.chosenOne.getLocation();
				this.move = this.setMove(chosenLocation,targetLocation);
				this.reset = this.setResetAreaValue();
				this.setFound();
			}
			count = 0;
		}
	}
	
	private boolean getResetArea(){
		return reset;
	}
	
	public final Angle getMove(){
		Angle move = this.move;
		this.move = null;
		if (this.getResetArea()){
			area.setStartLocation(this.chosenOne.getLocation());
		}
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
