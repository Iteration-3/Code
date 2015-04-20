package model.ability.sneak;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.entity.Sneak;
import model.event.Event;
import model.event.EventManager;
import model.event.InvisiblityEvent;
import model.event.TemporaryMovementModifierEvent;
import model.skillmanager.SneakSkillManager;

public class Creep extends SelfAbility {
	
	private TemporaryMovementModifierEvent movementModifier = new TemporaryMovementModifierEvent(25, -20);
	private SneakSkillManager manager;
	private Sneak sneak;
	
	public Creep(SneakSkillManager sneakSkillManager,Sneak sneak) {
		super();
		this.setEvent(new InvisiblityEvent(7, sneak));
		this.manager = sneakSkillManager;
		this.sneak = sneak;
	}
	
	
	@Override
	public void perform(Avatar avatar) {
		this.setManaCost(this.manager.getCreepskill());
		
		//Set Duration for BOTH events.
		int duration = this.manager.getCreepskill()*2; //Stupid way to get mana cost, but whatever.
		this.movementModifier.setDuration(duration);
		this.getEvent().setDuration(duration);
		if (hasMana(avatar) && !avatar.getEntityView().getHidden()) {
			removeMana(avatar);
			
			//Clone & add event stuff
			TemporaryMovementModifierEvent movementModifier = this.movementModifier.clone();
			Event event = this.getEvent().clone();
			event.setTarget(avatar);
			movementModifier.setTarget(avatar);
			
			
			movementModifier.setTarget(avatar);
			EventManager.getSingleton().addEvent(movementModifier);
			EventManager.getSingleton().addEvent(event);
		}
	}


}
