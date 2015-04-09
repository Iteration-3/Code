package model.trigger;

import java.util.Collection;

import model.area.Area;
import model.entity.Entity;
import model.entity.NPC;
import model.event.Event;

public class TimedTrigger extends Trigger {

    private long duration;
    private long creationTime = System.currentTimeMillis();

    public TimedTrigger() {
        super();
    }

    public TimedTrigger(Area area, Event event) {
        super(area, event);
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    @Override
    public void handle(Entity entity) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean hasExpired() {
        return System.currentTimeMillis() > (creationTime + this.duration);
    }

	@Override
	public void handle(Collection<NPC> npcs) {
		// TODO Auto-generated method stub
		
	}

}