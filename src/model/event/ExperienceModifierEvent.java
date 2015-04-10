package model.event;

import model.entity.Entity;

public class ExperienceModifierEvent extends Event {
	private int experience;

	protected ExperienceModifierEvent(Entity target, double duration, int experience) {
		super(target, duration);
		this.experience = experience;
	}

	@Override
	public boolean hasExpired() {
		return true; 
	}

	@Override
	public void perform() {
		if (hasTarget()) {
			getTarget().addExperience(experience);
		}
	}

	@Override
	public Event clone() {
		ExperienceModifierEvent clone = new ExperienceModifierEvent(getTarget(), getDuration(), experience);
		return clone;
	}


}