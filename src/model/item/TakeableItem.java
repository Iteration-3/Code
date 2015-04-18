package model.item;

import javax.swing.JOptionPane;

import view.item.ItemView;
import model.entity.Avatar;
import model.entity.Entity;
import model.map.tile.ItemTile;

public abstract class TakeableItem extends Item {
	private boolean taken = false;
	private Price price;

	public TakeableItem(ItemView itemView) {
		super(itemView);
		setPrice(new Price());
	}
	
	public TakeableItem(ItemView itemView, Price price) {
		this(itemView);
		setPrice(price);
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
	
	public int getBarteredCost(Avatar avatar) {
		return getPrice().getBarteredCost(avatar);
	}
	
	protected Price getPrice() {
		return this.price;
	}
	
	protected void setPrice(Price price) {
		this.price = price;
	}
	
}
