package model.event;

import java.util.ArrayList;

public class EventManager {
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	public static void update() {
		for (Event event : eventList) {
			event.perform();
			if (event.hasExpired()) {
				removeEvent(event);
				event.onExpired();
			}
		}
	}
	
	public static void addEvent(Event event) {
		event.onBegin();
		EventManager.eventList.add(event);
	}
	
	protected static boolean removeEvent(Event event) {
		boolean result = eventList.remove(event);
		return result;
	}

}
