package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.Pursue;
import model.entity.behavior.npc.observe.TargetEntity;

public class PursueAvatar implements Behaviorable {
	private Entity chosenOne;
	private Pursue pursue;
	private TargetEntity targetEntity;
	
	public PursueAvatar(){}

	public void perform() {
		this.pursue.perform();
	}

	public void observe() {
		this.targetEntity.observe();
		if (this.targetEntity.found()){
			this.pursue.push(this.targetEntity.getMove());
		}
	}

	public void interact(Entity entity) {
	}

	public void onDamage() {
	}

	public boolean isExpired() {
		return false;
	}

	public void onExit() {
	}

	public void onEnter() {
	}

	public void setEntity(Entity entity) {
		this.chosenOne = entity;
		this.setStates();
	}

	public void setStates() {
		this.pursue = new Pursue(this.chosenOne);
		this.targetEntity = new TargetEntity(this.chosenOne,7,EntityManager.getSingleton().getAvatar());
	}

}
