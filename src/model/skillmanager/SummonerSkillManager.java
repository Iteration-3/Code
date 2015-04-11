package model.skillmanager;

import utilities.structuredmap.StructuredMap;

public class SummonerSkillManager extends SkillManager {

	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}
	private int boonSkill = 1;
	private int baneSkill = 1;
	private int enchantSkill = 1;
	private int staffSkill = 1;
	
	public int getBoonSkill(){
		return boonSkill;
	}
	public int getBaneSkill(){
		return baneSkill;
	}
	
	public int getEnchantSkill(){
		return enchantSkill;
	}
	public int getStaffskill(){
		return staffSkill;
	}
	
	public void incrementBoon(){
		++boonSkill;
	}
	public void incrementBane(){
		++baneSkill;
	}
	public void incrementEnchant(){
		++enchantSkill;
	}
	public void incrementStaff(){
		++staffSkill;
	}
}
