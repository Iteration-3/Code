package view.map;

import java.awt.Color;
import java.awt.Graphics;

import utilities.structuredmap.StructuredMap;
import view.tiles.components.Hexagon;
import model.area.RealCoordinate;

public class BasicTileView extends TileView {
	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	private Color fillColor;
	private Color outlineColor;
	
	public BasicTileView(Color fillColor, Color outlineColor) {
		this.fillColor = fillColor;
		this.outlineColor = outlineColor;
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	
	public BasicTileView(StructuredMap map) {
		fillColor = Color.getColor(map.getString("fillColor"));
		outlineColor = Color.getColor(map.getString("outlineColor"));
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	
	@Override
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		backgroundHexagon.render(graphics, location, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, location, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("fillColor", fillColor.toString());
		map.put("outlineColor", outlineColor.toString());
		return map;
	}

	@Override
	protected String getType() {
		return "basic";
	}
	
}
