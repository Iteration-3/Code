package model.entity.behavior.npc.observe;

import model.area.Area;
import model.entity.Entity;
import model.entity.EntityManager;

public class FindTargetRandom implements ObservableBehaviorState {
	private Entity target;
	private Entity chosenOne;
	private Entity attackThisPerson;
	private Area area;
	private int ticker = 10000;
	private int count;
	private boolean found = false;

	public FindTargetRandom(Entity entity, Area area) {
		this.chosenOne = entity;
		this.area = area;
	}

	@Override
	public final void observe() {
		boolean foundTarget = false;
		if (count++ == ticker) {
			this.area.setStartLocation(this.chosenOne.getLocation());
			for (Entity e : EntityManager.getSingleton()
					.getEntityFromLocaitons(this.area.getCoveredLocations())) {
			
				if (Math.random() > 0.8 || foundTarget){
					if (e == EntityManager.getSingleton().getAvatar()){
						foundTarget = true;
					}
					else{
						this.setFound();
						this.attackThisPerson = e;
					}
				}
			}
			count = 0;
		}
		foundTarget = false;
	}

	private final void setFound() {
		this.found = true;
	}

	private final void clearFound() {
		this.found = false;
	}

	public final boolean found() {
		if (this.found) {
			this.clearFound();
			return true;
		} else {
			return false;
		}
	}
	
	public Entity getFoundPerson(){
		return this.attackThisPerson;
	}

}
