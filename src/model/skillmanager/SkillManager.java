package model.skillmanager;

import java.util.HashMap;
import java.util.Map;

import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.layout.SkillsMenuLayout;

public abstract class SkillManager implements Saveable {

	private int skillPointsToSpend = 0;
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
	
	public SkillManager() {
		// TODO Auto-generated constructor stub
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
	
	protected void spendSkillPoint() {
		skillPointsToSpend--;
	}
	
	public int getSkillPointsToSpend() {
		return skillPointsToSpend;
	}

	protected boolean hasSkillPointsToSpend() {
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

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("attackSkill", attackSkill);
		map.put("bindWoundSkill", bindWoundSkill);
		map.put("observeSkill", observeSkill);
		map.put("barterSkill", barterSkill);
		map.put("type", getType());
		return map;
	}
	
	public Map<String, Integer> getSkillNamesWithValues() {
		Map<String, Integer> skillMap = new HashMap<String, Integer>();
		skillMap.put("Attack", attackSkill);
		skillMap.put("Bind Wound", attackSkill);
		skillMap.put("Observe", attackSkill);
		skillMap.put("Barter", barterSkill);
		return skillMap;
	}
	
	protected abstract String getType();

	public abstract void accept(SkillsMenuLayout skillsMenuLayout);
	
}

