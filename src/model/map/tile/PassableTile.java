package model.map.tile;

import model.entity.Entity;
import utilities.structuredmap.StructuredMap;
import view.map.TileView;

public class PassableTile extends Tile {
	public PassableTile(TileView view) {
		super(view);
	}

	public PassableTile(StructuredMap map) {
		super(map);
	}

	@Override
	public boolean isPassable(Entity e) {
		return true;
	}

	@Override
	public void touch(Entity e) {
		return;
	}

	@Override
	protected String getType() {
		return "passable";
	}

}
