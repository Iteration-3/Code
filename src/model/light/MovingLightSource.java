package model.light;

import model.area.Area;
import model.observers.MobileListener;
import model.observers.MobileObject;
import utilities.structuredmap.StructuredMap;

public class MovingLightSource extends LightSource implements MobileListener {	
	
	private MobileObject followee;

	public MovingLightSource(Area area, int strength, MobileObject mo) {
		super(area, strength);
		follow(mo);
	}
	
	public MovingLightSource(StructuredMap map) {
		super(map);
	}
	
	private void follow(MobileObject mo) {
		mo.subscribe(this);
		followee = mo;
	}
	
	@Override
	public void remove() {
		if (followee != null) 
			followee.unsubscribe(this);
	}
	
	@Override
	public void notify(MobileObject mo) {
		removeLighting(getArea());
		
		getArea().setStartLocation(mo.getLocation());
		getArea().setDirection(mo.getDirection());
		

		addLighting(getArea());
	}
	
	@Override
	public String getType() {
		return "movingLight";
	}
}