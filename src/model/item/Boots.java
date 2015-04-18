package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Boots extends EquipableItem {

	public Boots(ItemView itemView, Statistics stats) {
		super(itemView, stats);
	}
	
	public Boots(ItemView itemView, StructuredMap map) {
	    super(itemView, map);
	}

	public boolean equip(ItemManager im) {
		return im.equipToSlot(this);
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
		returnMap.put("boots", map);
		return returnMap;
	}

}
