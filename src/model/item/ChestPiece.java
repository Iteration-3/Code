package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class ChestPiece extends EquipableItem {

    public ChestPiece(ItemView itemView, Statistics stats) {
        super(itemView, stats);
    }

    public ChestPiece(ItemView itemView, StructuredMap map) {
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

}
