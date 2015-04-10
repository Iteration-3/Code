package model.event;

import java.util.ArrayList;

public class EventManager {
	private static ArrayList<Event> eventList = new ArrayList<Event>();
	
	public static void update() {
		for (Event event : eventList) {
			event.perform();
			if (event.hasExpired()) {
				removeEvent(event);
			}
		}
	}
	
	public static void addEvent(Event event) {
		EventManager.eventList.add(event);
	}
	
	protected static boolean removeEvent(Event event) {
		boolean result = eventList.contains(event);
		eventList.remove(event);
		return result;
	}

}
