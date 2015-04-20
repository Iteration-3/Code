package model.ability;

import model.area.TileCoordinate;
import model.entity.Avatar;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Direction;

public abstract class TriggerAbility extends Ability {
	private Trigger trigger;
	
	public TriggerAbility() {
		super();
	}
	
	public TriggerAbility(Trigger trigger, int manaCost) {
		super(manaCost);
		this.setTrigger(trigger);
	}
	
	
	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			if (this.trigger != null) {
				Trigger trigger = this.trigger.clone();

				TileCoordinate avatarLocation = avatar.getLocation();
				Direction avatarDirection = avatar.getDirection();
				TileCoordinate triggerLocation = avatarLocation.nextLocation(avatarDirection);
				trigger.moveLocation(triggerLocation);
				
				TriggerManager.getSingleton().addNonPartyTrigger(trigger);
			}
		}
	}
	

	public final void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	
	public final Trigger getTrigger() {
		return this.trigger;
	}

}
