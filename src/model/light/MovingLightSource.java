package model.light;

import model.area.Area;
import model.area.RealCoordinate;

public class MovingLightSource extends LightSource {

	public MovingLightSource(Area area, Visibility visibility) {
		super(area, visibility);
	}
	
	public void move(RealCoordinate location) {
		this.getArea().setStartLocation(location);
	}

}
