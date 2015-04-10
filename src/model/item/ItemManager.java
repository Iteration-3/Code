package model.item;

import utilities.structuredmap.SavableLoadable;
import utilities.structuredmap.StructuredMap;

public class ItemManager  implements SavableLoadable {
	private Inventory inventory = new Inventory();//All inventories are the same
	//How are we even doing equipmenet manager?
	/**
	 * UNIMPLEMENTED
	 * @param item
	 * @return
	 */
	public boolean unequip(EquipableItem item){
		return false;
	}
	/**
	 * UNIMPLEMENTED
	 * @param item
	 * @return
	 */
	public boolean equip(EquipableItem item){
		return false;
	}
	
	public boolean removeItem(TakeableItem item){
		return inventory.removeItem(item);
	}
	public boolean addItem(TakeableItem item){
		return inventory.addItem(item);
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
