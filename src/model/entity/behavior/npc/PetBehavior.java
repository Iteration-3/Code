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

	@Override
	public void perform(double deltaTime) {
		this.performer.perform();
	}

	@Override
	public void observe(double deltaTime) {
//		this.observer.observe();
	}

	@Override
	public void interact(Entity entity) {
	}

	@Override
	public void onDamage(Entity entity) {
	}

	@Override
	public boolean isExpired() {
		return false;
	}

	@Override
	public void onExit() {
	}

	@Override
	public void onEnter() {
	}

	@Override
	public void setEntity(Entity entity) {
		this.entity = entity;
		this.setStates();
	}

	@Override
	public void setStates() {
		performer = new LinkWithTarget(this.entity , 
				EntityManager.getSingleton().getAvatar());
	}

}
