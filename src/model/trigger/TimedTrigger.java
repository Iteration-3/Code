package model.trigger;

import model.area.Area;
import model.event.Event;
import utilities.structuredmap.StructuredMap;

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
    	StructuredMap map = super.getStructuredMap();
    	map.put("duration", (double)((creationTime + this.duration) - System.currentTimeMillis()));
    	return map;
    }

	@Override
	protected String getType() {
		return "timedTrigger";
	}

}
