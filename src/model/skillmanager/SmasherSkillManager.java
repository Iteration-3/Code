package model.skillmanager;

import java.util.Map;

import utilities.structuredmap.StructuredMap;

public class SmasherSkillManager extends SkillManager {
	
	private int twoHandedSkill = 1;
    private int oneHandedSkill = 1;
    private int brawlSkill = 1;
    
   public SmasherSkillManager() {

   }
    
    public SmasherSkillManager(StructuredMap map) {
		super(map);
		this.twoHandedSkill = map.getInteger("twoHandedSkill");
		this.oneHandedSkill =  map.getInteger("oneHandedSkill");
		this.brawlSkill =  map.getInteger("brawlSkill");
	}

    public int getTwoHandedSkill() {
        return twoHandedSkill;
    }

    public int getOneHandedSkill() {
        return oneHandedSkill;
    }

    public int getBrawlSkill() {
        return brawlSkill;
    }

    public void incrementBrawl() {
        ++brawlSkill;
    }

    public void incrementOneHand() {
        ++oneHandedSkill;
    }

    public void incrementTwoHand() {
        ++twoHandedSkill;
    }
    
    @Override
    public StructuredMap getStructuredMap() {
    	StructuredMap map = super.getStructuredMap();
    	map.put("twoHandedSkill", twoHandedSkill);
    	map.put("oneHandedSkill", oneHandedSkill);
    	map.put("brawlSkill", brawlSkill);
    	return map;
    }

	@Override
	protected String getType() {
		return "smasher";
	}
    
	@Override
	public Map<String, Integer> getSkillNamesWithValues() {
		Map<String, Integer> skillsMap = super.getSkillNamesWithValues();
		skillsMap.put("Two Handed", twoHandedSkill);
		skillsMap.put("One Handed", oneHandedSkill);
		skillsMap.put("Brawl", brawlSkill);
		return skillsMap;
	}
    

}
