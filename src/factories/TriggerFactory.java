package factories;

import model.trigger.PermanentTrigger;
import model.trigger.RateLimitedTrigger;
import model.trigger.SingleUseTrigger;
import model.trigger.TimedTrigger;
import model.trigger.Trigger;
import utilities.structuredmap.StructuredMap;
import view.trigger.ViewableTrigger;

public class TriggerFactory {

	public static Trigger createTrigger(StructuredMap map) {
		switch (map.getString("type")) {
		case "permanent":
			return new PermanentTrigger(map);
		case "rateLimited":
			return new RateLimitedTrigger(map);
		case "singleUseTrigger":
			return new SingleUseTrigger(map);
		case "timedTrigger":
			return new TimedTrigger(map);
		case "viewableTrigger":
			return new ViewableTrigger(map);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}

}
