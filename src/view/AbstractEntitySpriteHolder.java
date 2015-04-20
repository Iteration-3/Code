package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import utilities.Direction;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class AbstractEntitySpriteHolder implements Saveable {
	
	public void render(Graphics graphics, float x, float y, float diameter, Direction angle) {
		switch(angle){
		case UP:
			this.getUp().render(graphics, x, y, diameter);
			break;
		case DOWN:
			this.getDown().render(graphics, x, y, diameter);
			break;
		case UP_LEFT:
			this.getUpLeft().render(graphics, x, y, diameter);
			break;
		case DOWN_LEFT:
			this.getDownLeft().render(graphics, x, y, diameter);
			break;
		case UP_RIGHT:
			this.getUpRight().render(graphics, x, y, diameter);
			break;
		case DOWN_RIGHT:
			this.getDownRight().render(graphics, x, y, diameter);
			break;
		default:
			throw new IllegalArgumentException("IMPOSSIBLE");
		}
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();


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
