package model.ability.sneak;

import model.ability.Ability;
import model.entity.Avatar;
import utilities.structuredmap.StructuredMap;

public class DetectTrap extends Ability {
	
	public DetectTrap() {
		super();
	}
	
	public DetectTrap(int manaCost) {
		super(manaCost);
	}
	
	public DetectTrap(StructuredMap map) {
		super(map);
	}

	@Override
	public void perform(Avatar avatar) {
		// TODO (jraviles)
	}

	@Override
	protected String getType() {
		return "detectTrap";
	}

}
