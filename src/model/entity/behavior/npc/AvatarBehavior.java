package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.behavior.npc.interact.PreferToBeInteracted;

public class AvatarBehavior implements Behaviorable {
	private PreferToBeInteracted interact;
	private Entity chosen;

	public AvatarBehavior() {
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
	}

	@Override
	public void setStates() {
		this.interact = new PreferToBeInteracted(this.chosen);
	}

}
