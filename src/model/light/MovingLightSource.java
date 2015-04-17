package model.light;

import model.area.Area;
import model.area.TileCoordinate;

public class MovingLightSource extends LightSource {

	public MovingLightSource(Area area, Visibility visibility) {
		super(area, visibility);
	}
	
	public void move(TileCoordinate location) {
		this.getArea().setStartLocation(location);
	}

}
