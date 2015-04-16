package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;

public class AirPassableTile extends Tile{
	public AirPassableTile(TileView v) {
		super(v);
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
		if(e.isFlying()){
			return true;
		}
		else{
			return false;
		}
	}

	@Override
	public void touch(Entity e) {
		return;
	}
}
