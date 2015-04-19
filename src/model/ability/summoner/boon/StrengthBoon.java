package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.StatisticModifierEvent;
import model.skillmanager.SummonerSkillManager;
import model.statistics.Statistics;

public class StrengthBoon extends SelfAbility {
	
	private StatisticModifierEvent event= new StatisticModifierEvent(new Statistics(25, 0, 0, 0), 10);
	private SummonerSkillManager manager;
	final static private int defaultDuration = 10;
	
	public StrengthBoon(SummonerSkillManager manager) {
		super(null, 15);
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
