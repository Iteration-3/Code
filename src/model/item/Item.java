package model.item;

import model.entity.Entity;
import view.ItemView;

public abstract class Item {
	
	protected ItemView itemView;
	
	public abstract void touch(Entity entity);
	public abstract void use(Entity entity);
	public abstract String getInfo();
	
	// Referring to Blocking of Movement.
	// Missing in Spec, but it is in the ItemBlocking UML Digram
	public boolean isBlocking() {
		return false;
	}

}
