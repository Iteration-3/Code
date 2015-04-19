package model.ability.sneak;

import factories.EventFactory;
import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.Event;
import model.event.EventManager;
import model.event.MovementModifierEvent;
import model.event.StatisticModifierEvent;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;

public class Creep extends SelfAbility {
	
	private MovementModifierEvent movementModifier = new MovementModifierEvent(25, -20);
	
	public Creep() {
		super(new StatisticModifierEvent(new Statistics(0, 75, 0, 0), 25), 75);
	}
	
	public Creep(int manaCost) {
		super();
		this.setManaCost(manaCost);
	}
	
	public Creep(StructuredMap map) {
		super(map);
		movementModifier = EventFactory.createMovementModifierEvent(map);
	}
	
	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			MovementModifierEvent movementModifier = this.movementModifier.clone();
			movementModifier.setTarget(avatar);
			Event statsModifier = this.getEvent().clone();
			statsModifier.setTarget(avatar);

			EventManager.getSingleton().addEvent(movementModifier);
			EventManager.getSingleton().addEvent(statsModifier);
		}
	}

	@Override
	protected String getType() {
		return "creep";
	}

}
