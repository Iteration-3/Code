package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.linear.ShadowBlastProjectile;
import model.skillmanager.SummonerSkillManager;
import model.trigger.SingleUseTrigger;

public final class ShadowBlast extends ProjectileAbility {
	
	private SummonerSkillManager manager;


	public ShadowBlast(SummonerSkillManager manager) {
		super(50);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public ShadowBlastProjectile getProjectile(Entity ent) {
		Event damageEvent = new HealthModifierEvent(0, -40*manager.getBaneSkill());
		SingleUseTrigger damageTrigger = new SingleUseTrigger(new RadialArea(1, null), damageEvent);
		
		return new ShadowBlastProjectile(ent.getLocation(), ent.getDirection(), damageTrigger, 1.0);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
