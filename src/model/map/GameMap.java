package model.map;

import java.util.HashMap;
import java.util.Map;

import model.area.TileCoordinate;
import model.entity.Entity;
import model.map.tile.Tile;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import factories.TileFactory;

public class GameMap implements Saveable {

	private Map<TileCoordinate, Tile> tiles = new HashMap<TileCoordinate, Tile>();

	
	public GameMap() {}
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap[] array = new StructuredMap[tiles.size()];
		int i = 0;
		for (Map.Entry<TileCoordinate, Tile> tile : tiles.entrySet()) {
			StructuredMap tempMap = new StructuredMap();
			tempMap.put("coord", tile.getKey().getStructuredMap());
			tempMap.put("tile", tile.getValue().getStructuredMap());
			array[i++] = tempMap;
		}
		StructuredMap map = new StructuredMap();
		map.put("tiles", array);
		return map;
	}

	public GameMap(StructuredMap map) {
		tiles = new HashMap<TileCoordinate, Tile>();
		StructuredMap[] array = map.getStructuredMapArray("tiles");
		for (StructuredMap tempMap : array) {
			tiles.put(new TileCoordinate(tempMap.getStructuredMap("coord")),
					TileFactory.createTile(tempMap.getStructuredMap("tile")));
		}
	}

	/**
	 * Overwrites if tile already there.
	 * 
	 * @param t
	 * @param p
	 */
	public void add(Tile t, TileCoordinate p) {
		tiles.put(p, t);
	}

	/**
	 * If the tile is passable, returns if it can be passed by the given entity,
	 * else returns false.
	 * 
	 * @param e
	 * @param loc
	 * @return
	 */
	public boolean isPassable(Entity e, TileCoordinate loc) {
		Tile t = tiles.get(loc);
		if (t == null) {
			return false;
		}
		return t.isPassable(e);
	}

	/**
	 * Touches the tile, IF it exists.
	 * 
	 * @param e
	 * @param loc
	 */
	public void touch(Entity e, TileCoordinate loc) {
		Tile t = tiles.get(loc);
		if (t == null) {
			return;
		}
		t.touch(e);

	}

}
