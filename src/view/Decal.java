package view;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public class Decal implements Saveable {
	private BufferedImage image;
	private String imageResourcePath;

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

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap structuredMap = new StructuredMap();
		structuredMap.put("imageResourcePath", imageResourcePath);
		return structuredMap;
	}
}
