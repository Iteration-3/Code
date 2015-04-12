package view.tileviews;

import java.awt.Graphics;

import model.area.Location;
import view.components.Hexagon;

public class TileView {
	Hexagon hexagon;
	
	public TileView() {
		hexagon = new Hexagon();
	}
	
	public void render(Graphics graphics, Location location, float radius) {
		hexagon.render(graphics, location, radius);
	}
}
