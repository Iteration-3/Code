package model.event;

import model.entity.Entity;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class Event implements Cloneable, Saveable{

	private final double CREATION_TIME = System.currentTimeMillis() / 1000.0;
	
	private double duration;
	private Entity target;
	
	protected Event(double duration) {
		this.duration = duration;

	}
	
	public Event(Entity target, double duration) {
		this.target = target;
		this.duration = duration;
	}
	
	public Event(StructuredMap map) {
		this.duration = map.getDouble("duration");
	}
	
	// Called by the event manager
	public void onBegin() {
		// System.out.println("onBegin() called, NOT IMPLEMENTED");
	}

	// Called by the event manager
	public void onExpired() {
		// System.out.println("onExpired() called, NOT IMPLEMENTED");
	}

	public final boolean hasExpired() {
		final double CURRENT_TIME = System.currentTimeMillis() / 1000.0;
		final double DELTA_TIME = CURRENT_TIME - CREATION_TIME;
		return (duration < DELTA_TIME);
	}
	
	public final void placeOnEventManager() {
		EventManager.getSingleton().addEvent(this);
	}
	
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
	
	public void setDuration(double duration) {
		this.duration = duration;
	}
	
	protected boolean hasTarget() {
		return target != null;
	}

	public abstract Event clone();
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("duration", duration);
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();
		
}
