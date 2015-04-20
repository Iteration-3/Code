package view.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.structuredmap.StructuredMap;
import view.tiles.components.Hexagon;

public class BasicItemView extends ItemView {
	
	private static String imagePath = "/images/item.jpg";
	private BufferedImage itemImage;

	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	
	public BasicItemView(Color fillColor, Color outlineColor) {
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
	}
	
	public BasicItemView() {
		backgroundHexagon = new Hexagon(Color.BLUE);
		foregroundHexagon = new Hexagon(Color.ORANGE);
	}
	
	public BasicItemView(StructuredMap map) {
		super(map);
		imagePath = map.getString("path");
	}

	@Override
	public void render(Graphics graphics, float x, float y, float diameter) {
		backgroundHexagon.render(graphics, x, y, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, x, y, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);
	}
	
	public BufferedImage getImage(int x, int y){
		itemImage = ImageProcessing.scaleImage(x,y,imagePath);
		return itemImage;
	}
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("path", imagePath);
		return map;
	}

	@Override
	public String getType() {
		return "basicItem";
	}

}
