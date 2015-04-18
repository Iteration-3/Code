package model.ability.sneak;

import java.util.Collection;

import model.ability.Ability;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;

public class RemoveTrap extends Ability {
	
	public RemoveTrap() {
		super(10);
	}

	@Override
	public void perform(Avatar avatar) {
		// TODO(jraviles) fix this up
		if (hasMana(avatar)) {
			TileCoordinate avatarLocation = avatar.getLocation();
			Angle avatarDirection = avatar.getDirection();
			TileCoordinate nextLocation = avatarLocation.nextLocation(avatarDirection);
		
			// Assuming all traps are triggers, ask JR for the deets
			Collection<Trigger> triggers = TriggerManager.getSingleton().getNonPartyTriggers();
			triggers.addAll(TriggerManager.getSingleton().getNeutralTriggers());
		
			for (Trigger trigger : triggers) {
				if (trigger.getArea().getStartLocation().equals(nextLocation)) {
					removeMana(avatar);
					TriggerManager.getSingleton().removeTrigger(trigger);
					break;
				}
			}
		}
	}

	@Override
	protected String getType() {
		return "removeTrap";
	}

}
