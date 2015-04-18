package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Door extends Item {

	private TakeableItem requirement; // required to open the Door
	private boolean open = false;

	public Door(ItemView itemView, TakeableItem requirement) {
		super(itemView);
		this.requirement = requirement;
	}
	
	public Door(ItemView itemView, StructuredMap map) {
	    super(itemView);
	    //TODO this definitely doesn't work
	    //requirement = new TakeableItem(map.getStructuredMap("requirement"));
	}
	
	@Override
	public void touch(Entity entity) {
		use(entity);
		System.out.println(getInfo());
	}

	@Override
	public void use(Entity entity) {
		if (entity.containsItem(requirement)) {
			open = true;
		}
	}

	@Override
	public String getInfo() {
		return "This door is: "
				+ (open ? "Open!" : "Closed...\nDo you have a "
					+ requirement.getInfo() + "?");
	}

	@Override
	public boolean isBlocking() {
		return !open;
	}

	@Override
	public void attemptRemoveFrom(ItemTile itemTile) {
		// TODO Auto-generated method stub
		// Should this be removed if open? 
		if (open) {
			// itemTile.remove(this);
		}
	}

    @Override
    public StructuredMap getStructuredMap() {
        StructuredMap map = new StructuredMap();
        map.put("requirement", requirement.getStructuredMap());
        return map;
    }

}
