package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.conical.IntimidateConeProjectile;
import model.skillmanager.SummonerSkillManager;

public class Intimidate extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	private IntimidateConeProjectile projectile = new IntimidateConeProjectile();
	
	public Intimidate(SummonerSkillManager manager) {
		super(15);
		this.manager=manager;
	}
	

	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public IntimidateConeProjectile getProjectile(){
		return projectile;
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		this.getProjectile().setLevel(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}
	
}
