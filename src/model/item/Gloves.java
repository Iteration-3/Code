package model.item;

import model.entity.Entity;
import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Gloves extends EquipableItem {

    public Gloves(ItemView itemView, Statistics stats) {
        super(itemView, stats);
    }

    public Gloves(ItemView itemView, StructuredMap map) {
        super(itemView, map);
    }

    public boolean equip(ItemManager im) {
        return im.equipToSlot(this);
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

}
