package model.item;

import java.util.ArrayList;
import java.util.List;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

class Inventory implements SavableLoadable{
	private ArrayList<TakeableItem> inventory_ = new ArrayList<TakeableItem>();
	
	public boolean addItem(TakeableItem item){
		return inventory_.add(item);
	}
	public boolean removeItem(TakeableItem item){
		return inventory_.remove(item);
	}
	
	public boolean hasItem(TakeableItem item){
		return inventory_.contains(item);
	}
	public List<TakeableItem> getItems(){
		return inventory_;
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
