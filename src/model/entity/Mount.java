package model.entity;

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

}
