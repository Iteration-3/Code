package model.slots;

import model.item.TakeableItem;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.SlotView;
import factories.TakeableItemFactory;

public class InventorySlot implements Slot, Saveable{
	private TakeableItem item = null;
	private SlotView slotview;
	
	public InventorySlot(){}
	
	public InventorySlot(StructuredMap map) {
		this.slotview = new SlotView(map.getStructuredMap("slotView"));
		this.item = TakeableItemFactory.createItem(map.getStructuredMap("item"));
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = new StructuredMap();
		map.put("item", item == null ? null : item.getStructuredMap());
		map.put("slotView",  slotview == null ? null : slotview.getStructuredMap());
		return map;
	}
	
	@Override
	public boolean has(){
		boolean itemIsNotNull = ! (this.item==null);
		return itemIsNotNull;
	}
	
	@Override
	public TakeableItem get(){
		return this.item;
	}
	
	@Override
	public void addItem(TakeableItem item){
		//replaces the item no matter what
		this.item = item;
		this.registerWithView();
	}
	
	@Override
	public TakeableItem removeItem(){
		TakeableItem temp = this.item;
		this.item = null;
		this.registerWithView();
		return temp;
	}
	
	@Override
	public boolean hasItem(TakeableItem item){
		if (has()) {
			return this.item == item;
		}
		return false;
	}
	
	public void setView(SlotView slotView){
		this.slotview = slotView;
		this.registerWithView();
	}
	
	private void registerWithView(){
		if (has()){
			this.slotview.register(this.item.getView());
		}
		else{
			this.slotview.register(null);
		}
	}

	
}
