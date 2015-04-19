package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;

public class ImpassableTile extends Tile {

	public ImpassableTile(TileView v) {
		super(v);
	}

	public ImpassableTile(StructuredMap map) {
		super(map);
	}

	@Override
	public boolean isPassable(Entity e) {
		return false;
	}

	@Override
	public void touch(Entity e) {
		return;
	}

	@Override
	protected String getType() {
		return "impassable";
	}

}
