package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;

public class ImpassableTile extends Tile {

    public ImpassableTile(TileView v) {
        super(v);
    }

    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
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
