package model.item;

import statistics.Statistics;
import model.entity.Entity;
import model.slots.EquipmentManager;

public class Boots extends EquipableItem {

	public Boots(Statistics stats) {
		super(stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	@Override
	public void use(Entity entity) {
		entity.equipItem(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
