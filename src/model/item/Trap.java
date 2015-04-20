package model.item;

import model.entity.Entity;
import model.event.Event;
import model.map.tile.ItemTile;
import view.item.ItemView;

public class Trap extends Item {
	private Event event;
	
	public Trap(ItemView itemView) {
		super(itemView);
		setEvent(event);
	}
	
	public Trap(ItemView itemView, Event event) {
		super(itemView);
		setEvent(event);
	}

	@Override
	public void touch(Entity entity) {
		event.setTarget(entity);
		event.placeOnEventManager();
		getView().toggle();
	}

	@Override
	public void use(Entity entity) {
	}

	@Override
	public String getInfo() {
		return "This is a trap";
	}

	@Override
	public void attemptRemoveFrom(ItemTile itemTile) {
		itemTile.remove(this);
	}

	@Override
	protected String getType() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private void setEvent(Event event) {
		this.event = event;
	}

}
