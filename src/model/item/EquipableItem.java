package model.item;

import statistics.Statistics;
import model.entity.Entity;
import model.slots.EquipmentManager;

public abstract class EquipableItem extends TakeableItem {
	private Statistics stats;
	
	public EquipableItem(Statistics stats){
		this.stats = stats;
	}

	public abstract boolean equip(EquipmentManager equipment);
	
	public void use(Entity entity) {
		entity.equipItem(this);
	}
	
	public void merge(Statistics stats){
		stats.merge(this.stats);
	}
}
