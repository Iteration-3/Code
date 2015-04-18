package model.ability;

import model.entity.Avatar;
import model.event.HealthModifierEvent;

public class BindWounds extends SelfAbility {
	private HealthModifierEvent event;
	
	public BindWounds() {
		super(new HealthModifierEvent(5, 1), 5);
	}
	
	public BindWounds(int manaCost) {
		this();
		this.setManaCost(manaCost);
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

}
