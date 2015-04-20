package model.item;

import model.slots.ItemManager;
import model.statistics.Statistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Projectile extends EquipableItem{
	
	public Projectile(ItemView itemView) {
		super(itemView);
	}

	public Projectile(ItemView itemView, Statistics statistics) {
		super(itemView, statistics);
	}

    public Projectile(StructuredMap map) {
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
		return "projectile";
	}
}
