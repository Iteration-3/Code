package model.slots;

import view.SlotView;
import view.item.ItemView;
import model.item.EquipableItem;
import model.statistics.Statistics;

public class EquipmentSlot<K extends EquipableItem> {
	private K item;
	private DoubleEquipmentSlot<?, ?, ?> parent;
	private SlotView slotView;

	public EquipmentSlot() {
		this.slotView = new SlotView();
	}

	public boolean has() {
		// TODO need to test that this is what we want to have
		return this.item != null || this.parentHasItem();
	}

	public K get() {
		return this.item;
	}

	public boolean equip(K item) {
		if (this.parentHasItem()) {
			return false;
		} else {
			if (this.has()) {
				return false;
			} else {
				this.item = item;
				this.register();
				return true;
			}
		}
	}

	public K unequip() {
		// just unequip this slot
		K temp = this.item;
		this.item = null;
		this.register();
		return temp;
	}

	public void merge(Statistics stats) {
		if (this.parentHasItem()) {
			this.parent.merge(stats);
		} else if (this.has()) {
			this.item.merge(stats);
		}
	}

	public boolean has(EquipableItem item) {
		// TODO not sure if we need to check the parent here ?
		return this.item == item;
	}

	private boolean hasParent() {
		return this.parent != null;
	}

	private boolean parentHasItem() {
		if (this.hasParent()) {
			return this.parent.has();
		} else {
			return false;
		}
	}

	public void setParentSlot(DoubleEquipmentSlot<?, ?, ?> slot) {
		this.parent = slot;
	}

	public ItemView getItemView() {
		if (has()){
			return this.item.getView();
		}
		else {
			return null;
		}
	}
	
	private void register(){
		if (this.has()) {
			this.slotView.register(this.item.getView());
		}
		else{
			this.slotView.register(null);
		}
	}
	
	public void setView(SlotView slotView){
		this.slotView = slotView;
		this.register();
	}

}
