package model.light;

import model.area.Area;
import model.area.Location;

public class MovingLightSource extends LightSource {

	public MovingLightSource(Area area, Visibility visibility) {
		super(area, visibility);
	}
	
	public void move(Location location) {
		this.getArea().setStartLocation(location);
	}

}
