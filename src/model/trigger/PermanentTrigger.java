package model.trigger;

import utilities.structuredmap.StructuredMap;
import model.area.Area;
import model.event.Event;

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
