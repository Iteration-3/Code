package model.ability;

import model.entity.Avatar;
import model.event.Event;
import model.event.HealthModifierEvent;

public abstract class SelfAbility extends Ability {
	private Event event;
	
	public SelfAbility() {
		super();
		this.event = new HealthModifierEvent(5, 5);
	}
	
	public SelfAbility(Event event, int manaCost) {
		super(manaCost);
		setEvent(event);
	}


	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			Event event = this.event.clone();
			event.setTarget(avatar);
			event.placeOnEventManager();
		}
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
	

}
