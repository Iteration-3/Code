package model.entity;

import utilities.structuredmap.StructuredMap;
import view.EntityView;
import model.area.TileCoordinate;
import model.entity.dialog.DialogTree;

public class Mount extends NPC {
	
	public Mount(String name, EntityView view, TileCoordinate location) {
		super(name, view, location);
	}
	
	public Mount(String name, EntityView view, TileCoordinate location, DialogTree dialogTree) {
		super(name, view, location, dialogTree);
	}

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
