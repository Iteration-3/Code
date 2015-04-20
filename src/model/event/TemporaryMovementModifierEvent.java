package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class TemporaryMovementModifierEvent extends Event {
	private int movement;
	private int oldMovementSpeed = 1;

	public TemporaryMovementModifierEvent(double duration, int movement) {
		super(duration);
		System.out.println("1: " + movement);
		this.movement = movement;
	}

	public TemporaryMovementModifierEvent(int movement, Entity target, double duration) {
		super(target, duration);
		this.movement = movement;
		System.out.println("2: " + movement);
	}
	
	public TemporaryMovementModifierEvent(StructuredMap map) {
		super(map);
		this.oldMovementSpeed = map.getInteger("oldMovementSpeed");
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("oldMovementSpeed", oldMovementSpeed);
		return map;
	}

	@Override
	public void perform() {
		//Do nothing.
	}

	@Override
	public void onBegin() {

		if(this.hasTarget()){
			oldMovementSpeed = this.getTarget().getDerivedStats().getMovement();
			this.getTarget().addMovement(movement);
			System.out.println(movement);
		}
	}

	@Override
	public void onExpired() {
		if(this.hasTarget()){
			this.getTarget().setMovement(oldMovementSpeed);
		}
	}


	@Override
	public TemporaryMovementModifierEvent clone() {
		TemporaryMovementModifierEvent clone 
		= new TemporaryMovementModifierEvent(movement, getTarget(), getDuration());
		return clone;
	}

	@Override
	protected String getType() {
		return "tempMovementEvent";
	}


}
