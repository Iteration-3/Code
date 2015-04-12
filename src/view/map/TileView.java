package view.map;

import java.awt.Graphics;

import model.area.Location;

public abstract class TileView {
	public abstract void render(Graphics graphics, Location location, float diameter);
}
