package model.event;

import java.util.ArrayList;

public class EventManager {
	
	private static EventManager _eventManager = new EventManager();
	private ArrayList<Event> eventList = new ArrayList<Event>();
	
	private EventManager() { }
	
	public static EventManager getSingleton() {
		return _eventManager;
	}
	
	public void update() {
		for (Event event : eventList) {
			event.perform();
			if (event.hasExpired()) {
				removeEvent(event);
				event.onExpired();
			}
		}
	}
	
	public void addEvent(Event event) {
		event.onBegin();
		eventList.add(event);
	}
	
	public boolean removeEvent(Event event) {
		return eventList.remove(event);
	}

}
