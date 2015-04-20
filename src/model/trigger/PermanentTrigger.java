package model.trigger;

import model.area.Area;
import model.event.Event;
import utilities.structuredmap.StructuredMap;

public class PermanentTrigger extends Trigger {

	public PermanentTrigger() {
		super();
	}

	public PermanentTrigger(Area area, Event event) {
		super(area, event);
	}

	public PermanentTrigger(StructuredMap map) {
		super(map);
	}

	@Override
	public boolean hasExpired() {
		return false;
	}

	@Override
	public PermanentTrigger clone() {
		PermanentTrigger permanentTrigger = new PermanentTrigger();
		permanentTrigger.setArea(this.getArea());
		permanentTrigger.setEvent(this.getEvent());
		return permanentTrigger;
	}

	@Override
	protected String getType() {
		return "permanent";
	}

}
