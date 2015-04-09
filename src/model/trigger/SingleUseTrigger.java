package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.entity.Entity;
import model.entity.NPC;
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

	@Override
	public void handle(Collection<NPC> npcs) {
		// TODO Auto-generated method stub
		
	}

}