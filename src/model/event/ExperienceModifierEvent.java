package model.event;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;

public class ExperienceModifierEvent extends Event {
	private int experience;

	protected ExperienceModifierEvent(Entity target, double duration, int experience) {
		super(target, duration);
		this.experience = experience;
	}
	
	public ExperienceModifierEvent(double duration, int experience) {
		super(duration);
		this.experience= experience;
	}
	
	public ExperienceModifierEvent(StructuredMap map) {
		super(map);
		this.experience = map.getInteger("experience");
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
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("experience", experience);
		return map;
	}

	@Override
	protected String getType() {
		return "experienceModifier";
	}


}
