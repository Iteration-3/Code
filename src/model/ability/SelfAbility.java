package model.ability;

import factories.EventFactory;
import utilities.structuredmap.StructuredMap;
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

	public SelfAbility(StructuredMap map) {
		super(map);
		this.event = EventFactory.createEvent(map.getStructuredMap("event"));
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
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("event", event.getStructuredMap());
		return map;
	}

}
