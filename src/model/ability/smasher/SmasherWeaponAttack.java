package model.ability.smasher;

import model.ability.TriggerAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.event.HealthModifierEvent;
import model.skillmanager.SmasherSkillManager;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;

public class SmasherWeaponAttack extends TriggerAbility {

	private long timeout = 0;
	private SmasherSkillManager manager;

	
	public SmasherWeaponAttack(SmasherSkillManager smasherSkillManager) {
		super(new TimedTrigger(new RadialArea(1, null),
				new HealthModifierEvent(0, -15), 0), 10);
		this.manager = smasherSkillManager;
	}



	@Override
	public void perform(Avatar avatar) {
		if (hasMana(avatar) && !isTimedOut()) {
			removeMana(avatar);
			double damageModifier = 1;
			int timeOutDur = 1;
			if (avatar.hasTHW()) {
				timeOutDur = 4;
				damageModifier = 4;
			} else if (avatar.hasOHW()) {
				timeOutDur = 2;
				damageModifier = 2;
			}
			Trigger trigger = this.getTrigger().clone();
			trigger.moveLocation(avatar.nextLocation());
			((HealthModifierEvent) trigger.getEvent())
					.scaleHealh(damageModifier);
			TriggerManager.getSingleton().addNonPartyTrigger(trigger);
			this.timeOut(timeOutDur);
		}
	}

	private boolean isTimedOut() {
		return System.currentTimeMillis() * 1000 < getTimeout();
	}

	private void timeOut(int duration) {
		this.timeout = System.currentTimeMillis() * 1000 + duration;
	}

	private long getTimeout() {
		return timeout;
	}

}
