package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;

public class Sprite {
	private BufferedImage[] images;
	int counter = 0;
	
	public Sprite(BufferedImage[] images){
		this.images = images;
	}
	
	private BufferedImage getCurrentFrame(){
		BufferedImage temp = images[counter];
		return temp;
	}
	
	private void advanceCounter(){
		++counter;
		if(counter >= images.length){
			counter = 0;
		}
	}
	
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		BufferedImage image = getCurrentFrame();
		advanceCounter();
		graphics.drawImage(image,(int)location.getX()-image.getWidth()/2,
				(int)location.getY()-image.getHeight()/2,null );

	}


}
