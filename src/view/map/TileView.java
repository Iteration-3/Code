package view.map;

import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.Location;

public abstract class TileView {
	public abstract void render(Graphics graphics, Location location, float diameter);
}
