package view;

import java.util.HashMap;

public class InventoryView {
	private HashMap<Integer,SlotView> slots;
	
	public InventoryView(){
		this.slots = new HashMap<Integer,SlotView>();
	}
	
	
	public void register(SlotView[] slotViews){
		this.slots = new HashMap<Integer,SlotView>();
		for (int i= 0; i< slotViews.length ; i ++){
			this.slots.put(i,slotViews[i]);
		}
	}
	
	public void register(SlotView slotView, int location){
		slots.put(location, slotView);
	}
	
}
