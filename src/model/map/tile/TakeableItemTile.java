package model.map.tile;

import java.util.ArrayList;
import java.util.Collection;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import model.entity.Entity;
import model.item.Item;
import model.item.TakeableItem;

public class TakeableItemTile implements SavableLoadable{
	private Collection<TakeableItem> items = new ArrayList<TakeableItem>();
	public boolean addItem(TakeableItem i){
		return items.add(i);
	}
	public void touch(Entity e){
		//Takes an entity, makes it touch all the items on the square, and then removes
		//those items that get picked up from the map. 
		for(TakeableItem i : items){
			i.touch(e);
			if(e.addItem(i)){
				this.remove(i);
			}
		}
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
