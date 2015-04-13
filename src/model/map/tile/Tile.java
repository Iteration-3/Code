package model.map.tile;

import model.area.Location;
import model.entity.Entity;
import utilities.Point;
import utilities.structuredmap.SavableLoadable;
import view.map.GameMapView;
import view.map.TileView;

public abstract class Tile implements SavableLoadable {
	private TileView view;
	Point location;
	
	public Tile(TileView v, Point loc){
		view = v;
		location = loc;
	}
	
	public abstract boolean isPassable(Entity e);
	public abstract void touch(Entity e);
	public Point getLocation(){
		return location;
	}

}
