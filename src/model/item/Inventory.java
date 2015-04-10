package model.item;

import java.util.ArrayList;
import java.util.List;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

class Inventory implements SavableLoadable{
	private ArrayList<TakeableItem> inventory = new ArrayList<TakeableItem>();
	
	public boolean addItem(TakeableItem item){
		return inventory.add(item);
	}
	public boolean removeItem(TakeableItem item){
		return inventory.remove(item);
	}
	
	public boolean hasItem(TakeableItem item){
		return inventory.contains(item);
	}
	public List<TakeableItem> getItems(){
		return inventory;
	}
	
	/**
	 * Unimplemented
	 */
	@Override
	public StructuredMap getStructuredMap() {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * unimplemented
	 */
	@Override
	public void load(StructuredMap map) {
		// TODO Auto-generated method stub
		
	}

}
