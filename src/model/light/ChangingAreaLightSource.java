package model.light;

import model.area.Area;
import model.observers.MobileAreaListener;
import model.observers.MobileAreaObject;
import utilities.structuredmap.StructuredMap;

public class ChangingAreaLightSource extends LightSource implements MobileAreaListener {	
	
	private MobileAreaObject followee;

	public ChangingAreaLightSource(Area area, int strength, MobileAreaObject mo) {
		super(area, strength);
		follow(mo);
	}
	
	public ChangingAreaLightSource(StructuredMap map) {
		super(map);
	}
	
	private void follow(MobileAreaObject mo) {
		mo.subscribe(this);
		followee = mo;
	}
	
	public void remove() {
		if (followee != null) 
			followee.unsubscribe(this);
	}
	
	@Override
	public void notify(MobileAreaObject mo) {
		removeLighting(mo.getPrevArea());
		addLighting(mo.getArea());
	}
	
	@Override
	public String getType() {
		return "movingLight";
	}
}