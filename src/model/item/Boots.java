package model.item;

import model.slots.EquipmentManager;
import model.statistics.Statistics;

public class Boots extends EquipableItem {

	public Boots(Statistics stats) {
		super(stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

}
