package model.observers;

import java.util.ArrayList;

import model.area.TileCoordinate;

public abstract class MobileObject {
	
	private ArrayList<MobileListener> listeners = new ArrayList<MobileListener>();
	private TileCoordinate location;
	
	public MobileObject(TileCoordinate loc) {
		setLocation(loc);
	}
	
	public void subscribe(MobileListener list) {
		listeners.add(list);
	}
	
	public void setLocation(TileCoordinate location) {
		this.location = location;
		for (MobileListener list : listeners) {
			list.notify(this);
		}
	}

	public TileCoordinate getLocation() {
		return location;
	}
}
