package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Helmet extends EquipableItem{
	
	public Helmet(ItemView itemView) {
		super(itemView);
	}

	public Helmet(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}
	
	public Helmet(ItemView itemView, StructuredMap map) {
	    super(itemView, map);
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
