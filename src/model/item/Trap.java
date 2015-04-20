package model.item;

import factories.EventFactory;
import model.entity.Entity;
import model.event.Event;
import model.event.TemporaryMovementModifierEvent;
import model.map.tile.ItemTile;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class Trap extends Item {
	private Event event;
	
	public Trap(ItemView itemView) {
		super(itemView);
		Event event = new TemporaryMovementModifierEvent(20, -100000);
		setEvent(event);
	}
	
	public Trap(ItemView itemView, Event event) {
		super(itemView);
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
		return "trap";
	}
	
	private void setEvent(Event event) {
		this.event = event;
	}

}
