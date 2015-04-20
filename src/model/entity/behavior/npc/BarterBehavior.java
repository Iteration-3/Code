package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.Barter;

public class BarterBehavior implements Behaviorable{
	private Entity chosen;
	private Barter interact;
	
	public BarterBehavior(){}

	public void perform() {
	}

	public void observe() {
	}

	public void interact(Entity entity) {
		this.interact.interact(entity);
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
		this.chosen = entity;
		this.setStates();
	}

	public void setStates() {
		this.interact = new Barter(this.chosen);
	}
	
	

}
