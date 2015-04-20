package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.area.GrowingConicalArea;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.conical.LightConeProjectile;
import model.skillmanager.SummonerSkillManager;
import model.trigger.SingleUseTrigger;

public final class LightBeam extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public LightBeam(SummonerSkillManager manager) {
		super(20);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public LightConeProjectile getProjectile(Entity ent){
		System.out.println("ONCE");
		Event damageEvent = new HealthModifierEvent(ent, null, 0, -15*manager.getBaneSkill());

		return new LightConeProjectile(ent.getLocation(), ent.getDirection(), new GrowingConicalArea(ent.getLocation(), ent.getDirection(), 10), damageEvent, 2.2);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
