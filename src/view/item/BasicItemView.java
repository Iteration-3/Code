package view.item;

import java.awt.Color;
import java.awt.Graphics;

import view.tiles.components.Hexagon;
import model.area.RealCoordinate;

public class BasicItemView extends ItemView {

	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	
	public BasicItemView(Color fillColor, Color outlineColor) {
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	
	@Override
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		backgroundHexagon.render(graphics, location, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, location, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);
	}
}
