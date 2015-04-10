package model.event;

import model.entity.Entity;

public class ExperienceModifierEvent extends Event {
	private int experience;

	protected ExperienceModifierEvent(double duration, Entity target, int experience) {
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


}
