package model.trigger;

import model.area.Area;
import model.entity.Entity;
import model.event.Event;
import utilities.structuredmap.StructuredMap;

public class SingleUseTrigger extends Trigger {
	private boolean triggered = false;

	public SingleUseTrigger() {
		super();
	}

	public SingleUseTrigger(Area area, Event event) {
		super(area, event);
	}

	public SingleUseTrigger(StructuredMap map) {
		super(map);
		triggered = map.getBoolean("hasTriggered");
	}

	@Override
	public boolean hasExpired() {
		return triggered;
	}

	@Override
	public void handle(Entity entity) {
		if (this.isInRange(entity)) {
			this.perform(entity);
			triggered = true;
		}

	}

	@Override
	public SingleUseTrigger clone() {
		SingleUseTrigger singleUseTrigger = new SingleUseTrigger();
		singleUseTrigger.setArea(this.getArea());
		singleUseTrigger.setEvent(this.getEvent().clone());
		return singleUseTrigger;
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("hasTriggered", triggered);
		return map;
	}

	@Override
	protected String getType() {
		return "singleUseTrigger";
	}

}
