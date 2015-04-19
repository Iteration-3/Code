package view;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import model.area.RealCoordinate;
import utilities.Angle;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class AbstractEntitySpriteHolder implements Saveable {
	
	public void render(Graphics graphics, RealCoordinate location, float diameter, Angle angle) {
		switch(angle){
		case UP:
			this.getUp().render(graphics,location,diameter);
			break;
		case DOWN:
			this.getDown().render(graphics,location,diameter);
			break;
		case UP_LEFT:
			this.getUpLeft().render(graphics,location,diameter);
			break;
		case DOWN_LEFT:
			this.getDownLeft().render(graphics,location,diameter);
			break;
		case UP_RIGHT:
			this.getUpRight().render(graphics,location,diameter);
			break;
		case DOWN_RIGHT:
			this.getDownRight().render(graphics,location,diameter);
			break;
		default:
			throw new IllegalArgumentException("IMPOSSIBLE");
		}
	}
	
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
