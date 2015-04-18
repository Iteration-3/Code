package model.trigger;

import model.area.Area;
import model.entity.Entity;
import model.event.Event;

public class RateLimitedTrigger extends PermanentTrigger{
	int time;
	long lastOccuredSingle = 0;

	public RateLimitedTrigger(Area area, Event event, int timeInMilli){
		super(area,event);
		this.time = timeInMilli;
	}
	
	@Override
	public void handle(Entity entity) {
		if(this.isInRange(entity) && System.currentTimeMillis()-lastOccuredSingle > time){
			this.perform(entity);
			lastOccuredSingle=System.currentTimeMillis();	
		}

	}
}
