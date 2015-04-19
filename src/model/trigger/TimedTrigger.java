package model.trigger;

import utilities.structuredmap.StructuredMap;
import model.area.Area;
import model.event.Event;

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
    
    public TimedTrigger(StructuredMap map) {
    	super(map);
    	this.duration = map.getDouble("duration").longValue();
    	this.creationTime = System.currentTimeMillis();
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
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
    
    @Override
    public StructuredMap getStructuredMap() {
    	StructuredMap map = new StructuredMap();
    	map.put("duration", (double)(this.duration - (System.currentTimeMillis() - creationTime)));
    	return map;
    }

	@Override
	protected String getType() {
		return "timedTrigger";
	}

}
