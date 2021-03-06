package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.MovementModifierEvent;
import model.projectile.linear.CripplingProjectile;
import model.skillmanager.SummonerSkillManager;

public class Cripple extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public Cripple(SummonerSkillManager manager) {
		super(15);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public CripplingProjectile getProjectile(Entity ent) {
		Event damageEvent = new MovementModifierEvent(5*manager.getEnchantSkill(), -20*manager.getEnchantSkill());
		return new CripplingProjectile(ent.getLocation(), ent.getDirection(), new RadialArea(1, ent.getLocation()), damageEvent, 2.2);
	}
	
	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}

}
