package model.slots;

import model.item.EquipableItem;
import model.statistics.Statistics;

public class EquipmentSlot <K extends EquipableItem>{
	K item;
	
	public EquipmentSlot(){}
	
	public boolean has(){
		boolean itemIsNotNull = ! (this.item==null);
		return itemIsNotNull;
	}
	
	public K get(){
		return this.item;
	}
	
	public boolean equip(K item){
		if (this.has()){
			return false;
		}
		else{
			this.item = item;
			return true;
		}
	}
	
	public K unequip(){
		K temp = this.item;
		this.item = null;
		return temp;
	}
	
	public void merge(Statistics stats){
		if (this.has()){
			this.item.merge(stats);
		}
	}
	
	public boolean has(EquipableItem item){
		return this.item == item;
	}	

}
