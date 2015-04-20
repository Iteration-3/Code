package model.light;

import model.area.Area;
import model.observers.MobileListener;
import model.observers.MobileObject;
import utilities.structuredmap.StructuredMap;

//area does change shape
public class MovingDynamicLightSource extends LightSource implements MobileListener {	
	
	private MobileObject followee;

	public MovingDynamicLightSource(Area area, int strength, MobileObject mo) {
		super(area, strength);
		follow(mo);
	}
	
	public MovingDynamicLightSource(StructuredMap map) {
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
		removePrevLighting(getArea());
		
		addLighting(getArea());
	}
	
	@Override
	public String getType() {
		return "movingLight";
	}
}