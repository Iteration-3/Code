package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.entity.Avatar;
import model.projectile.linear.CripplingProjectile;
import model.skillmanager.SummonerSkillManager;

public class Cripple extends ProjectileAbility {
	private SummonerSkillManager manager;
	private CripplingProjectile projectile = new CripplingProjectile();
	
	public Cripple(SummonerSkillManager manager) {
		super(15);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public CripplingProjectile getProjectile(){
		return projectile;
	}
	
	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		this.getProjectile().setLevel(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}

}
