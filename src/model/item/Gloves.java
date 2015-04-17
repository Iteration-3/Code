package model.item;

import model.entity.Entity;
import model.slots.EquipmentManager;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class Gloves extends EquipableItem{

	public Gloves(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	public boolean equip(EquipmentManager equipment) {
		return equipment.equip(this);
	}

	public void unequip(ItemManager im) {
		im.unequipGloves();
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
