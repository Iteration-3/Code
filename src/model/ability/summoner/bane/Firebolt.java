package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.HealthModifierEvent;
import model.projectile.linear.FireProjectile;
import model.skillmanager.SummonerSkillManager;

public final class Firebolt extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public Firebolt(SummonerSkillManager manager) {
		super(10);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager() {
		return manager;
	}
	
	@Override
	public FireProjectile getProjectile(Entity ent) {
		Event damageEvent = new HealthModifierEvent(ent, null, 0, -10*manager.getBaneSkill());
		return new FireProjectile(ent.getLocation(), ent.getDirection(), new RadialArea(1, null), damageEvent, 2.2);
	}

	@Override
	public void perform(Avatar avatar) {
		this.setManaCost(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
