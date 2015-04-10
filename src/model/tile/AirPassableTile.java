package model.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.tileviews.TileView;

public class AirPassableTile extends Tile{

	public AirPassableTile(TileView v) {
		super(v);
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
