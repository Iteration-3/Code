package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.LinkWithTarget;
import model.entity.behavior.npc.observe.StopAtTarget;

public class PetBehavior implements Behaviorable {
	private Entity entity;
	private Entity target;
	private StopAtTarget observer;
	private LinkWithTarget performer;
	
	public PetBehavior(){}

	public void perform() {
		this.performer.perform();
	}

	public void observe() {
//		this.observer.observe();
	}

	public void interact(Entity entity) {
	}

	public void onDamage(Entity entity) {
	}

	public boolean isExpired() {
		return false;
	}

	public void onExit() {
	}

	public void onEnter() {
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setStates();
	}

	public void setStates() {
		performer = new LinkWithTarget(this.entity , 
				EntityManager.getSingleton().getAvatar());
	}

}
