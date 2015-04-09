package model.trigger;

import model.area.Area;
import model.entity.Entity;
import model.event.Event;

public class PermanentTrigger extends Trigger {

    public PermanentTrigger() {
        super();
    }

    public PermanentTrigger(Area area, Event event, long duration) {
        super(area, event);
    }

    @Override
    public boolean hasExpired() {
        return false;
    }

    @Override
    public void handle(Entity entity) {
        // TODO Auto-generated method stub

    }

}
