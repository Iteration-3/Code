package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class LivesModifierEvent extends Event {
	private int lives;

	public LivesModifierEvent(double duration, int lives) {
		super(duration);
		this.lives = lives;
	}

	public LivesModifierEvent(int lives, Entity target, double duration) {
		super(target, duration);
		this.lives = lives;
	}
	
	public LivesModifierEvent(StructuredMap map) {
		super(map);
		this.lives = map.getInteger("lives");
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addLives(lives);
		}
	}

	@Override
	public Event clone() {
		LivesModifierEvent clone = new LivesModifierEvent(lives, getTarget(), getDuration());
		return clone;
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("lives", lives);
		return map;
	}

	@Override
	protected String getType() {
		return "livesModifier";
	}

}
