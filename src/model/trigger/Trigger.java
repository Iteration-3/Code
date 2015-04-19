package model.trigger;

import factories.AreaFactory;
import factories.EventFactory;
import model.area.Area;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.event.Event;
import model.event.EventManager;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public abstract class Trigger implements Cloneable, Saveable {
    private Area area;
    private Event event;

    public Trigger() {
        area = new RadialArea();
        event = null;
    }

    public Trigger(Area area, Event event) {
        this.area = area;
        this.event = event;
    }
    
    public Trigger(StructuredMap map) {
    	this.area = AreaFactory.createArea(map.getStructuredMap("area"));
    	this.event = EventFactory.createEvent(map.getStructuredMap("event"));
    }

    public Area getArea() {
        return area;
    }

    public void setArea(Area area) {
        this.area = area;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void handle(Entity entity){
    	if(this.isInRange(entity)){
    		this.perform(entity);
    	}
    }
    
    protected void perform(Entity entity){
    	Event event = this.getEvent().clone();
		event.setTarget(entity);
		EventManager.getSingleton().addEvent(event);
    }
    
    protected boolean isInRange(Entity entity){
    	return this.getArea().isInRange(entity.getLocation());
    }

    public void moveLocation(TileCoordinate location) {
        this.area.setStartLocation(location);
    }

    public abstract boolean hasExpired();
    
    public abstract Trigger clone();
    
    public StructuredMap getStructuredMap() {
    	StructuredMap map = new StructuredMap();
    	map.put("area", area.getStructuredMap());
    	map.put("event", event.getStructuredMap());
    	map.put("type", getType());
    	return map;
    }
    
    protected abstract String getType();
}
