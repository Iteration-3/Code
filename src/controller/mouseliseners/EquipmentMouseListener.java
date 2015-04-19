package controller.mouseliseners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import model.entity.Entity;
import controller.commands.Unequip;

public class EquipmentMouseListener implements MouseListener {
	private Unequip unequipper;
	private Entity entity;
	
	public EquipmentMouseListener(Entity entity, Unequip unequipper){
		this.unequipper = unequipper;
		this.entity = entity;
	}

	public void mouseClicked(MouseEvent e) {
		if (MouseEvent.BUTTON1 == e.getButton()){
			System.out.println("Right click to unequip");
		}
		else if(MouseEvent.BUTTON3 == e.getButton()){
			System.out.println("right click");
			unequipper.unequip(entity);
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
