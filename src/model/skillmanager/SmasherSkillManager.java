package model.skillmanager;

import utilities.structuredmap.StructuredMap;

public class SmasherSkillManager extends SkillManager {

	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}
	private int twoHandedSkill = 1;
	private int oneHandedSkill = 1;
	private int brawlSkill = 1;
	public int getTwoHandedSkill(){
		return twoHandedSkill;
	}
	public int getOneHandedSkill(){
		return oneHandedSkill;
	}
	public int getBrawlSkill(){
		return brawlSkill;
	}
	
	public void incrementBrawl(){
		++brawlSkill;
	}
	public void incrementOneHand(){
		++oneHandedSkill;
	}
	public void incrementTwoHand(){
		++twoHandedSkill;
	}

}
