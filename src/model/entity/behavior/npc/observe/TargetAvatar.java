package model.entity.behavior.npc.observe;

import model.area.RadialArea;
import model.entity.Entity;
import model.entity.EntityManager;

public class TargetAvatar implements ObservableBehaviorState {
	private Entity chosenOne;
	private int ticker  = 300000;
	private int count;
	private int radius;
	
	public TargetAvatar(Entity entity,int radius){
		this.chosenOne = entity;
		this.radius = radius;
	}

	public void observe() {
		if (count++ == ticker){
			RadialArea radius = new RadialArea(this.radius,this.chosenOne.getLocation());
			if (EntityManager.getSingleton().findEntityFromLocations(radius.getCoveredLocations(), 
					EntityManager.getSingleton().getAvatar())){
				EntityManager.getSingleton().getAvatar().getLocation();
				System.out.println("FOUND YOU");
			}
			count = 0;
		}
	}

}
