package model.observers;

import java.util.ArrayList;

import model.area.Area;
import model.area.TileCoordinate;
import utilities.Direction;

public abstract class MobileAreaObject {
	
	private ArrayList<MobileAreaListener> listeners = new ArrayList<MobileAreaListener>();
	private Area area;
	private Area prevArea;
	
	public MobileAreaObject(Area area) {
		setArea(area);
	}
	
	public void subscribe(MobileAreaListener list) {
		listeners.add(list);
	}

	public void unsubscribe(MobileAreaListener list) {
		listeners.remove(list);
	}
	
	public void setArea(Area area) {
		this.prevArea = area;
		this.area = area;
		notifySubscribers();
	}
	
	public Area getArea() {
		return area;
	}
	
	public Area getPrevArea() {
		return prevArea;
	}
	
	protected void setAreaNoNotify(Area area) {
		this.prevArea = area;
		this.area = area;
	}
	
	protected void notifySubscribers() {
		for (MobileAreaListener list : listeners) {
			list.notify(this);
		}
	}
}

