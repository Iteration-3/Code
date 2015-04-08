package model.item;

import model.entity.Entity;
import view.ItemView;

public abstract class Item {
	
	private ItemView itemView;
	
	public abstract void touch(Entity entity);
	public abstract void use(Entity entity);
	public abstract String getInfo();

}
