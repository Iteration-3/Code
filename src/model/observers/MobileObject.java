package model.observers;

import java.util.ArrayList;

import model.area.TileCoordinate;
import utilities.Direction;

public abstract class MobileObject {
	
	private ArrayList<MobileListener> listeners = new ArrayList<MobileListener>();
	private TileCoordinate location;
	private Direction direction;
	
	public MobileObject(TileCoordinate loc) {
		setLocation(loc);
	}
	
	public void subscribe(MobileListener list) {
		listeners.add(list);
		list.notify(this);
	}

	public void unsubscribe(MobileListener list) {
		listeners.remove(list);
	}
	
	public void setLocation(TileCoordinate location) {
		this.location = location;
		notifySubscribers();
	}
	
	public void setDirection(Direction direction) {
		this.direction = direction;
		notifySubscribers();
	}
	
	protected void setLocationNoNotify(TileCoordinate location) {
		this.location = location;
	}
	
	protected void setDirectionNoNotify(Direction direction) {
		this.direction = direction;
	}
	
	public TileCoordinate getLocation() {
		return location;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	protected void notifySubscribers() {
		for (MobileListener list : listeners) {
			list.notify(this);
		}
	}
}
