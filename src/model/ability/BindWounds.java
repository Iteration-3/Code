package model.ability;

import model.entity.Avatar;
import model.event.HealthModifierEvent;
import model.skillmanager.SkillManager;

public class BindWounds extends SelfAbility {
	private HealthModifierEvent event;
	private SkillManager manager;
	
	public BindWounds(SkillManager manager) {
		super();
		event = new HealthModifierEvent(null,null,5, 1);
		this.setManaCost(5);
		this.setEvent(event);
		this.manager = manager;
	}
	
	protected SkillManager getManager(){
		return manager;
	}

	

	
	
	@Override
	public void perform(Avatar avatar) {
		this.setManaCost(this.getManager().getBindWoundsSkill());
		if (hasMana(avatar)) {
			removeMana(avatar);
			HealthModifierEvent event =  this.event.clone();
			event.setTarget(avatar);
			event.scaleHealth(this.getManager().getBindWoundsSkill());
			event.placeOnEventManager();
		}
	}
	

}
