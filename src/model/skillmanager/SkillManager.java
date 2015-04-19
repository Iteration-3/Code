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
		if (!hasSkillPointsToSpend()) return;
		++attackSkill;
		spendSkillPoint();
	}

	public void incrementBindWound(){
		if (!hasSkillPointsToSpend()) return;
		++bindWoundSkill;
		spendSkillPoint();
	}

	public void incrementObserve(){
		if (!hasSkillPointsToSpend()) return;
		++observeSkill;
		spendSkillPoint();
	}

	public void incrementBarter(){
		if (!hasSkillPointsToSpend()) return;
		++barterSkill;
		spendSkillPoint();
	}
	
	public void incrementSkillPointToSpend() {
		skillPointsToSpend++;
	}
	
	private void spendSkillPoint() {
		skillPointsToSpend--;
	}
	
	public int getSkillPointsToSpend() {
		return skillPointsToSpend;
	}

	private boolean hasSkillPointsToSpend() {
		return (skillPointsToSpend > 0);
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
