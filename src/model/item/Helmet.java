package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import view.item.ItemView;

public class Helmet extends EquipableItem{
	
	public Helmet(ItemView itemView) {
		super(itemView);
	}

	public Helmet(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

	public boolean equip(ItemManager itemManager) {
		return itemManager.equipToSlot(this);
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
