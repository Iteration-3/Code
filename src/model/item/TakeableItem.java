package model.item;

import javax.swing.JOptionPane;

import model.entity.Avatar;
import model.entity.Entity;
import model.map.tile.ItemTile;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class TakeableItem extends Item {
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

	public TakeableItem(StructuredMap map) {
		super(map);
		this.taken = map.getBoolean("taken");
		this.price = new Price(map.getStructuredMap("price"));
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
		entity.addItem(this);
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
		StructuredMap map = super.getStructuredMap();
		map.put("taken", taken);
		map.put("price", getPrice().getStructuredMap());
		return map;
	}
	
	@Override
	protected String getType() {
		return "takeable";
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
