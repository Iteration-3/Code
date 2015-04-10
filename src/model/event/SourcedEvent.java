package model.event;

import model.entity.Entity;

public abstract class SourcedEvent extends Event {
	private Entity source;
	
	public SourcedEvent(Entity source, Entity target, double duration) {
		super(target, duration);
		this.source = source;
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public void perform() {
		// An example would be PickPocket.
		// Taking one Item from the target's Inventory 
		// and adding it into the Source's Inventory
	}

}
