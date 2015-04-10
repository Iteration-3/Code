package model.item;

import statistics.Statistics;
import model.entity.Entity;
import model.slots.EquipmentManager;

public class Shield extends EquipableItem{

	public Shield(Statistics stats) {
		super(stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	@Override
	public void use(Entity entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
