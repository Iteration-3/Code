package model.entity;

import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;

public class NPC extends Entity {

	//Needs behavior shit!
	//Behavior shit will be overridden by subclasses

	protected ItemManager createItemManager() {
		return new ItemManager(this);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
