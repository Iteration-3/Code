package view.map;

import java.awt.Graphics;

import model.area.RealCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class TileView implements Saveable {
	public abstract void render(Graphics graphics, float x, float y, float diameter);

	public void registerWithGameMapView(GameTileView gv, RealCoordinate p) {
		gv.addTileView(this, p);
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("type", getType());
		return map;
	}

	protected abstract String getType();
}
