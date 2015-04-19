package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.linear.ShadowBlastProjectile;
import model.skillmanager.SummonerSkillManager;

public final class ShadowBlast extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	private ShadowBlastProjectile projectile = new ShadowBlastProjectile();


	public ShadowBlast(SummonerSkillManager manager) {
		super(50);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public ShadowBlastProjectile getProjectile(){
		return projectile;
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		this.getProjectile().setLevel(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
