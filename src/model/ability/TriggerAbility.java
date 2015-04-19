package model.ability;

import factories.TriggerFactory;
import model.area.TileCoordinate;
import model.entity.Avatar;
import model.trigger.Trigger;
import model.trigger.TriggerManager;
import utilities.Angle;
import utilities.structuredmap.StructuredMap;

public abstract class TriggerAbility extends Ability {
	private Trigger trigger;
	
	public TriggerAbility() {
		super();
	}
	
	public TriggerAbility(Trigger trigger, int manaCost) {
		super(manaCost);
		this.setTrigger(trigger);
	}
	
	public TriggerAbility(StructuredMap map) {
		super(map);
		this.trigger = TriggerFactory.createTrigger(map);
	}
	
	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar)) {
			removeMana(avatar);
			if (this.trigger != null) {
				Trigger trigger = this.trigger.clone();

				TileCoordinate avatarLocation = avatar.getLocation();
				Angle avatarDirection = avatar.getDirection();
				TileCoordinate triggerLocation = avatarLocation.nextLocation(avatarDirection);
				trigger.moveLocation(triggerLocation);
				
				TriggerManager.getSingleton().addNonPartyTrigger(trigger);
			}
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("trigger", trigger.getStructuredMap());
		return map;
	}
	
	public final void setTrigger(Trigger trigger) {
		this.trigger = trigger;
	}
	
	public final Trigger getTrigger() {
		return this.trigger;
	}

}
