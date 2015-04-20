package model.item;

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
	
	public Helmet(StructuredMap map) {
	    super(map);
	}

	@Override
	public boolean equip(ItemManager itemManager) {
		return itemManager.equipToSlot(this);
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		return map;
	}
	
	@Override
	protected String getType() {
		return "helmet";
	}
	
}
