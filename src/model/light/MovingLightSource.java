package model.light;

import model.area.Area;
import model.observers.MobileListener;
import model.observers.MobileObject;

public class MovingLightSource extends LightSource implements MobileListener {	
	
	private MobileObject followee;

	public MovingLightSource(Area area, int strength, MobileObject mo) {
		super(area, strength);
		follow(mo);
	}
	
	private void follow(MobileObject mo) {
		mo.subscribe(this);
		followee = mo;
	}
	
	public void remove() {
		if (followee != null) 
			followee.unsubscribe(this);
	}
	
	@Override
	public void notify(MobileObject mo) {
		removeLighting();
		
		getArea().setStartLocation(mo.getLocation());
		getArea().setDirection(mo.getDirection());
		

		addLighting();
	}
}