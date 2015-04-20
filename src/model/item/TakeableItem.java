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
	private String name;

	public TakeableItem(ItemView itemView, String name) {
		super(itemView);
		setPrice(new Price());
		this.name = name;
	}
	
	public TakeableItem(ItemView itemView, Price price, String name) {
		this(itemView, name);
		setPrice(price);
	}

	public TakeableItem(StructuredMap map) {
		super(map);
		this.taken = map.getBoolean("taken");
		this.price = new Price(map.getStructuredMap("price"));
		this.name = map.getString("name");
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
		return name + " ==== " + price;
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
		map.put("name", name);
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TakeableItem other = (TakeableItem) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
}
