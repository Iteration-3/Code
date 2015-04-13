package model.map.tile;

import model.area.Location;
import model.entity.Entity;
import utilities.Point;
import utilities.structuredmap.StructuredMap;
import view.map.GameMapView;
import view.map.TileView;

public class ImpasssibleTile extends Tile {





	public ImpasssibleTile(TileView v, GameMapView gv, Point loc) {
		super(v, gv, loc);
		// TODO Auto-generated constructor stub
	}

	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isPassable(Entity e) {
		return false;
	}

	@Override
	public void touch(Entity e) {
		return;
	}

}
