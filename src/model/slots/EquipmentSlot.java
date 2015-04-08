package model.slots;

import model.item.Equipable;

public class EquipmentSlot <K extends Equipable>{
	K item;
	
	public EquipmentSlot(){}
	
	public boolean has(){
		boolean itemIsNotNull = ! (this.item==null);
		return itemIsNotNull;
	}
	
	public K get(){
		return this.item;
	}
	
	public void equip(K item){
		this.item = item;
	}
	
	public K unequip(){
		K temp = this.item;
		this.item = null;
		return temp;
	}
	
	public boolean has(K item){
		return this.item == item;
	}	

}
