package model.entity;

import model.area.TileCoordinate;
import model.entity.behavior.npc.Behaviorable;
import model.entity.behavior.npc.PetBehavior;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Pet extends NPC {

	public Pet(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
	}

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
	
	protected Behaviorable getBehavior(){
		return new PetBehavior();
	}
	
}
