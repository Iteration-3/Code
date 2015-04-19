package model.entity.behavior.npc.observe;

import utilities.Angle;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.EntityManager;

public class TargetAvatar implements ObservableBehaviorState {
	private Entity chosenOne;
	private int ticker  = 300000;
	private int count;
	private int radius;
	private boolean found = false;
	private Angle move;
	
	public TargetAvatar(Entity entity,int radius){
		this.chosenOne = entity;
		this.radius = radius;
	}

	public void observe() {
		if (count++ == ticker){
			RadialArea radius = new RadialArea(this.radius,this.chosenOne.getLocation());
			if (EntityManager.getSingleton().findEntityFromLocations(radius.getCoveredLocations(), 
					EntityManager.getSingleton().getAvatar())){
				this.setMove();
			}
			count = 0;
		}
	}
	
	private void setMove(){
		TileCoordinate avatarLocation = EntityManager.getSingleton().getAvatar().getLocation();
		TileCoordinate chosenLocation = this.chosenOne.getLocation();
		int chosenX = chosenLocation.getX();
		int chosenY = chosenLocation.getY();
		int avatarX = avatarLocation.getX();
		int avatarY = avatarLocation.getY();
		if (avatarY > chosenY){
			this.move = Angle.DOWN;
		}
		else if (avatarX > chosenX){
			this.move = Angle.UP_RIGHT;
		}
		else if (avatarX < chosenX){
			this.move = Angle.UP_LEFT;
		}
		else if (avatarY < chosenY){
			this.move = Angle.UP;
		}
		this.found = true;
		
	}
	
	public Angle getMove(){
		Angle move = this.move;
		this.move = null;
		return move;
	}
	
	public boolean found(){
		if (this.found){
			found = false;
			return true;
		}
		else{
			return false;
		}
	}

}
