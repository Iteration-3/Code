package model.trigger;

import static org.junit.Assert.*;
import model.area.RadialArea;
import model.event.ManaModifierEvent;

import org.junit.Test;

import utilities.structuredmap.StructuredMap;
import factories.TriggerFactory;

public class TriggerSavingTest {

	@Test
	public void testPermanentTrigger() {
		Trigger trigger = new PermanentTrigger();
		StructuredMap map = trigger.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Trigger triggerTest = TriggerFactory.createTrigger(map);
		
		assertEquals(map.getJson(), triggerTest.getStructuredMap().getJson());
	}
	
	@Test
	public void testPermanentTriggerWithEvent() {
		Trigger trigger = new PermanentTrigger();
		trigger.setEvent(new ManaModifierEvent(10.5, 10));
		StructuredMap map = trigger.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Trigger triggerTest = TriggerFactory.createTrigger(map);
		
		assertEquals(map.getJson(), triggerTest.getStructuredMap().getJson());
		
	}
	
	@Test
	public void testRateLimitedTriggerWithEvent() {
		Trigger trigger = new RateLimitedTrigger(new RadialArea(), new ManaModifierEvent(10.5, 10), 500);
		StructuredMap map = trigger.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Trigger triggerTest = TriggerFactory.createTrigger(map);
		
		assertEquals(map.getJson(), triggerTest.getStructuredMap().getJson());
		
	}
	
	@Test
	public void testSingleUseTriggerWithEvent() {
		Trigger trigger = new SingleUseTrigger();
		trigger.setEvent(new ManaModifierEvent(10.5, 10));
		StructuredMap map = trigger.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Trigger triggerTest = TriggerFactory.createTrigger(map);
		
		assertEquals(map.getJson(), triggerTest.getStructuredMap().getJson());
		
	}
	
	@Test
	public void testTimedTriggerWithEvent() {
		Trigger trigger = new TimedTrigger(new RadialArea(), new ManaModifierEvent(10.5, 10), 250);
		trigger.setEvent(new ManaModifierEvent(10.5, 10));
		StructuredMap map = trigger.getStructuredMap();
		
		System.out.println(map.getJson());
		
		Trigger triggerTest = TriggerFactory.createTrigger(map);
		
		assertNotEquals(map.getJson(), triggerTest.getStructuredMap().getJson());
		
	}

}
