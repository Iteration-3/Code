package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.Barter;

public class BarterBehavior implements Behaviorable{
	private Entity chosen;
	private Barter interact;
	
	public BarterBehavior(){}

	@Override
	public void perform(double deltaTime) {
	}

	@Override
	public void observe(double deltaTime) {
	}

	@Override
	public void interact(Entity entity) {
		this.interact.interact(entity);
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
		this.chosen = entity;
		this.setStates();
	}

	@Override
	public void setStates() {
		this.interact = new Barter(this.chosen);
	}
	
	

}
