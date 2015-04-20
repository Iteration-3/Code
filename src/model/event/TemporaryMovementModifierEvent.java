package model.event;

import utilities.structuredmap.StructuredMap;
import model.entity.Entity;

public class TemporaryMovementModifierEvent extends Event {
	private int movement;

	public TemporaryMovementModifierEvent(double duration, int movement) {
		super(duration);
		this.movement = movement;
	}

	public TemporaryMovementModifierEvent(int movement, Entity target, double duration) {
		super(target, duration);
		this.movement = movement;
	}
	
	public TemporaryMovementModifierEvent(StructuredMap map) {
		super(map);
		this.movement = map.getInteger("movement");
	}

	@Override
	public void perform() {
		//Do nothing.
	}

	private int oldMovementSpeed = 1;

	@Override
	public void onBegin() {

		if(this.hasTarget()){
			oldMovementSpeed = this.getTarget().getDerivedStats().getMovement();
			this.getTarget().addMovement(movement);
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
		return "Tempmovementevent";
	}


}
