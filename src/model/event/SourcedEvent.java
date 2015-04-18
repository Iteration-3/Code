package model.event;

import model.entity.Entity;

public abstract class SourcedEvent extends Event {
	private Entity source;
	
	public SourcedEvent(Entity source, Entity target, double duration) {
		super(target, duration);
		this.source = source;
	}
	
	public abstract void perform();
	
	public void setSource(Entity source) {
		this.source = source;
	}
	
	public Entity getSource() {
		return source;
	}

}
