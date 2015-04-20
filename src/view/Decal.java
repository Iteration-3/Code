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
		position = new RealCoordinate();
	}
	
	public Decal(StructuredMap structuredMap) {
		this.imageResourcePath = structuredMap.getString("imageResourcePath");
		this.image = ImageProcessing.getImage(imageResourcePath);
		this.position = new RealCoordinate(structuredMap.getStructuredMap("position"));
	}
	
	public Decal() {
		this.imageResourcePath = "/image/item.jpg";
		this.image = ImageProcessing.getImage(imageResourcePath);
		this.position = new RealCoordinate();
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
		structuredMap.put("position", position.getStructuredMap());
		System.out.println(structuredMap.getJson());
		return structuredMap;
	}

	@Override
	public void render(Graphics graphics, ViewTransform transform) {
		if(position!=null) {
			ScreenCoordinate coordinate = transform.getTranslatedPosition(position);
			int itemSize = (int) (transform.getTileHeight() * .8);
			graphics.drawImage(image, (int)coordinate.getX() - itemSize / 2, 
					(int)coordinate.getY() - itemSize / 2, 
					itemSize, itemSize, null);
		}

	}
}
