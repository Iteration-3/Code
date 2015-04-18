package model.skillmanager;

import utilities.structuredmap.StructuredMap;

public class SneakSkillManager extends SkillManager {

    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
    }

    private int creepSkill = 1;
    private int pickPicketSkill = 1;
    private int trapRemoveSkill = 1;
    private int rangedSkill = 1;

    public int getCreepskill() {
        return creepSkill;
    }

    public int getPickPocketSkill() {
        return pickPicketSkill;
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
        ++pickPicketSkill;
    }

    public void incrementCreepSkill() {
        ++creepSkill;
    }

}
