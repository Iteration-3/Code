package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.SavableLoadable;
import view.tiles.TileView;

public abstract class Tile implements SavableLoadable {
	private TileView view;
	
	public Tile(TileView v){
		view = v;
	}
	
	public abstract boolean isPassable(Entity e);
	public abstract void touch(Entity e);

}
