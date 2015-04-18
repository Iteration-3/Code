package model.item;

import model.entity.Entity;
import model.event.EventManager;
import model.event.HealthModifierEvent;
import model.event.LivesModifierEvent;
import model.event.ManaModifierEvent;
import model.event.MovementModifierEvent;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;
import view.item.ItemView;

public abstract class ConsumableItem extends TakeableItem {
	private EntityStatistics statistics;
	private double duration = 0.0;
	
	public ConsumableItem(ItemView itemView) {
		super(itemView);
		this.statistics = new EntityStatistics();
	}

	public ConsumableItem(ItemView itemView, EntityStatistics statistics) {
		super(itemView);
		this.statistics = statistics;
	}
	
	public ConsumableItem(ItemView itemView, EntityStatistics statistics, double duration) {
		super(itemView);
		this.statistics = statistics;
		this.duration = duration;
	}
	
	public ConsumableItem(ItemView itemView, EntityStatistics statistics, double duration, Price price) {
		this(itemView, statistics, duration);
		setPrice(price);
	}

	@Override
	public void use(Entity entity) {
		EventManager.getSingleton().addEvent(new StatisticModifierEvent(statistics, entity, duration));
		EventManager.getSingleton().addEvent(new LivesModifierEvent(statistics.getLivesLeft(), entity, duration));
		EventManager.getSingleton().addEvent(new HealthModifierEvent(statistics.getCurrentHealth(), entity, duration));
		EventManager.getSingleton().addEvent(new MovementModifierEvent(statistics.getMovement(), entity, duration));
		EventManager.getSingleton().addEvent(new ManaModifierEvent(statistics.getCurrentMana(), entity, duration));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
