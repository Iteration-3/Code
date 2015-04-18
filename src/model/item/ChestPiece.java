package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class ChestPiece extends EquipableItem {
	
	public ChestPiece(ItemView itemView) {
		super(itemView);
	}

	public ChestPiece(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

    public ChestPiece(ItemView itemView, StructuredMap map) {
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

}
