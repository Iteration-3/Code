package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class ChestPiece extends EquipableItem {
	
	public ChestPiece(ItemView itemView, String name) {
		super(itemView, name);
	}

	public ChestPiece(ItemView itemView, Statistics statistics, String name) {
		super(itemView, statistics, name);
	}

    public ChestPiece(StructuredMap map) {
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
		return "chestPiece";
	}


}
