package model.trigger;

import java.util.ArrayList;

import model.entity.EntityManager;

public final class TriggerManager {
	private static ArrayList<Trigger> partyTriggers = new ArrayList<Trigger>();
	private static ArrayList<Trigger> nonPartyTriggers = new ArrayList<Trigger>();
	private static ArrayList<Trigger> neutralTriggers = new ArrayList<Trigger>();
	
	public static void update() {
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
	
	private static void removeExpiredTriggers() {
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
	
	public static void addPartyTrigger(Trigger trigger) {
		partyTriggers.add(trigger);
	}

	public static ArrayList<Trigger> getPartyTriggers() {
		return partyTriggers;
	}

	public static void setPartyTriggers(ArrayList<Trigger> partyTriggers) {
		TriggerManager.partyTriggers = partyTriggers;
	}
	
	public static void addNonPartyTrigger(Trigger trigger) {
		nonPartyTriggers.add(trigger);
	}

	public static ArrayList<Trigger> getNonPartyTriggers() {
		return nonPartyTriggers;
	}

	public static void setNonPartyTriggers(ArrayList<Trigger> nonPartyTriggers) {
		TriggerManager.nonPartyTriggers = nonPartyTriggers;
	}
	
	public static void addNeutralTrigger(Trigger trigger) {
		neutralTriggers.add(trigger);
	}

	public static ArrayList<Trigger> getNeutralTriggers() {
		return neutralTriggers;
	}

	public static void setNeutralTriggers(ArrayList<Trigger> neutralTriggers) {
		TriggerManager.neutralTriggers = neutralTriggers;
	}
}
