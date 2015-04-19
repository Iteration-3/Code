package model.skillmanager;

import java.util.Map;

import utilities.structuredmap.StructuredMap;

public class SummonerSkillManager extends SkillManager {
	
	public SummonerSkillManager() {
		
	}

    public SummonerSkillManager(StructuredMap map) {
		super(map);
		this.boonSkill = map.getInteger("boonSkill");
		this.baneSkill = map.getInteger("baneSkill");
		this.enchantSkill = map.getInteger("enchantSkill");
		this.staffSkill = map.getInteger("staffSkill");
	}

	@Override
    public StructuredMap getStructuredMap() {
    	StructuredMap map = super.getStructuredMap();
    	map.put("boonSkill", boonSkill);
    	map.put("baneSkill", baneSkill);
    	map.put("enchantSkill", enchantSkill);
    	map.put("staffSkill", staffSkill);
    	return map;
    }

    private int boonSkill = 1;
    private int baneSkill = 1;
    private int enchantSkill = 1;
    private int staffSkill = 1;

    public int getBoonSkill() {
        return boonSkill;
    }

    public int getBaneSkill() {
        return baneSkill;
    }

    public int getEnchantSkill() {
        return enchantSkill;
    }

    public int getStaffskill() {
        return staffSkill;
    }

    public void incrementBoon() {
        ++boonSkill;
    }

    public void incrementBane() {
        ++baneSkill;
    }

    public void incrementEnchant() {
        ++enchantSkill;
    }

    public void incrementStaff() {
        ++staffSkill;
    }

	@Override
	protected String getType() {
		return "summoner";
	}
	
	@Override
	public Map<String, Integer> getSkillNamesWithValues() {
		Map<String, Integer> skillsMap = super.getSkillNamesWithValues();
		skillsMap.put("Boon", boonSkill);
		skillsMap.put("Enchant", enchantSkill);
		skillsMap.put("Bane", baneSkill);
		skillsMap.put("Staff", staffSkill);
		return skillsMap;
	}
}
