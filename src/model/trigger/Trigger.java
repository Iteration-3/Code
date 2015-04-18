package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.area.RadialArea;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;
import model.event.EventManager;

public abstract class Trigger implements Cloneable {
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
}
