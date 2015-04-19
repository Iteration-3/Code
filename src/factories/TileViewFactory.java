package factories;

import utilities.structuredmap.StructuredMap;
import view.map.BasicTileView;
import view.map.TileView;

public class TileViewFactory {

	public static TileView getTileView(StructuredMap map) {
		switch (map.getString("type")) {
		case "basic":
			return new BasicTileView(map);
		default:
			return null;
		}
	}
}
