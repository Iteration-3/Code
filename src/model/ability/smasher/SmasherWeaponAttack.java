package model.ability.smasher;

import model.ability.TriggerAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.HealthModifierEvent;
import model.skillmanager.SmasherSkillManager;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import model.trigger.TriggerManager;

public class SmasherWeaponAttack extends TriggerAbility {

	private long timeout = 0;
	private SmasherSkillManager manager;

	
	public SmasherWeaponAttack(SmasherSkillManager smasherSkillManager) {
		//DEPRECATED    dont call on getTrigger
		//  use Black Box Inheritance
		super();
		this.manager = smasherSkillManager;
	}



	@Override
	public void perform(Avatar avatar) {
		System.out.println("Was run");
		
		if (hasMana(avatar) && !isTimedOut()) {
			removeMana(avatar);
			double damageModifier = 1;
			if (avatar.hasTHW()) {
				int THWS = this.manager.getTwoHandedSkill()*100;
				this.setManaCost(THWS);
				damageModifier = THWS;
			} else if (avatar.hasOHW()) {
				int OHWS = this.manager.getOneHandedSkill()*50;
				this.setManaCost(OHWS);
				damageModifier = OHWS;
			}
			else{
				int BHWS = this.manager.getBrawlSkill()*30;
				this.setManaCost(BHWS);
				damageModifier = BHWS;
			}
			//removeMana(avatar);
			avatar.attackInFront(-(int)damageModifier);
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
	
	private TimedTrigger constructTrigger(Entity ent){
		return new TimedTrigger(new RadialArea(1, null),
				new HealthModifierEvent( ent , null, 0, -15), 0);
	}

}
