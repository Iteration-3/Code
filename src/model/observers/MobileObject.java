package model.observers;

import java.util.ArrayList;

import model.area.TileCoordinate;
import utilities.Direction;

public abstract class MobileObject {
	
	private ArrayList<MobileListener> listeners = new ArrayList<MobileListener>();
	private TileCoordinate location;
	private TileCoordinate prevLocation;
	private Direction direction;
	private Direction prevDirection;
	
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
		setLocationNoNotify(location);
		notifySubscribers();
	}
	
	public void setDirection(Direction direction) {
		setDirectionNoNotify(direction);
		notifySubscribers();
	}
	
	protected void setLocationNoNotify(TileCoordinate location) {
		this.prevLocation = this.location;
		this.location = location;
	}
	
	protected void setDirectionNoNotify(Direction direction) {
		this.prevDirection = this.direction;
		this.direction = direction;
	}
	
	public TileCoordinate getLocation() {
		return location;
	}
	
	public Direction getDirection() {
		return direction;
	}
	
	public TileCoordinate getPrevLocation() {
		return prevLocation;
	}
	
	public Direction getPrevDirection() {
		return prevDirection;
	}
	
	protected void notifySubscribers() {
		for (MobileListener list : listeners) {
			list.notify(this);
		}
	}
}
