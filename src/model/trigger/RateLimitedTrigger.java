package model.trigger;

import utilities.structuredmap.StructuredMap;
import model.area.Area;
import model.entity.Entity;
import model.event.Event;

public class RateLimitedTrigger extends PermanentTrigger{
	private int time;
	private long lastOccuredSingle = 0;

	public RateLimitedTrigger(Area area, Event event, int timeInMilli){
		super(area,event);
		this.time = timeInMilli;
	}
	
	public RateLimitedTrigger(StructuredMap map) {
		super(map);
		this.time = map.getInteger("time");
		this.lastOccuredSingle = map.getDouble("lastOccuredSingle").longValue();
	}
	
	@Override
	public void handle(Entity entity) {
		if(this.isInRange(entity) && System.currentTimeMillis()-lastOccuredSingle > time){
			this.perform(entity);
			lastOccuredSingle=System.currentTimeMillis();	
		}
	}
	
	@Override 
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("time", time);
		map.put("lastOccuredSingle", (double) lastOccuredSingle);
		return map;
	}
	
	@Override
	protected String getType() {
		return "rateLimited";
	}
}
