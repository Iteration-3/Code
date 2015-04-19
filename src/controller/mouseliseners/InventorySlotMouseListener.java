package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Entity;

public class InventorySlotMouseListener implements MouseListener {
	private int location;
	private Entity entity;
	
	public InventorySlotMouseListener(Entity entity,int location){
		this.location = location;
		this.entity = entity;
	}

	public void mouseClicked(MouseEvent e) {
		this.entity.removeItem(location);
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
