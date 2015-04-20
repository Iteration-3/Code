package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.area.GrowingConicalArea;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.linear.ShadowBlastProjectile;
import model.skillmanager.SummonerSkillManager;

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
		Event damageEvent = new HealthModifierEvent(ent, null, 0, -40*manager.getBaneSkill());
		return new ShadowBlastProjectile(ent.getLocation(), ent.getDirection(), new RadialArea(2, ent.getLocation()), damageEvent, 2.2);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
