package model.item;

import model.entity.Entity;
import model.event.EventManager;
import model.event.HealthModifierEvent;
import model.event.LivesModifierEvent;
import model.event.ManaModifierEvent;
import model.event.MovementModifierEvent;
import model.event.StatisticModifierEvent;
import model.statistics.EntityStatistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class ConsumableItem extends TakeableItem {
    private EntityStatistics stats;
    private double duration;

    public ConsumableItem(ItemView itemView, EntityStatistics stats) {
        super(itemView);
        this.stats = stats;
        this.duration = 0.0;
    }

    public ConsumableItem(ItemView itemView, EntityStatistics stats, double duration) {
        super(itemView);
        this.stats = stats;
        this.duration = duration;
    }

    public ConsumableItem(ItemView itemView, StructuredMap map) {
        super(itemView);
        
        this.stats = new EntityStatistics(map.getStructuredMap("stats"));
        this.duration = map.getDouble("duration");
    }

    @Override
    public void use(Entity entity) {
        EventManager.getSingleton().addEvent(new StatisticModifierEvent(stats, entity, duration));
        EventManager.getSingleton().addEvent(new LivesModifierEvent(stats.getLivesLeft(), entity, duration));
        EventManager.getSingleton().addEvent(new HealthModifierEvent(stats.getCurrentHealth(), entity, duration));
        EventManager.getSingleton().addEvent(new MovementModifierEvent(stats.getMovement(), entity, duration));
        EventManager.getSingleton().addEvent(new ManaModifierEvent(stats.getCurrentMana(), entity, duration));
    }

    @Override
    public StructuredMap getStructuredMap() {
    	StructuredMap returnMap = new StructuredMap();
        StructuredMap map = super.getStructuredMap();
        map.put("stats", stats.getStructuredMap());
        map.put("duration", this.duration);
        returnMap.put("consumableItem", map);
        return returnMap;
    }

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
