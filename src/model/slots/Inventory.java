package model.slots;

import model.item.TakeableItem;
import utilities.structuredmap.Saveable;
import utilities.structuredmap.StructuredMap;
import view.InventoryView;
import view.SlotView;

public class Inventory implements Saveable {
	private static final int ROW = 5;
	private static final int COL = 5;
	private InventorySlot[] slots;
	private InventoryView inventoryView;
	
	public Inventory(){
		this.inventoryView = new InventoryView();
		this.setInventory();
	}

	private void setInventory(){
		this.slots = new InventorySlot[ROW*COL];
		for (int i = 0 ; i < (ROW* COL); i++){
			this.setSlot(i);
		}
	}
	
	private void setSlotView(int index){
		SlotView slotView = new SlotView();
		this.slots[index].setView(slotView);
		this.inventoryView.register(slotView, index);
	}
	
	private void setSlot(int index){
		slots[index] = new InventorySlot();
		this.setSlotView(index);
	}

	private boolean findAndEquip(TakeableItem item){
		for (int i = 0 ; i < (ROW * COL); i++){
			boolean slotDoesNotHave = ! this.slotHas(i);
			if (slotDoesNotHave){
				this.insertItem(i,item);
				return true;
			}
		}
		return false;
	}

	// this is private because it forces a insert,  can cause RTE
	private void insertItem(int index,TakeableItem item){
		this.slots[index].addItem(item);
	}
	
	//takeItem will take the item from the contianer,  this will remove the item from the SLots
	private TakeableItem takeItem(TakeableItem item) throws Exception{
		for (int i = 0 ; i < (ROW * COL); i++){
				if (this.slotHasItem(item, i)){
					return this.removeItem(i);
			}
		}
		throw new Exception("You dont have that Item in the Inventory");
	}
	
	/********************DIMENSIONS**************************/
	public int getRows(){
		return Inventory.ROW;
	}
	public int getCols(){
		return Inventory.COL;
	}
	/********************INSERTS****************************/
	public boolean addItem(TakeableItem item){
		return this.findAndEquip(item);
	}
	
	public boolean addItem( int index, TakeableItem item){
		if (this.slotHas(index)){
			return false;
		}
		else{
			this.insertItem(index,item);
			return true;
		}
	}
	
	/********************HAS*********************************/
	public boolean slotHas(int index){
		return this.slots[index].has();
	}

	public boolean slotHasItem(TakeableItem item,int index){
		return this.slots[index].hasItem(item);
	}
	
	public boolean hasEmptySlot(){
		for (int i = 0 ; i < (ROW * COL); i++){
			if (! this.slotHas(i)){
				return true;
			}
		}
		return false;
	}
	
	//tells you whether there is a item in the Slots
	public boolean hasItem(TakeableItem item){
		for (InventorySlot in : slots){
			if(in.hasItem(item))
				return true;
		}
		return false;
	}

	/*************REMOVE********************************************/
	public TakeableItem removeItem(TakeableItem item) throws Exception{
		return this.takeItem(item);
	}
	
	public TakeableItem removeItem(int index){
		return this.slots[index].removeItem();
	}
	
	/**********************GETTERS*************************************/
	public TakeableItem[] getItems(){
		TakeableItem[] items = new TakeableItem[ROW*COL];
		for (int i = 0 ; i < (ROW *COL); i++){
				items[i] = this.get(i);
		}
		return items;
	}
	
	public TakeableItem get(int index){
		return this.slots[index].get();
	}
	
	public InventoryView getView(){
		return this.inventoryView;
	}

    @Override
    public StructuredMap getStructuredMap() {
        // TODO Auto-generated method stub
        return null;
    }
}
