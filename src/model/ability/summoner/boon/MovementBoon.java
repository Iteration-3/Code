package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.MovementModifierEvent;
import model.skillmanager.SummonerSkillManager;

public class MovementBoon extends SelfAbility {
	
	private MovementModifierEvent event= new MovementModifierEvent(defaultDuration, defaultHealth);
	private SummonerSkillManager manager;
	final static private int defaultDuration = 7;
	final static private int defaultHealth = 50;
	
	public MovementBoon(SummonerSkillManager manager) {
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
