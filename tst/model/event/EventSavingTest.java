package model.event;

import static org.junit.Assert.assertEquals;
import model.entity.Summoner;
import model.map.GameMap;
import model.map.ItemMap;
import model.statistics.Statistics;

import org.junit.Test;

import utilities.Direction;
import utilities.structuredmap.StructuredMap;
import factories.EventFactory;
import gameactions.GameActionRiverPush;

public class EventSavingTest {

	@Test
	public void testHealthModifierEvent() {
		Event event = new HealthModifierEvent(new Summoner(), new Summoner(), 10, 3);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testExperienceModifierEvent() {
		Event event = new ExperienceModifierEvent(new Summoner(), 10, 3);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testInstantDeathEvent() {
		Event event = new InstantDeathEvent(25);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testFlightEvent() {
		Event event = new FlightEvent(50);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testInvisibilityEvent() {
		Event event = new InvisiblityEvent(50);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testLivesModifierEvent() {
		Event event = new LivesModifierEvent(50.0, 39);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testManaModifierEvent() {
		Event event = new ManaModifierEvent(50.0, 39);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testMovementModifierEvent() {
		Event event = new MovementModifierEvent(50.0, 39);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testPickPocketEvent() {
		Event event = new PickPocketEvent();
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testRiverPushEvent() {
		Event event = new RiverPushEvent(new GameActionRiverPush(new Summoner(), new GameMap(), new ItemMap(), Direction.UP));
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testStatisticsModifierEvent() {
		Event event = new StatisticModifierEvent(new Statistics(), 50);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}
	
	@Test
	public void testTempMovementModifierEvent() {
		Event event = new TemporaryMovementModifierEvent(54, 50);
		StructuredMap map = event.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Event testEvent = EventFactory.createEvent(map);
		
		assertEquals(map.getJson(), testEvent.getStructuredMap().getJson());
	}

}
