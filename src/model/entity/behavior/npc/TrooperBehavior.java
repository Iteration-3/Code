package model.entity.behavior.npc;

import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.LinkAndInteract;
import model.entity.behavior.npc.interact.AttackInteract;

public class TrooperBehavior implements Behaviorable {
	private Entity chosen;
	private AttackInteract interact;
	private LinkAndInteract perform;

	public void perform(double deltaTime) {
		this.perform.perform();
	}

	public void observe(double deltaTime) {
	}

	public void interact(Entity entity) {
		interact.interact(entity);
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
		this.interact = new AttackInteract(this.chosen);
		this.perform = new LinkAndInteract(this.chosen,EntityManager.getSingleton().getAvatar());
	}

}
