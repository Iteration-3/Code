package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public abstract class EquipableItem extends TakeableItem {
	private Statistics statistics;
	
	public EquipableItem(ItemView itemView, String name) {
		super(itemView, name);
		this.statistics = new Statistics();
	}
	
	public EquipableItem(ItemView itemView, Statistics statistics, String name) {
		this(itemView, name);
		this.statistics = statistics;
	}
	
	public EquipableItem(ItemView itemView, Statistics statistics, Price price, String name) {
		this(itemView, statistics, name);
		setPrice(price);
	}
	
	public EquipableItem(StructuredMap map) {
	    super(map);
	    this.statistics = new Statistics(map.getStructuredMap("stats"));
	}
	
	public abstract boolean equip(ItemManager itemManager);
	
	@Override
	public void use(Entity entity) {
		System.out.println(entity);
		entity.equip(this);
	}
	
	public void merge(Statistics stats){
		stats.merge(this.statistics);
	}
	
	@Override
	public StructuredMap getStructuredMap() {
	    StructuredMap map = super.getStructuredMap();
	    map.put("stats", statistics.getStructuredMap());
	    return map;
	}

}
