package model.entity.behavior.npc;

import model.area.RadialArea;
import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.behavior.npc.defaultb.ListenForMovement;
import model.entity.behavior.npc.observe.TargetEntity;

public class Pursue implements Behaviorable {
	private Entity chosenOne;
	private ListenForMovement pursue;
	private TargetEntity targetEntity;
	private Boolean reset;

	public Pursue(Boolean continuousAreaReset) {
		this.reset = continuousAreaReset;
	}

	@Override
	public void perform(double deltaTime) {
		this.pursue.perform();
	}

	@Override
	public void observe(double deltaTime) {
		this.targetEntity.observe();
		if (this.targetEntity.found()) {
			this.pursue.push(this.targetEntity.getMove());
		}
	}

	@Override
	public void interact(Entity entity) {
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
		this.chosenOne = entity;
		this.setStates();
	}

	@Override
	public void setStates() {
		this.pursue = new ListenForMovement(this.chosenOne);
		this.targetEntity = new TargetEntity(this.chosenOne, EntityManager
				.getSingleton().getAvatar(), new RadialArea(7,
				this.chosenOne.getLocation()), this.reset);
	}

}
