package model.skillmanager;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class SkillManager implements Saveable {
	
	private int attackSkill = 1;
	private int bindWoundSkill = 1;
	private int observeSkill = 1;
	private int barterSkill = 1;
	
	public SkillManager(StructuredMap map) {
		this.attackSkill = map.getInteger("attackSkill");
		this.bindWoundSkill = map.getInteger("bindWoundSkill");
		this.observeSkill = map.getInteger("observeSkill");
		this.barterSkill = map.getInteger("barterSkill");
	}
	
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
	
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("attackSkill", attackSkill);
		map.put("bindWoundSkill", bindWoundSkill);
		map.put("observeSkill", observeSkill);
		map.put("barterSkill", barterSkill);
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();
	
}
