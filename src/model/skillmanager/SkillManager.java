package model.skillmanager;

import utilities.structuredmap.Saveable;

public abstract class SkillManager implements Saveable {
	
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
	
}
