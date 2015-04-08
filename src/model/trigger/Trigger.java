package model.trigger;

import model.area.Area;
import model.area.Location;
import model.area.RadialArea;
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

    public abstract void handle(Entity entity);

    public abstract void moveLocation(Location location);

    public abstract boolean hasExpired();

}
