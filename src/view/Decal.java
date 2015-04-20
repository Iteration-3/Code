package view;

import java.awt.image.BufferedImage;

import utilities.ImageProcessing;

public class Decal {
	private BufferedImage image;
	private String imageResourcePath;

	public Decal(String imageResourcePath) {
		this.imageResourcePath = imageResourcePath;
		this.image = ImageProcessing.getImage(imageResourcePath);
	}
	
	public BufferedImage getImage() {
		return image;
	}
	
	public String getImageResourcePath() {
		return imageResourcePath;
	}
}
