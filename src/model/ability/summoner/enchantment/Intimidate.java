package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.StatisticModifierEvent;
import model.projectile.conical.IntimidateConeProjectile;
import model.skillmanager.SummonerSkillManager;
import model.statistics.Statistics;
import model.trigger.SingleUseTrigger;

public class Intimidate extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public Intimidate(SummonerSkillManager manager) {
		super(15);
		this.manager=manager;
	}
	

	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public IntimidateConeProjectile getProjectile(Entity ent) {

		Event damageEvent = new StatisticModifierEvent(new Statistics(-20*manager.getEnchantSkill(), 0, 0, 0), 5*manager.getEnchantSkill());
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);

		return new IntimidateConeProjectile(ent.getLocation(), ent.getDirection(), damageTrigger, 1.0);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}
	
}
