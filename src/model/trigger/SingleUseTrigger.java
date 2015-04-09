package model.trigger;

import model.area.Area;
import model.entity.Entity;
import model.event.Event;

public class SingleUseTrigger extends Trigger {

    public SingleUseTrigger() {
        super();
    }

    public SingleUseTrigger(Area area, Event event) {
        super(area, event);
    }

    @Override
    public boolean hasExpired() {
        // TODO verify If I actually return true;
        return true;
    }

    @Override
    public void handle(Entity entity) {
        // TODO Auto-generated method stub

    }

}
