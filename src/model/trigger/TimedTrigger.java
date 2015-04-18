package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.area.TileCoordinate;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;
import model.event.EventManager;

public class TimedTrigger extends Trigger {
    private long duration = 0;
    private long creationTime = System.currentTimeMillis();

    public TimedTrigger() {
        super();
    }

    public TimedTrigger(Area area, Event event, long duration) {
        super(area, event);
        this.duration = duration;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public void handle(Entity entity) {
    	TileCoordinate entityLocation = entity.getLocation();
    	if (this.getArea().isInRange(entityLocation)) {
    		Event event = this.getEvent().clone();
    		event.setTarget(entity);
    		EventManager.getSingleton().addEvent(event);
    	}
    }

	@Override
	public void handle(Collection<NPC> npcs) {
		for (NPC npc : npcs) {
			handle(npc);
		}
	}

    @Override
    public boolean hasExpired() {
        return System.currentTimeMillis() > (creationTime + this.duration);
    }
    
    public TimedTrigger clone() {
    	TimedTrigger timedTrigger = new TimedTrigger();
    	timedTrigger.setArea(this.getArea());
    	timedTrigger.setDuration(this.getDuration());
    	timedTrigger.setEvent(this.getEvent().clone());
    	return timedTrigger;
    }

}
