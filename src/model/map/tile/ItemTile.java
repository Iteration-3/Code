package model.map.tile;

import java.util.ArrayList;
import java.util.Collection;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;
import model.entity.Entity;
import model.item.Item;

public class ItemTile implements SavableLoadable{
	private Collection<Item> items = new ArrayList<Item>();
	public boolean addItem(Item i){
		return items.add(i);
	}
	public void touch(Entity e){
		for(Item i : items){
			i.touch(e);
		}
	}
	public boolean remove(Item i){
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
