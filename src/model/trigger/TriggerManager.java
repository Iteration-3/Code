package model.trigger;

import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CopyOnWriteArrayList;

import factories.TriggerFactory;
import model.entity.Entity;
import model.entity.EntityManager;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;

public final class TriggerManager implements Saveable {
	
	private static TriggerManager _triggerManager = new TriggerManager();
	private CopyOnWriteArrayList<Trigger> partyTriggers = new CopyOnWriteArrayList<Trigger>();
	private CopyOnWriteArrayList<Trigger> nonPartyTriggers = new CopyOnWriteArrayList<Trigger>();
	private CopyOnWriteArrayList<Trigger> neutralTriggers = new CopyOnWriteArrayList<Trigger>();
	
	private TriggerManager() { }
	
	public static TriggerManager getSingleton() {
		return _triggerManager;
	}
	
	public void loadTriggers(StructuredMap map) {
		partyTriggers = new CopyOnWriteArrayList<Trigger>();
		nonPartyTriggers = new CopyOnWriteArrayList<Trigger>();
		neutralTriggers = new CopyOnWriteArrayList<Trigger>();
		
		StructuredMap[] partyTriggerMap = map.getStructuredMapArray("partyTrigger");
		StructuredMap[] nonPartyTriggerMap = map.getStructuredMapArray("nonPartyTrigger");
		StructuredMap[] neutralTriggerMap = map.getStructuredMapArray("neutralTrigger");
		
		for(StructuredMap tempMap : partyTriggerMap) {
			partyTriggers.add(TriggerFactory.createTrigger(tempMap));
		}
		
		for(StructuredMap tempMap : nonPartyTriggerMap) {
			nonPartyTriggers.add(TriggerFactory.createTrigger(tempMap));
		}
		
		for(StructuredMap tempMap : neutralTriggerMap) {
			neutralTriggers.add(TriggerFactory.createTrigger(tempMap));
		}
		
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		StructuredMap[] partyTriggerMap = new StructuredMap[partyTriggers.size()];
		StructuredMap[] nonPartyTriggerMap = new StructuredMap[nonPartyTriggers.size()];
		StructuredMap[] neutralTriggerMap = new StructuredMap[neutralTriggers.size()];
		
		
		for(int i = 0; i < partyTriggerMap.length; i++) {
			partyTriggerMap[i] = partyTriggers.get(i).getStructuredMap();
		}
		
		for(int i = 0 ; i < nonPartyTriggerMap.length; i++) {
			nonPartyTriggerMap[i] = nonPartyTriggers.get(i).getStructuredMap();
		}
		
		for(int i = 0; i < neutralTriggerMap.length; i++) {
			neutralTriggerMap[i] = neutralTriggers.get(i).getStructuredMap();
		}
		
		map.put("partyTrigger", partyTriggerMap);
		map.put("nonPartyTrigger", nonPartyTriggerMap);
		map.put("neutralTrigger", neutralTriggerMap);
		
		return map;
	}
	
	
	
	public void update(double deltaTime) {
		for (Trigger t : partyTriggers) {
			for(Entity i : EntityManager.getSingleton().getPartyNpcs()){
				t.handle(i);
			}
		}
		for (Trigger t : nonPartyTriggers) {
			for(Entity i : EntityManager.getSingleton().getNonPartyNpcs()){
				t.handle(i);
			}
			t.handle(EntityManager.getSingleton().getAvatar());
		}
		for (Trigger t : neutralTriggers) {
			for(Entity i : EntityManager.getSingleton().getNonPartyNpcs()){
				t.handle(i);
			}
			for(Entity i : EntityManager.getSingleton().getPartyNpcs()){
				t.handle(i);
			}
			t.handle(EntityManager.getSingleton().getAvatar());
		}
		removeExpiredTriggers();
	}
	
	public void removeTrigger(Trigger trigger) {
		// This works, don't question it.
		partyTriggers.remove(trigger);
		nonPartyTriggers.remove(trigger);
		neutralTriggers.remove(trigger);
	}
	
	private void removeExpiredTriggers() {
		for (Trigger t : partyTriggers) {
			if (t.hasExpired()) {
				partyTriggers.remove(t);
			}
		}
		for (Trigger t : nonPartyTriggers) {
			if (t.hasExpired()) {
				nonPartyTriggers.remove(t);
			}
		}
		for (Trigger t : neutralTriggers) {
			if (t.hasExpired()) {
				neutralTriggers.remove(t);
			}
		}
	}
	
	public void addPartyTrigger(Trigger trigger) {
		partyTriggers.add(trigger);
	}

	public Collection<Trigger> getPartyTriggers() {
		return Collections.unmodifiableCollection(partyTriggers);
	}
	
	public void addNonPartyTrigger(Trigger trigger) {
		nonPartyTriggers.add(trigger);
	}

	public Collection<Trigger> getNonPartyTriggers() {
		return Collections.unmodifiableCollection(nonPartyTriggers);
	}
	
	public void addNeutralTrigger(Trigger trigger) {
		neutralTriggers.add(trigger);
	}

	public Collection<Trigger> getNeutralTriggers() {
		return Collections.unmodifiableCollection(neutralTriggers);
	}
	
	public void clear() {
		partyTriggers = new CopyOnWriteArrayList<Trigger>();
		nonPartyTriggers = new CopyOnWriteArrayList<Trigger>();
		neutralTriggers = new CopyOnWriteArrayList<Trigger>();
	}

	
}
