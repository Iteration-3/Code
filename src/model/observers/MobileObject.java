package model.observers;

import java.util.ArrayList;

import utilities.Angle;
import model.area.TileCoordinate;

public abstract class MobileObject {
	
	private ArrayList<MobileListener> listeners = new ArrayList<MobileListener>();
	private TileCoordinate location;
	private Angle direction;
	
	public MobileObject(TileCoordinate loc) {
		setLocation(loc);
	}
	
	public void subscribe(MobileListener list) {
		listeners.add(list);
	}

	public void unsubscribe(MobileListener list) {
		listeners.remove(list);
	}
	
	public void setLocation(TileCoordinate location) {
		this.location = location;
		notifySubscribers();
	}
	
	public void setDirection(Angle direction) {
		this.direction = direction;
		notifySubscribers();
	}
	
	protected void setLocationNoNotify(TileCoordinate location) {
		this.location = location;
	}
	
	protected void setDirectionNoNotify(Angle direction) {
		this.direction = direction;
	}
	
	public TileCoordinate getLocation() {
		return location;
	}
	
	public Angle getDirection() {
		return direction;
	}
	
	protected void notifySubscribers() {
		for (MobileListener list : listeners) {
			list.notify(this);
		}
	}
}
