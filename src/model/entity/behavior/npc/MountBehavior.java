package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.MountInteract;

public class MountBehavior implements Behaviorable {
	private Entity chosen;
	private MountInteract interact;
	
	public MountBehavior(){
		
	}

	public void perform(double deltaTime) {
	}

	public void observe(double deltaTime) {
	}

	public void interact(Entity entity) {
		this.interact.interact(entity);
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
		this.chosen = entity;
		this.setStates();
	}

	public void setStates() {
		interact = new MountInteract(this.chosen);
	}

}
