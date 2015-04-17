package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import view.item.ItemView;

public class Door extends Item {

	private TakeableItem requirement; // required to open the Door
	private boolean open = false;

	public Door(ItemView itemView, TakeableItem requirement) {
		super(itemView);
		this.requirement = requirement;
	}
	
	@Override
	public void touch(Entity entity) {
		// Should I do something different on touch()? -- Joe
		use(entity);
	}

	@Override
	public void use(Entity entity) {
		/*
		 * if (entity.containsItem(requirement)) { open = true; }
		 */
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
			itemTile.remove(this);
		}
	}

}
