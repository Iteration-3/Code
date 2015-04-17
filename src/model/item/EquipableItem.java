package model.item;

import model.entity.Entity;
import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public abstract class EquipableItem extends TakeableItem {
	private Statistics stats;
	
	public EquipableItem(ItemView itemView, Statistics stats){
		super(itemView);
		this.stats = stats;
	}

	public abstract boolean equip(EquipmentManager equipment);
	public abstract void unequip(ItemManager im);
	
	public void use(Entity entity) {
		entity.equip(this);
	}
	
	public void merge(Statistics stats){
		stats.merge(this.stats);
	}
}
