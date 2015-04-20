package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.ImageProcessing;
import utilities.ScreenCoordinate;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class Decal implements Saveable, Renderable {
	private BufferedImage image;
	private String imageResourcePath;
	private RealCoordinate position;

	public Decal(String imageResourcePath) {
		this.imageResourcePath = imageResourcePath;
		this.image = ImageProcessing.getImage(imageResourcePath);
	}
	
	public Decal(StructuredMap structuredMap) {
		this.imageResourcePath = structuredMap.getString("imageResourcePath");
		this.image = ImageProcessing.getImage(imageResourcePath);
	}
	
	public Decal() {
		this.imageResourcePath = "/image/item.jpg";
		this.image = ImageProcessing.getImage(imageResourcePath);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public String getImageResourcePath() {
		return imageResourcePath;
	}
	
	public void setPosition(RealCoordinate position) {
		this.position = position;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap structuredMap = new StructuredMap();
		structuredMap.put("imageResourcePath", imageResourcePath);
		return structuredMap;
	}

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		ScreenCoordinate coordinate = transform.getTranslatedPosition(position);
		graphics.drawImage(image, (int)coordinate.getX() - (int) transform.getTileWidth() / 2, (int)coordinate.getY() - (int)transform.getTileHeight() / 2, (int)transform.getTileWidth(), (int)transform.getTileWidth(), null);

	}
}
