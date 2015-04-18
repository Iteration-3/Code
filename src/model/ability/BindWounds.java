package model.ability;

import model.entity.Avatar;
import model.event.Event;
import model.event.HealthModifierEvent;
import utilities.structuredmap.StructuredMap;
import factories.EventFactory;

public class BindWounds extends SelfAbility {
	private Event event;
	
	public BindWounds() {
		super(new HealthModifierEvent(5, 1), 5);
	}
	
	public BindWounds(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}
	
	public BindWounds(StructuredMap map) {
		super(map);
		this.event = EventFactory.createEvent(map.getStructuredMap("healthEvent"));
	}
	
	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			HealthModifierEvent event = (HealthModifierEvent) this.event.clone();
			event.setTarget(avatar);
			event.scaleHealh(avatar.getBindWoundSkill());
			event.placeOnEventManager();
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("healthEvent", event.getStructuredMap());
		return map;
	}

	@Override
	protected String getType() {
		return "bindWounds";
	}

}
