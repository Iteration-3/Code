package model.map.tile;

import model.area.Location;
import model.entity.Entity;
import utilities.Point;
import utilities.structuredmap.SavableLoadable;
import view.map.GameMapView;
import view.map.TileView;

public abstract class Tile implements SavableLoadable {
	private TileView view;
	
	public Tile(TileView v){
		view = v;
	}
	
	public abstract boolean isPassable(Entity e);
	public abstract void touch(Entity e);

}
