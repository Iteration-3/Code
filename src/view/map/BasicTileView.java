package view.map;

import java.awt.Color;
import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.Location;

public class BasicTileView extends TileView {
	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private static final float BORDER_PERCENTAGE = 0.12f; // 15% border edge
	
	public BasicTileView(Color fillColor, Color outlineColor) {
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	
	@Override
	public void render(Graphics graphics, Location location, float diameter) {
		backgroundHexagon.render(graphics, location, diameter);
		foregroundHexagon.render(graphics, location, diameter * (1 - BORDER_PERCENTAGE));
	}
	
}
