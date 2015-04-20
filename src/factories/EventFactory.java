package factories;

import model.event.Event;
import model.event.ExperienceModifierEvent;
import model.event.FlightEvent;
import model.event.HealthModifierEvent;
import model.event.InstantDeathEvent;
import model.event.LivesModifierEvent;
import model.event.ManaModifierEvent;
import model.event.MovementModifierEvent;
import model.event.PickPocketEvent;
import model.event.RiverPushEvent;
import model.event.StatisticModifierEvent;
import model.event.TeleportEvent;
import model.event.TemporaryMovementModifierEvent;
import utilities.structuredmap.StructuredMap;

public class EventFactory {

	public static Event createEvent(StructuredMap structuredMap) {
		switch (structuredMap.getString("type")) {
		case "experienceModifier":
			return new ExperienceModifierEvent(structuredMap);
		case "flightEvent":
			return new FlightEvent(structuredMap);
		case "healthModifier":
			return new HealthModifierEvent(structuredMap);
		case "instantDeath":
			return new InstantDeathEvent(structuredMap);
		case "livesModifier":
			return new LivesModifierEvent(structuredMap);
		case "manaModifier":
			return new ManaModifierEvent(structuredMap);
		case "movementModifier":
			createMovementModifierEvent(structuredMap);
		case "pickPocket":
			return new PickPocketEvent(structuredMap);
		case "riverPush":
			return new RiverPushEvent(structuredMap);
		case "statisticsModifier":
			return new StatisticModifierEvent(structuredMap);
		case "teleportEvent":
			return new TeleportEvent(structuredMap);
		case "tempMovementEvent":
			return new TemporaryMovementModifierEvent(structuredMap);
		default:
			throw new IllegalArgumentException("Fuck you");
		}
	}

	public static MovementModifierEvent createMovementModifierEvent(
			StructuredMap map) {
		return new MovementModifierEvent(map);
	}

}
