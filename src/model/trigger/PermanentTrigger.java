package model.trigger;

import model.area.Area;
import model.event.Event;

public class PermanentTrigger extends Trigger {

    public PermanentTrigger() {
        super();
    }

    public PermanentTrigger(Area area, Event event) {
        super(area, event);
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

}
