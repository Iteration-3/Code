package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;

import model.area.RealCoordinate;

public abstract class EntitySpriteHolder {
	
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		BufferedImage image = null;
		graphics.drawImage(image,(int)location.getX()-image.getWidth()/2,
				(int)location.getY()-image.getHeight()/2,null );

	}

	protected abstract void setUp(BufferedImage[] images);

	protected abstract void setDown(BufferedImage[] images);

	protected abstract void setUpLeft(BufferedImage[] images);

	protected abstract void setDownLeft(BufferedImage[] images);

	protected abstract void setUpRight(BufferedImage[] images);

	protected abstract void setDownRight(BufferedImage[] images);
	
	
	protected abstract Sprite getUp();
	
	protected abstract Sprite getDown();
	
	protected abstract Sprite getUpLeft();
	
	protected abstract Sprite getDownLeft();
	
	protected abstract Sprite getUpRight();
	
	protected abstract Sprite getDownRight();

}
