package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Leggings extends EquipableItem{
	
	public Leggings(ItemView itemView) {
		super(itemView);
	}

	public Leggings(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}
	
	public Leggings(StructuredMap map) {
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
		return "leggings";
	}

}
