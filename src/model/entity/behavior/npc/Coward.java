package model.entity.behavior.npc;

import model.area.RadialArea;
import model.entity.Entity;
import model.entity.behavior.npc.defaultb.ListenForMovement;
import model.entity.behavior.npc.observe.CowardFromEntity;

public class Coward implements Behaviorable {
	private Boolean reset;
	private ListenForMovement listen;
	private CowardFromEntity cowardFromEntity;
	private Entity entityToCowardFrom;
	private Entity entity;

	public Coward(Boolean resetToContinuous, Entity entityToCowardFrom) {
		this.reset = resetToContinuous;
		this.entityToCowardFrom = entityToCowardFrom;
	}

	public void perform() {
		this.listen.perform();
	}

	public void observe() {
		this.cowardFromEntity.observe();
		if (this.cowardFromEntity.found()) {
			this.listen.push(this.cowardFromEntity.getMove());
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
		this.entity = entity;
		setStates();
	}

	public void setStates() {
		this.listen = new ListenForMovement(this.entity);
		this.cowardFromEntity = new CowardFromEntity(this.entity,
				this.entityToCowardFrom, new RadialArea(7,
						this.entity.getLocation()), this.reset);
		
	}

}
