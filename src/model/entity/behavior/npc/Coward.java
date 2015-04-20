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

	@Override
	public void perform(double deltaTime) {
		this.listen.perform();
	}

	@Override
	public void observe(double deltaTime) {
		this.cowardFromEntity.observe();
		if (this.cowardFromEntity.found()) {
			this.listen.push(this.cowardFromEntity.getMove());
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
		this.entity = entity;
		setStates();
	}

	@Override
	public void setStates() {
		this.listen = new ListenForMovement(this.entity);
		this.cowardFromEntity = new CowardFromEntity(this.entity,
				this.entityToCowardFrom, new RadialArea(7,
						this.entity.getLocation()), this.reset);
		
	}

}
