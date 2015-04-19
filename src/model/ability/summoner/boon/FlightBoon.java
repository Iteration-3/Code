package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.FlightEvent;
import model.skillmanager.SummonerSkillManager;

public class FlightBoon extends SelfAbility{
	final static int defaultDuration = 10;//Instead of constants for now. 
	final static int defaultManaCost = 15;
	
	private FlightEvent event= new FlightEvent(defaultDuration);
	private SummonerSkillManager manager;
	
	
	
	public FlightBoon(SummonerSkillManager manager){
		super(null,defaultManaCost);
		this.setEvent(event);
		this.manager = manager;
	}
	
	protected SummonerSkillManager getSkillManager(){
		return manager;
	}
	
	
	@Override
	public void perform(Avatar avatar){
		event.setDuration(defaultDuration*this.getSkillManager().getBoonSkill());
		this.setManaCost(this.getSkillManager().getBoonSkill());
		if(avatar.isFlying()){return;}//You can't fly while flying!
		super.perform(avatar);
	}


}
