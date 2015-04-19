package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.linear.SilenceProjectile;
import model.skillmanager.SummonerSkillManager;


public class Silence extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	private SilenceProjectile projectile = new SilenceProjectile();
	
	public Silence(SummonerSkillManager manager) {
		super(10);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public SilenceProjectile getProjectile(){
		return projectile;
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		this.getProjectile().setLevel(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}

}
