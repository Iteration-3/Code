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

	@Override
	public void mouseClicked(MouseEvent e) {
		if (MouseEvent.BUTTON1 == e.getButton()){
		}
		else if(MouseEvent.BUTTON3 == e.getButton()){
			unequipper.unequip(entity);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

}
