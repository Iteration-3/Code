package model.item;

import model.entity.Entity;
import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;

public class Shield extends EquipableItem{

	public Shield(Statistics stats) {
		super(stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	public void unequip(ItemManager im) {
		im.unequipShield();
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
