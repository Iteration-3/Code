package view.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.structuredmap.StructuredMap;
import view.Decal;
import view.tiles.components.Hexagon;

public class BasicItemView extends ItemView {
	
	private Decal decal;
	
	private Hexagon backgroundHexagon;
	private Hexagon foregroundHexagon;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	
	public BasicItemView(Color fillColor, Color outlineColor, Decal decal) {
		// To get rid of
		backgroundHexagon = new Hexagon(outlineColor);
		foregroundHexagon = new Hexagon(fillColor);
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
	
		this.decal = decal;
	}
	
	public BasicItemView(Decal decal) {

		// To Get Rid Of!! Bad Bad Bad
		backgroundHexagon = new Hexagon(Color.BLUE);
		foregroundHexagon = new Hexagon(Color.ORANGE);
		// ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

		this.decal = decal;
	}
	
	public BasicItemView(StructuredMap map) {
		super(map);
		// imagePath = map.getString("path");
	}

	@Override
	public void render(Graphics graphics, float x, float y, float diameter) {
		/*backgroundHexagon.render(graphics, x, y, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, x, y, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);*/
	}
	
	public BufferedImage getImage(int width, int height){
		BufferedImage image = ImageProcessing.scaleImage(width, height, decal.getImageResourcePath());
		return image;
	}

	@Override
	public StructuredMap getStructuredMap() {
		// TODO: Update for Decal
		StructuredMap map = super.getStructuredMap();
		// map.put("path", imagePath);
		return map;
	}

	@Override
	public String getType() {
		return "basicItem";
	}

}
