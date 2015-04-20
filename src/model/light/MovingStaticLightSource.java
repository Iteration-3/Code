package model.light;

import model.area.Area;
import model.observers.MobileListener;
import model.observers.MobileObject;
import utilities.structuredmap.StructuredMap;

//area does NOT change shape. only direction and location. (things that are settable basically)
public class MovingStaticLightSource extends LightSource implements MobileListener {	
	
	private MobileObject followee;

	public MovingStaticLightSource(Area area, int strength, MobileObject mo) {
		super(area, strength);
		follow(mo);
	}
	
	public MovingStaticLightSource(StructuredMap map) {
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
		
		getArea().setStartLocation(mo.getLocation());
		getArea().setDirection(mo.getDirection());
		
		removePrevLighting(getArea());
		
		addLighting(getArea());
	}
	
	@Override
	public String getType() {
		return "movingLight";
	}
}