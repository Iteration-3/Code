package model.trigger;

import model.area.Area;
import model.area.Location;
import model.event.Event;

public class PermanentTrigger extends Trigger {

    public PermanentTrigger() {
        super();
    }

    public PermanentTrigger(Area area, Event event) {
        super(area, event);
    }

    @Override
    public void moveLocation(Location location) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void handle(Entity entity) {
        // TODO Auto-generated method stub

    }

}
