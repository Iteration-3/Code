package model.event;

import model.entity.Entity;

public abstract class UnsourcedEvent extends Event {
	private Entity target;
	
	public UnsourcedEvent(Entity target, double duration) {
		super(duration);
		this.target = target;
	}
	
	public UnsourcedEvent(double duration) {
		super(duration);
	}
	
	@Override
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	@Override
	public void onBegin() {
		System.out.println("I've began: " + this);
	}
	
	@Override
	public void onExpired() {
		System.out.println("I've ended: " + this);
	}

}
