package model.skillmanager;

import utilities.structuredmap.StructuredMap;

public class SneakSkillManager extends SkillManager {
	
	public SneakSkillManager() {
		
	}

    public SneakSkillManager(StructuredMap map) {
		super(map);
		this.creepSkill = map.getInteger("creepSkill");
		this.pickPocketSkill = map.getInteger("pickPocketSkill");
		this.trapRemoveSkill = map.getInteger("trapRemoveSkill");
		this.rangedSkill = map.getInteger("rangedSkill");

	}

	@Override
    public StructuredMap getStructuredMap() {
    	StructuredMap map = super.getStructuredMap();
    	map.put("creepSkill", creepSkill);
    	map.put("pickPocketSkill", pickPocketSkill);
    	map.put("trapRemoveSkill", trapRemoveSkill);
    	map.put("rangedSkill", rangedSkill);
    	return map;
    }

    private int creepSkill = 1;
    private int pickPocketSkill = 1;
    private int trapRemoveSkill = 1;
    private int rangedSkill = 1;

    public int getCreepskill() {
        return creepSkill;
    }

    public int getPickPocketSkill() {
        return pickPocketSkill;
    }

    public int trapRemoveSkill() {
        return trapRemoveSkill;
    }

    public int rangedSkill() {
        return rangedSkill;
    }

    public void incrementRangedSkill() {
        ++rangedSkill;
    }

    public void incrementTrapRemoveSkill() {
        ++trapRemoveSkill;
    }

    public void incrementPickPocketSkill() {
        ++pickPocketSkill;
    }

    public void incrementCreepSkill() {
        ++creepSkill;
    }

	@Override
	protected String getType() {
		return "sneak";
	}

}
