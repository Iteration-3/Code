package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;
import model.event.EventManager;

public class SingleUseTrigger extends Trigger {
	private boolean triggered = false;

    public SingleUseTrigger() {
        super();
    }

    public SingleUseTrigger(Area area, Event event) {
        super(area, event);
    }

    @Override
    public boolean hasExpired() {
    	return triggered;
    }

    @Override
    public void handle(Entity entity) {
    	if(this.isInRange(entity)){
    		this.perform(entity);
    		triggered = true;
    	}
    		
    }

	
	public SingleUseTrigger clone() {
		SingleUseTrigger singleUseTrigger = new SingleUseTrigger();
		singleUseTrigger.setArea(this.getArea());
		singleUseTrigger.setEvent(this.getEvent().clone());
		return singleUseTrigger;
	}

}
