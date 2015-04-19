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
		System.out.println("Clikcinsdf");
		if (MouseEvent.BUTTON1 == e.getButton()){
			this.unequipper.unequip(this.entity);
		}
		else if(MouseEvent.BUTTON2 == e.getButton()){
			System.out.println("print thing the ");
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
