package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.entity.Entity;
import model.entity.NPC;
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

	@Override
	public void handle(Collection<NPC> npcs) {
		// TODO Auto-generated method stub
		
	}

}
