package view;

import java.awt.Graphics;

import model.area.RealCoordinate;
import model.area.TileCoordinate;
import utilities.Angle;
import view.map.GameEntityView;

public class EntityView {
	//COPY AND PASTED SHIT FROM HEXAGON PLACE HOLDER
	EntitySpriteHolder sprites;
	private RealCoordinate location;
	private static final float BORDER_PERCENTAGE = 0.15f; // 15% border edge
	private static final float OVERDRAW = 1.05f; // To eliminate little blank spaces between tiles
	
	public EntityView(EntitySpriteHolder sprites) {
		this.sprites=sprites;
	}

	public void registerWithGameMapView(GameEntityView gv, RealCoordinate location, Angle angle) {
		gv.addEntityView(this);
		this.location = location;
		this.setDirection(angle);
	}
	
	float tileWidth;
	float tileHeight;
	private Angle angle;
	
	public void render(Graphics graphics, int screenHeight) {	
		tileHeight = screenHeight / 18.0f;
		tileWidth = tileHeight / (float) (Math.sqrt(3) / 2);
		RealCoordinate updatedCoordinate = new RealCoordinate
				((location.getX() * tileWidth * 0.75),
						(location.getY() * tileHeight + (location.getX() % 2) * tileHeight / 2));
		//foregroundHexagon.render(graphics, updatedCoordinate, tileWidth * (1 - BORDER_PERCENTAGE) * OVERDRAW);
		//backgroundHexagon.render(graphics, updatedCoordinate, tileWidth * BORDER_PERCENTAGE * OVERDRAW);
		sprites.render(graphics, updatedCoordinate, 1,this.getDirection());
		
	}

	private Angle getDirection() {
		return angle;
	}

	public void setLocation(RealCoordinate location) {
		this.location = location;
	}

	public void setLocation(TileCoordinate location) {
		this.setLocation(new RealCoordinate(location.getX(), location.getY()));
	}

	public void setDirection(Angle angle) {
		this.angle = angle;
		
	}
}
