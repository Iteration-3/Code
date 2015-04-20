package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.linear.SilenceProjectile;
import model.skillmanager.SummonerSkillManager;
import model.trigger.SingleUseTrigger;


public class Silence extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public Silence(SummonerSkillManager manager) {
		super(10);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager() {
		return manager;
	}
	
	@Override
	public SilenceProjectile getProjectile(Entity ent) {
		Event damageEvent = new ManaModifierEvent(10*manager.getEnchantSkill(), -100*manager.getEnchantSkill());
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		return new SilenceProjectile(ent.getLocation(), ent.getDirection(), damageTrigger, 1.0);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}

}
