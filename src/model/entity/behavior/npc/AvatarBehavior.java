package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.PreferToBeInteracted;

public class AvatarBehavior implements Behaviorable {
	private PreferToBeInteracted interact;
	private Entity chosen;

	public AvatarBehavior() {
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
	}

	public void setStates() {
		this.interact = new PreferToBeInteracted(this.chosen);
	}

}
