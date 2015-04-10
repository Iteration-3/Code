package model.event;

import model.entity.Entity;

public abstract class Event {
	private double duration;
	
	protected Event(double duration) {
		this.duration = duration;
	}
	
	public abstract void onBegin(); // Called by the event manager

	public abstract void onExpired(); // Called by the event manager

	public abstract boolean hasExpired();
	
	public abstract void perform();
	
	public abstract void setTarget(Entity target);
	
	public double getDuration() {
		return duration;
	}
}
