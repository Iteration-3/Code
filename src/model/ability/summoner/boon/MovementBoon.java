package model.ability.summoner.boon;

import model.ability.SelfAbility;
import model.entity.Avatar;
import model.event.TemporaryMovementModifierEvent;
import model.skillmanager.SummonerSkillManager;

public class MovementBoon extends SelfAbility {
	
	private TemporaryMovementModifierEvent event= new TemporaryMovementModifierEvent(defaultDuration, defaultMovement);
	private SummonerSkillManager manager;
	final static private int defaultDuration = 3;
	final static private int defaultMovement = 5;
	
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
