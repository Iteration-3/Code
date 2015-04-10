package model.event;

import model.entity.Entity;

public class LivesModifierEvent extends Event {
	private int lives;

	public LivesModifierEvent(double duration, int lives) {
		super(duration);
		this.lives = lives;
	}

	public LivesModifierEvent(Entity target, double duration, int lives) {
		super(target, duration);
		this.lives = lives;
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addLives(lives);
		}
	}

	@Override
	public Event clone() {
		LivesModifierEvent clone = new LivesModifierEvent(getTarget(), getDuration(), lives);
		return clone;
	}

}
