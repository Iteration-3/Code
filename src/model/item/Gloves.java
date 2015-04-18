package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class Gloves extends EquipableItem{

	public Gloves(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}

	public boolean equip(ItemManager im) {
		return im.equip(this);
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
