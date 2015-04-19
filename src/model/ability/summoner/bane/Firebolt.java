package model.ability.summoner.bane;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.linear.FireProjectile;
import model.skillmanager.SummonerSkillManager;

public final class Firebolt extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	private FireProjectile projectile = new FireProjectile();
	
	public Firebolt(SummonerSkillManager manager) {
		super(10);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public FireProjectile getProjectile(){
		return projectile;
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getBaneSkill());
		this.getProjectile().setLevel(this.getSkillManager().getBaneSkill());
		super.perform(avatar);
	}
}
