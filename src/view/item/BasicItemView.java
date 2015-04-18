package view.item;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import view.tiles.components.Hexagon;
import model.area.RealCoordinate;

public class BasicItemView extends ItemView {
	
	private static String imagePath = "src/resources/image/item.jpg";
	private static BufferedImage itemImage;

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

	@Override
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		RealCoordinate updatedCoordinate = new RealCoordinate(location.getX(), location.getY());
		backgroundHexagon.render(graphics, updatedCoordinate, diameter * OVERDRAW);
		foregroundHexagon.render(graphics, updatedCoordinate, diameter * (1 - BORDER_PERCENTAGE) * OVERDRAW);
	}
	
	public BufferedImage getImage(int x, int y){
		itemImage = ImageProcessing.scaleImage(x,y,imagePath);
		return itemImage;
	}
}
