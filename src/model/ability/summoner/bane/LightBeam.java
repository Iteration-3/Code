package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.conical.LightConeProjectile;
import model.skillmanager.SummonerSkillManager;

public final class LightBeam extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	private LightConeProjectile projectile = new LightConeProjectile();
	
	public LightBeam(SummonerSkillManager manager) {
		super(20);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public LightConeProjectile getProjectile(){
		return projectile;
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		this.getProjectile().setLevel(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
