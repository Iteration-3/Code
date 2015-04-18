package model.entity;

import utilities.structuredmap.StructuredMap;

public class Mount extends NPC {
	
	public Mount(StructuredMap map) {
		super(map);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		return super.getStructuredMap();
	}

	@Override
	public String getType() {
		return "mount";
	}
}
