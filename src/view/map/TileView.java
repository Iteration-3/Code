package view.map;

import java.awt.Graphics;

import model.area.RealCoordinate;

public abstract class TileView {
	public abstract void render(Graphics graphics, RealCoordinate location, float diameter);
}
