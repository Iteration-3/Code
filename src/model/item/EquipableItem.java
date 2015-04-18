package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public abstract class EquipableItem extends TakeableItem {
	private Statistics statistics;
	
	public EquipableItem(ItemView itemView) {
		super(itemView);
		this.statistics = new Statistics();
	}
	
	public EquipableItem(ItemView itemView, Statistics statistics) {
		this(itemView);
		this.statistics = statistics;
	}
	
	public EquipableItem(ItemView itemView, Statistics statistics, Price price) {
		this(itemView, statistics);
		setPrice(price);
	}

	public abstract boolean equip(ItemManager itemManager);
	
	public void use(Entity entity) {
		entity.equip(this);
	}
	
	public void merge(Statistics stats){
		stats.merge(this.statistics);
	}
}
