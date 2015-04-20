package model.entity;

import model.area.TileCoordinate;
import model.entity.dialog.DialogManager;
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
	public void attack() {
	}

	@Override
	public String getType() {
		return "MineSweeper";
	}

	@Override
	public void load(StructuredMap map) {
	}

	@Override
	public void update() {
		System.out.println("YOOOO I'm at " + getLocation().toString());
		EntityManager.getSingleton().removeEntity(this);
	}
	
	@Override
    public boolean addItem(TakeableItem item) {
        return false;
    }
	
	@Override
	public void interact(Avatar avatar) {
		update();
	}
	
	@Override
    public void perform() {
    }
	
	@Override
    public void observe() {
    }

}
