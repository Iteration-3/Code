package model.event;

import model.entity.Entity;

public class SourcedEvent extends Event {
	private Entity source;
	private Entity target;
	
	public SourcedEvent(Entity source, Entity target, double duration) {
		super(duration);
		this.source = source;
		this.target = target;
	}

	@Override
	public void onBegin() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onExpired() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean hasExpired() {
		return false;
		// TODO Auto-generated method stub

	}

	@Override
	public void perform() {
		// An example would be PickPocket.
		// Taking one Item from the target's Inventory 
		// and adding it into the Source's Inventory
	}

	@Override
	public void setTarget(Entity target) {
		// TODO Auto-generated method stub

	}

}
