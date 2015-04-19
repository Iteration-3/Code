package model.event;

import model.entity.Avatar;
import model.item.TakeableItem;
import utilities.structuredmap.StructuredMap;

public final class PickPocketEvent extends SourcedEvent {
	
	public PickPocketEvent() {
		super(null, null, 0);
	}
	
	public PickPocketEvent(StructuredMap map) {
		super(map);
	}
	
	@Override
	public void perform() {
		if (hasTarget() && getSource() != null) {
			TakeableItem[] items = getTarget().getItems();
			int randomIndex = (int) Math.random() * items.length;
			TakeableItem takenItem = items[randomIndex];
			getTarget().removeItem(randomIndex);

			Avatar avatar = (Avatar) this.getSource();
			avatar.addItem(takenItem);
		}
	}

	@Override
	public PickPocketEvent clone() {
		PickPocketEvent clone = new PickPocketEvent();
		clone.setSource(this.getSource());
		clone.setTarget(this.getTarget());
		clone.setDuration(this.getDuration());
		return clone;
	}

	@Override
	protected String getType() {
		return "pickPocket";
	}

}
