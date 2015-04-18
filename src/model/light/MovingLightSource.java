package model.light;

import model.area.Area;
import model.area.TileCoordinate;
import model.observers.MobileListener;
import model.observers.MobileObject;

public class MovingLightSource extends LightSource implements MobileListener {

	public MovingLightSource(Area area, Visibility visibility, MobileObject mo) {
		super(area, visibility);
		mo.subscribe(this);
	}
	
	private void move(TileCoordinate location) {
		this.getArea().setStartLocation(location);
		LightManager.getLightManager().updateSeen();
	}

	@Override
	public void notify(MobileObject mo) {
		move(mo.getLocation());
	}
}