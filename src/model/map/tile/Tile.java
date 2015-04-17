package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.SavableLoadable;
import view.map.TileView;

public abstract class Tile implements SavableLoadable {
	private TileView view;
	
	public Tile(TileView view){
		view = view;
	}
	
	public TileView getView() {
		return view;
	}
	
	public abstract boolean isPassable(Entity e);
	public abstract void touch(Entity e);

}
