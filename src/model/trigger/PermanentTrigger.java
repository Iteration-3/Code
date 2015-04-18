package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;
import model.event.EventManager;

public class PermanentTrigger extends Trigger {

    public PermanentTrigger() {
        super();
    }

    public PermanentTrigger(Area area, Event event) {
        super(area, event);
    }

    @Override
    public boolean hasExpired() {
        return false;
    }
 


	@Override
	public void handle(Collection<NPC> npcs) {
		for (NPC npc : npcs) {
			handle(npc);
		}
	}
	
	public PermanentTrigger clone() {
		PermanentTrigger permanentTrigger = new PermanentTrigger();
		permanentTrigger.setArea(this.getArea());
		permanentTrigger.setEvent(this.getEvent());
		return permanentTrigger;
	}

}
