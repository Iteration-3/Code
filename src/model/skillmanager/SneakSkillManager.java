package model.skillmanager;

import java.util.Map;

import utilities.structuredmap.StructuredMap;
import view.layout.SkillsMenuLayout;

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

    public int getTrapRemoveSkill() {
        return trapRemoveSkill;
    }

    public int rangedSkill() {
        return rangedSkill;
    }

    public void incrementRangedSkill() {
		if (!hasSkillPointsToSpend()) return;
        ++rangedSkill;
		spendSkillPoint();
    }

    public void incrementTrapRemoveSkill() {
		if (!hasSkillPointsToSpend()) return;
        ++trapRemoveSkill;
		spendSkillPoint();
    }

    public void incrementPickPocketSkill() {
		if (!hasSkillPointsToSpend()) return;
        ++pickPocketSkill;
		spendSkillPoint();
    }

    public void incrementCreepSkill() {
		if (!hasSkillPointsToSpend()) return;
        ++creepSkill;
		spendSkillPoint();
    }

	@Override
	protected String getType() {
		return "sneak";
	}

	@Override
	public Map<String, Integer> getSkillNamesWithValues() {
		Map<String, Integer> skillsMap = super.getSkillNamesWithValues();
		skillsMap.put("Creep", creepSkill);
		skillsMap.put("Pick Pocket", pickPocketSkill);
		skillsMap.put("Detect & Remove Trap", rangedSkill);
		return skillsMap;
	}

	@Override
	public void accept(SkillsMenuLayout skillsMenuLayout) {
		skillsMenuLayout.populateSneakSkills(this);
	}
}
