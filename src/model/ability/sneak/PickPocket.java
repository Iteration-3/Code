package model.ability.sneak;

import model.ability.TriggerAbility;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.event.PickPocketEvent;
import model.skillmanager.SneakSkillManager;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Direction;

public class PickPocket extends TriggerAbility {
	
	private SneakSkillManager manager;
	
	public PickPocket(SneakSkillManager sneakSkillManager) {
		super();
		TimedTrigger trigger = new TimedTrigger();
		trigger.setEvent(new PickPocketEvent());
		trigger.setDuration(0);
		trigger.setArea(new RadialArea(1, null));
		this.setTrigger(trigger);
		this.setManaCost(10);
		this.manager = sneakSkillManager;
	}
	
	

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			if (this.getTrigger() != null) {
				Trigger trigger = this.getTrigger().clone();

				TileCoordinate avatarLocation = avatar.getLocation();
				Direction avatarDirection = avatar.getDirection();
				TileCoordinate triggerLocation = avatarLocation.nextLocation(avatarDirection);
				trigger.moveLocation(triggerLocation);
				((PickPocketEvent)trigger.getEvent()).setSource(avatar);
				
				TriggerManager.getSingleton().addNonPartyTrigger(trigger);
			}
		}
	}


}
