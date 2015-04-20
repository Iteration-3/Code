package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Shield extends EquipableItem{
	
	public Shield(ItemView itemView, String name) {
		super(itemView, name);
	}

	public Shield(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}

    public Shield(StructuredMap map) {
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
		return "shield";
	}

}
