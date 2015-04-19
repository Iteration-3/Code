package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;

public class Sprite {
	private BufferedImage[] images;
	
	public Sprite(BufferedImage[] images){
		this.images = images;
	}
	
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		BufferedImage image = images[0];//TODO animations
		graphics.drawImage(image,(int)location.getX()-image.getWidth()/2,
				(int)location.getY()-image.getHeight()/2,null );

	}


}
