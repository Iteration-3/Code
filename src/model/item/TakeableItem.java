package model.item;

import model.entity.Entity;

public abstract class TakeableItem extends Item {

	@Override
	public void touch(Entity entity) {
		entity.addItem(this);
	}
	
}
