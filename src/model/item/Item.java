package model.item;

import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;
import factories.ItemViewFactory;

public abstract class Item implements Saveable{
	protected ItemView itemView;
	
	public Item(ItemView itemView) {
		this.itemView = itemView;
	}
	
	public Item(StructuredMap map) {
		this.itemView = ItemViewFactory.createItemView(map.getStructuredMap("itemView"));
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
	
	public void setVisibility(boolean visibility) {
		getView().setVisibility(visibility);
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("itemView", itemView.getStructuredMap());
		map.put("type", getType());
		return map;
	}
	
	protected abstract String getType();

}
