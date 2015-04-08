package model.slots;

import model.item.TakeableItem;

public class InventorySlot {
	private TakeableItem item = null;
	
	public InventorySlot(){}
	
	public boolean has(){
		boolean itemIsNotNull = ! (this.item==null);
		return itemIsNotNull;
	}
	
	public TakeableItem get(){
		return this.item;
	}
	
	public void insert(TakeableItem item){
		this.item = item;
	}
	
	public TakeableItem remove(){
		TakeableItem temp = this.item;
		this.item = null;
		return temp;
	}
	
	public boolean hasItem(TakeableItem item){
		return this.item == item;
	}
}
