package model.ability.sneak;

import model.ability.TriggerAbility;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.event.PickPocketEvent;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;

public class PickPocket extends TriggerAbility {
	
	public PickPocket() {
		super();
		TimedTrigger trigger = new TimedTrigger();
		trigger.setEvent(new PickPocketEvent());
		trigger.setDuration(0);
		trigger.setArea(new RadialArea(1, null));
		this.setManaCost(10);
	}
	
	public PickPocket(int manaCost) {
		this();
		this.setManaCost(manaCost);
	}

	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			if (this.getTrigger() != null) {
				Trigger trigger = this.getTrigger().clone();

				TileCoordinate avatarLocation = avatar.getLocation();
				Angle avatarDirection = avatar.getDirection();
				TileCoordinate triggerLocation = avatarLocation.nextLocation(avatarDirection);
				trigger.moveLocation(triggerLocation);
				((PickPocketEvent)trigger.getEvent()).setSource(avatar);
				
				TriggerManager.getSingleton().addNonPartyTrigger(trigger);
			}
		}
	}

}
