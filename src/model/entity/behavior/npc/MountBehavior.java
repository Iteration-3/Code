package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.MountInteract;

public class MountBehavior implements Behaviorable {
	private Entity chosen;
	private MountInteract interact;
	
	public MountBehavior(){
		
	}

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
		interact = new MountInteract(this.chosen);
	}

}
