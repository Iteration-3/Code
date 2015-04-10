package model.entity;

import view.EntityView;


public abstract class Avatar extends Entity {

	public Avatar(String name, EntityView view){
		super(name,view);
	}
	
	@Override 
	public boolean isFlying(){
		return false;
	}
	//Ovverrides stats and name? Says in UML, but that's weird
	//Also overrides move, according to uml? Meh, if we need it, we'll do it, not before IMO
	
	//SkillManager
	//Abilities
	//ControlerManager
	
	//Also apparently ovverrides add/removeItem, and equip/unequipItem, but that also seems 
	//like an uneeded ovverride, so won't do until needed.
	
	//getListeners will be needed
	

}
