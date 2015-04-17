package model.item;

import javax.swing.JOptionPane;

import model.entity.Entity;

public class TakeableItem extends Item {

	@Override
	public void touch(Entity entity) {
		entity.addItem(this);
	}

	@Override
	public void use(Entity entity) {
		JOptionPane.showMessageDialog(null, "Can't use that here...");
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
