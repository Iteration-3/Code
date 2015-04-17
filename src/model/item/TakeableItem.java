package model.item;

import javax.swing.JOptionPane;

import view.item.ItemView;
import model.entity.Entity;

public class TakeableItem extends Item {

	public TakeableItem(ItemView itemView) {
		super(itemView);
	}

	@Override
	public void touch(Entity entity) {
		if (entity.addItem(this)) {
			// Remove the view from the map somehow...
			itemView.removeFromMap();
		}
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
