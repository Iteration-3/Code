package model.light;

import java.util.ArrayList;
import java.util.List;

import model.area.Area;
import model.area.TileCoordinate;
import model.observers.MobileListener;
import model.observers.MobileObject;

public class MovingLightSource extends LightSource implements MobileListener {

	public MovingLightSource(Area area, int strength, MobileObject mo) {
		super(area, strength);
		mo.subscribe(this);
	}
	
	@Override
	public void notify(MobileObject mo) {
		removeLighting();
		
		getArea().setStartLocation(mo.getLocation());
		getArea().setDirection(mo.getDirection());
		

		addLighting();
	}
}