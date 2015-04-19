package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.defaultb.Pursue;
import model.entity.behavior.npc.observe.TargetAvatar;

public class PursueAvatar implements Behaviorable {
	private Entity chosenOne;
	private Pursue pursue;
	private TargetAvatar targetAvatar;
	
	public PursueAvatar(){}

	public void perform() {
		this.pursue.perform();
	}

	public void observe() {
		this.targetAvatar.observe();
		if (this.targetAvatar.found()){
			this.pursue.push(this.targetAvatar.getMove());
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
		this.targetAvatar = new TargetAvatar(this.chosenOne,7);
	}

}
