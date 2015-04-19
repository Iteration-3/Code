package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Entity;
import model.item.TakeableItem;

public class InventorySlotMouseListener implements MouseListener {
	private int location;
	private Entity entity;
	
	public InventorySlotMouseListener(Entity entity,int location){
		this.location = location;
		this.entity = entity;
	}

	public void mouseClicked(MouseEvent e) {
		if (MouseEvent.BUTTON1 == e.getButton()){
			TakeableItem item = this.entity.removeItem(location);
			if (item != null){
				item.use(this.entity);
			}
		}
		else if (MouseEvent.BUTTON3 == e.getButton()){
			this.entity.removeItem(location);
		}
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

}
