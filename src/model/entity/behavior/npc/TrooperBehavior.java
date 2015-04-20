package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.LinkAndInteract;
import model.entity.behavior.npc.interact.AttackInteract;

public class TrooperBehavior implements Behaviorable {
	private Entity chosen;
	private AttackInteract interact;
	private LinkAndInteract perform;

	@Override
	public void perform(double deltaTime) {
		this.perform.perform();
	}

	@Override
	public void observe(double deltaTime) {
	}

	@Override
	public void interact(Entity entity) {
		interact.interact(entity);
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
		this.interact = new AttackInteract(this.chosen);
		this.perform = new LinkAndInteract(this.chosen,EntityManager.getSingleton().getAvatar());
	}

}
