package model.ability.summoner.enchantment;

import model.ability.ProjectileAbility;
import model.area.RadialArea;
import model.entity.Avatar;
import model.entity.Entity;
import model.event.Event;
import model.event.ManaModifierEvent;
import model.projectile.linear.SilenceProjectile;
import model.skillmanager.SummonerSkillManager;


public class Silence extends ProjectileAbility {
	
	private SummonerSkillManager manager;
	
	public Silence(SummonerSkillManager manager) {
		super(10);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager() {
		return manager;
	}
	
	@Override
	public SilenceProjectile getProjectile(Entity ent) {
		Event damageEvent = new ManaModifierEvent(10*manager.getEnchantSkill(), -100*manager.getEnchantSkill());
		return new SilenceProjectile(ent.getLocation(), ent.getDirection(), new RadialArea(1, ent.getLocation()), damageEvent, 2.2);
	}

	@Override
	public void perform(Avatar avatar){
		this.setManaCost(this.getSkillManager().getEnchantSkill());
		super.perform(avatar);
	}

}
