package factories;

import model.map.tile.AirPassableTile;
import model.map.tile.ImpassableTile;
import model.map.tile.PassableTile;
import model.map.tile.Tile;
import utilities.structuredmap.StructuredMap;

public class TileFactory {

	public static Tile createTile(StructuredMap map) {
		switch (map.getString("type")) {
		case "passable":
			return new PassableTile(map);
		case "impassable":
			return new ImpassableTile(map);
		case "airPassable":
			return new AirPassableTile(map);
		}
	}
}
