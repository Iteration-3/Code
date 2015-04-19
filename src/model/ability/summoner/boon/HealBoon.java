package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.HealthModifierEvent;
import model.skillmanager.SummonerSkillManager;

public final class HealBoon extends SelfAbility {
	
	private HealthModifierEvent event= new HealthModifierEvent(defaultDuration, defaultHealth);
	private SummonerSkillManager manager;
	final static private int defaultDuration = 5;
	final static private int defaultHealth = 5;
	
	
	public HealBoon(SummonerSkillManager manager) {
		super(null, 10);
		this.setEvent(event);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	@Override
	public void perform(Avatar avatar){
		event.setDuration(defaultDuration *this.getSkillManager().getBoonSkill());
		this.setManaCost(this.getSkillManager().getBoonSkill());
		super.perform(avatar);
	}

}
