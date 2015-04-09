package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.area.Location;
import model.area.RadialArea;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;

public abstract class Trigger {
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

    public abstract void handle(Entity entity);

    public abstract void handle(Collection<NPC> npcs);

    public void moveLocation(Location location) {
        this.area.setStartLocation(location);
    }

    public abstract boolean hasExpired();

}
