package view.map;

import java.awt.Graphics;

import model.area.RealCoordinate;

public abstract class TileView {
	public abstract void render(Graphics graphics, RealCoordinate location, float diameter);

	public void registerWithGameMapView(GameMapView gv, RealCoordinate p) {
		gv.addTileView(this,p);
	}
}
