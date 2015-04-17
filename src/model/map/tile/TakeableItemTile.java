package model.map.tile;

import java.util.ArrayList;
import java.util.Collection;

import model.entity.Entity;
import model.item.TakeableItem;
import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class TakeableItemTile implements SavableLoadable{
	private Collection<TakeableItem> items = new ArrayList<TakeableItem>();
	public boolean addItem(TakeableItem i){
		return items.add(i);
	}
	public void touch(Entity e){
		//Takes an entity, makes it touch all the items on the square, and then removes
		//those items that get picked up from the map. 
		for(TakeableItem i : items) {
			i.touch(e);
		}
		items.clear();
	}

	public boolean remove(TakeableItem i){
		return items.remove(i);
	}
	/**
	 * UNIMPLEMENTED
	 */
	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * UNIMPLEMENTED
	 */
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}
}
