package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Helmet extends EquipableItem{
	
	public Helmet(ItemView itemView, String name) {
		super(itemView, name);
	}

	public Helmet(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}
	
	public Helmet(StructuredMap map) {
	    super(map);
	}

	@Override
	public boolean equip(ItemManager itemManager) {
		return itemManager.equipToSlot(this);
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
