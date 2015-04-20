package model.item;

import model.entity.Entity;
import model.event.Event;
import model.event.TemporaryMovementModifierEvent;
import model.map.ItemMap;
import model.map.tile.ItemTile;
import model.slots.ItemManager;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;
import factories.EventFactory;

public class Trap extends Item {
	private Event event;
	
	public Trap(ItemView itemView) {
		super(itemView);
		Event event = new TemporaryMovementModifierEvent(20, -100000);
		setEvent(event);
		this.itemView.setVisibility(false);
	}
	
	public Trap(ItemView itemView, Event event) {
		this(itemView);
		setEvent(event);
	}

	public Trap(StructuredMap structuredMap) {
		super(structuredMap);
		this.event = EventFactory.createEvent(structuredMap.getStructuredMap("event"));
	}
	
	@Override
	public StructuredMap getStructuredMap() {
		StructuredMap map = super.getStructuredMap();
		map.put("event", event.getStructuredMap());
		return map;
	}

	@Override
	public void touch(Entity entity) {
		System.out.println("TRAPP");
		event.setTarget(entity);
		event.placeOnEventManager();
		getView().setVisibility(false);
		this.itemView = null;
		attemptRemoveFrom(ItemMap.getInstance().getItemTileAtLocation(entity.getLocation()));
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
		return "trap";
	}
	
	public void setVisiblity(boolean visiblity) {
		this.itemView.setVisibility(visiblity);
	}
	
	private void setEvent(Event event) {
		this.event = event;
	}

}
