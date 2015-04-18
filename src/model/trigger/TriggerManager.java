package model.trigger;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import model.entity.EntityManager;

public final class TriggerManager {
	
	private static TriggerManager _triggerManager = new TriggerManager();
	private ArrayList<Trigger> partyTriggers = new ArrayList<Trigger>();
	private ArrayList<Trigger> nonPartyTriggers = new ArrayList<Trigger>();
	private ArrayList<Trigger> neutralTriggers = new ArrayList<Trigger>();
	
	private TriggerManager() { }
	
	public static TriggerManager getSingleton() {
		return _triggerManager;
	}
	
	public void update() {
		for (Trigger t : partyTriggers) {
			t.handle(EntityManager.getSingleton().getPartyNpcs());
		}
		for (Trigger t : nonPartyTriggers) {
			t.handle(EntityManager.getSingleton().getNonPartyNpcs());
			t.handle(EntityManager.getSingleton().getAvatar());
		}
		for (Trigger t : neutralTriggers) {
			t.handle(EntityManager.getSingleton().getPartyNpcs());
			t.handle(EntityManager.getSingleton().getNonPartyNpcs());
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
}
