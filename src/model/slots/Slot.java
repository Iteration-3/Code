package model.slots;

import model.item.TakeableItem;

public interface Slot {
	
	public boolean has();	
	public TakeableItem get();	
	public void addItem(TakeableItem item);	
	public TakeableItem removeItem();	
	public boolean hasItem(TakeableItem item);
}
