package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Gloves extends EquipableItem{
	
	public Gloves(ItemView itemView) {
		super(itemView);
	}

	public Gloves(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

    public Gloves(ItemView itemView, StructuredMap map) {
        super(itemView, map);
    }

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
		return "gloves";
	}

}
