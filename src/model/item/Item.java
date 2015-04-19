package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.Saveable;
import view.item.ItemView;

public abstract class Item implements Saveable{
	protected ItemView itemView;
	
	public Item(ItemView itemView) {
		this.itemView = itemView;
	}
	
	public abstract void touch(Entity entity);
	public abstract void use(Entity entity);
	public abstract String getInfo();
	
	// Referring to Blocking of Movement.
	// Missing in Spec, but it is in the ItemBlocking UML Digram
	public boolean isBlocking() {
		return false;
	}
	
	// I am brainstorming on whether this is the way to remove the Item
	// From the ItemTile.
	// When Items are added to the Inventory, there is nothing notifying 
	// the tile that the Items have been removed. 
	public abstract void attemptRemoveFrom(ItemTile itemTile);
	
	public ItemView getView(){
		return this.itemView;
	}

}
