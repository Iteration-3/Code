package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;

public class AirPassableTile extends Tile {
    public AirPassableTile(TileView view) {
        super(view);
    }

    public AirPassableTile(StructuredMap map) {
    	super(map);
    }

    @Override
    public boolean isPassable(Entity e) {    	
        if (e.isFlying()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void touch(Entity e) {
        return;
    }

	@Override
	protected String getType() {
		return "airPassable";
	}
    
    
}
