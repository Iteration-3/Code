package model.item;

import model.entity.Entity;
import model.event.EventManager;
import model.event.HealthModifierEvent;
import model.event.LivesModifierEvent;
import model.event.ManaModifierEvent;
import model.event.MovementModifierEvent;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;

public class ConsumableItem extends TakeableItem {
	private EntityStatistics stats;
	private double duration;

	public ConsumableItem(EntityStatistics stats) {
		this.stats = stats;
		this.duration = 0.0;
	}
	
	public ConsumableItem(EntityStatistics stats, double duration) {
		this.stats = stats;
		this.duration = duration;
	}

	@Override
	public void use(Entity entity) {
		EventManager.addEvent(new StatisticModifierEvent(stats, entity, duration));
		EventManager.addEvent(new LivesModifierEvent(stats.getLivesLeft(), entity, duration));
		EventManager.addEvent(new HealthModifierEvent(stats.getCurrentHealth(), entity, duration));
		EventManager.addEvent(new MovementModifierEvent(stats.getMovement(), entity, duration));
		EventManager.addEvent(new ManaModifierEvent(stats.getCurrentMana(), entity, duration));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
