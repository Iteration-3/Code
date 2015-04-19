package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;

public abstract class EntitySpriteHolder {
	
	public void render(Graphics graphics, RealCoordinate location, float diameter) {
		BufferedImage image = null;
		graphics.drawImage(image,(int)location.getX()-image.getWidth()/2,
				(int)location.getY()-image.getHeight()/2,null );

	}
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getUp(int i);
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getDown(int i);
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getUpLeft(int i);
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getDownLeft(int i);
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getUpRight(int i);
	/**
	 * Returns the given sprite.
	 * Note that 0 < i < 2, they return the various animations for that position.
	 * @param i
	 * @return
	 */
	protected abstract Sprite getDownRight(int i);

}
