package model.entity;

import utilities.structuredmap.StructuredMap;


public class Pet extends NPC {
	
	public Pet(StructuredMap map) {
		super(map);
	}

	@Override
	public String getType() {
		return "pet";
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		return super.getStructuredMap();
	}
	
}
