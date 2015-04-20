package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;
import factories.TakeableItemFactory;

public class Door extends Item {

	private TakeableItem requirement; // required to open the Door
	private boolean open = false;

	public Door(ItemView itemView, TakeableItem requirement) {
		super(itemView);
		this.requirement = requirement;
	}
	
	public Door(StructuredMap map) {
	    super(map);
	    //TODO this definitely doesn't work
	    requirement = TakeableItemFactory.createItem(map.getStructuredMap("requirement"));
	}
	
	@Override
	public void touch(Entity entity) {
		use(entity);
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
        StructuredMap map = super.getStructuredMap();
        map.put("requirement", requirement.getStructuredMap());
        System.out.println(map.getJson());
        return map;
    }

	@Override
	protected String getType() {
		return "door";
	}

}
