package model.ability.sneak;

import model.ability.Ability;
import model.entity.Avatar;
import model.skillmanager.SneakSkillManager;

public class DetectTrap extends Ability {
	
	private SneakSkillManager manager;
	
	public DetectTrap(SneakSkillManager sneakSkillManager) {
		super();
		this.manager = sneakSkillManager;
	}
	
	

	@Override
	public void perform(Avatar avatar) {
		// TODO (jraviles)
	}


}
