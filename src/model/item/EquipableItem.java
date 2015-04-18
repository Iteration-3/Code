package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public abstract class EquipableItem extends TakeableItem {
	private Statistics stats;
	
	public EquipableItem(ItemView itemView, Statistics stats){
		super(itemView);
		this.stats = stats;
	}
	
	public EquipableItem(ItemView itemView, StructuredMap map) {
	    super(itemView, map.getStructuredMap("takeable"));
	    this.stats = new Statistics(map.getStructuredMap("stats"));
	}

	public abstract boolean equip(ItemManager im);
	
	public void use(Entity entity) {
		entity.equip(this);
	}
	
	public void merge(Statistics stats){
		stats.merge(this.stats);
	}
	
	@Override
	public StructuredMap getStructuredMap() {
	    StructuredMap map = super.getStructuredMap();
	    map.put("stats", stats.getStructuredMap());
	    return map;
	}
}
