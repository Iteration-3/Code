package model.event;

import model.entity.Entity;

public abstract class Event implements Cloneable{
	private double duration;
	private Entity target;
	
	protected Event(double duration) {
		this.duration = duration;
	}
	
	public Event(Entity target, double duration) {
		this.target = target;
		this.duration = duration;
	}
	
	// Called by the event manager
	public void onBegin() {
		System.out.println("onBegin() called, NOT IMPLEMENTED");
	}

	// Called by the event manager
	public void onExpired() {
		System.out.println("onExpired() called, NOT IMPLEMENTED");
	}

	public abstract boolean hasExpired();
	
	public abstract void perform();
	
	public void setTarget(Entity target) {
		this.target = target;
	}
	
	protected Entity getTarget() {
		return target;
	}
	
	public double getDuration() {
		return duration;
	}
	
	protected boolean hasTarget() {
		return target != null;
	}
	/**
	 * UNIMPLEMENTED
	 */
	public Event clone(){
		return null;
		
	}
}
