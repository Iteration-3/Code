package model.item;

import model.entity.Entity;
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
	
	public Leggings(ItemView itemView, StructuredMap map) {
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
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		StructuredMap returnMap = new StructuredMap();
		returnMap.put("leggings", map);
		return returnMap;
	}

}
