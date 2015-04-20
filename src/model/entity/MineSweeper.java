package model.entity;

import model.area.TileCoordinate;
import model.item.TakeableItem;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;

public class MineSweeper extends NPC {
	
	public MineSweeper(TileCoordinate location) {
		super();
		this.setLocation(location);
	}

	@Override
	protected ItemManager createItemManager() {
		return null;
	}


	@Override
	public String getType() {
		return "MineSweeper";
	}

	@Override
	public void load(StructuredMap map) {
	}
	
	@Override
    public boolean addItem(TakeableItem item) {
        return false;
    }
	
	@Override
	public void interact(Entity entity) {
		update(0);
	}

}
