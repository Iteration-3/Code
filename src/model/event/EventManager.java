package model.event;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class EventManager {
	
	private static EventManager eventManager = new EventManager();
	private List<Event> eventList = new CopyOnWriteArrayList<Event>();
	
	private EventManager() { 
		
	}
	
	public static EventManager getSingleton() {
		return eventManager;
	}
	
	public void update(float deltaTime) {
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
