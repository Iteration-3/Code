package model.slots;

import view.SlotView;
import view.item.ItemView;
import model.item.TakeableItem;

public class InventorySlot implements Slot{
	private TakeableItem item = null;
	private SlotView slotview;
	
	public InventorySlot(){}
	
	public boolean has(){
		boolean itemIsNotNull = ! (this.item==null);
		return itemIsNotNull;
	}
	
	public TakeableItem get(){
		return this.item;
	}
	
	public void addItem(TakeableItem item){
		//replaces the item no matter what
		this.item = item;
		this.registerWithView();
	}
	
	public TakeableItem removeItem(){
		TakeableItem temp = this.item;
		this.item = null;
		this.registerWithView();
		return temp;
	}
	
	public boolean hasItem(TakeableItem item){
		return this.item == item;
	}
	
	public void setView(SlotView slotView){
		this.slotview = slotView;
		this.registerWithView();
	}
	
	private void registerWithView(){
		if (has()){
			this.slotview.register(this.item.getView());
		}
	}
}
