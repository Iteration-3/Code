package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class InventorySlotMouseListener implements MouseListener {
	private int location;
	
	public InventorySlotMouseListener(int location){
		this.location = location;
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("the mouse sevent of "+ location);
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
