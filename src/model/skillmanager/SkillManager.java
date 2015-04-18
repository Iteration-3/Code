package model.skillmanager;

import utilities.structuredmap.Saveable;

public abstract class SkillManager implements Saveable {

	private int skillPointsToSpend = 0;
	private int attackSkill = 1;
	private int bindWoundSkill = 1;
	private int observeSkill = 1;
	private int barterSkill = 1;
	
	public int getBarterSkill(){
		return barterSkill;
	}
	
	public int getObserveSkill(){
		return observeSkill;
	}
	
	public int getBindWoundsSkill(){
		return bindWoundSkill;
	}
	
	public int getAttackSkill(){
		return attackSkill;
	}
	
	public void incrementAttack(){
		++attackSkill;
	}

	public void incrementBindWound(){
		++bindWoundSkill;
	}

	public void incrementObserve(){
		++observeSkill;
	}

	public void incrementBarter(){
		++barterSkill;
	}
	
	public void incrementSkillPointToSpend() {
		skillPointsToSpend++;
	}
	
	public int getSkillPointsToSpend() {
		return skillPointsToSpend;
	}
	
	@Override
	public String toString() {
		String contents = "Skill Points Remaining: " + skillPointsToSpend + "\n"
				+ "Attack: " + attackSkill + "\n" 
				+ "Bind Wound: " + bindWoundSkill + "\n"
				+ "Observe: " + observeSkill + "\n"
				+ "Barter: " + barterSkill;
		return contents;
	}
}
