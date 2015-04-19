package model.entity;

import model.area.TileCoordinate;
import model.entity.dialog.DialogTree;
import utilities.structuredmap.StructuredMap;
import view.EntityView;

public class Pet extends NPC {
	
	public Pet(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
	}

	public Pet(String name, EntityView view, TileCoordinate location, DialogTree dialogTree) {
		super(name, view, location, dialogTree);
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
	
}
