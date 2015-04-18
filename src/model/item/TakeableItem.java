package model.item;

import javax.swing.JOptionPane;

import utilities.structuredmap.StructuredMap;
import view.item.ItemView;
import model.entity.Entity;
import model.map.tile.ItemTile;

public class TakeableItem extends Item {
	private boolean taken = false;

	public TakeableItem(ItemView itemView) {
		super(itemView);
	}

	public TakeableItem(ItemView itemView, StructuredMap map) {
		super(itemView);
		this.taken = map.getBoolean("taken");
	}

	@Override
	public void touch(Entity entity) {
		if (entity.addItem(this)) {
			taken = true;

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

	@Override
	public void attemptRemoveFrom(ItemTile itemTile) {
		if (taken) {
			itemTile.remove(this);
		}
	}

	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap returnMap = new StructuredMap();
		StructuredMap map = new StructuredMap();
		map.put("taken", taken);
		returnMap.put("takeable", map);
		return returnMap;
	}
}
