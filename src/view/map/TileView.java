package view.map;

import java.awt.Graphics;

import utilities.Point;
import model.area.Location;

public abstract class TileView {
	public abstract void render(Graphics graphics, Location location, float diameter);

	public void registerWithGameMapView(GameMapView gv, Location p) {
		gv.addTileView(this,p);
		
	}
}
