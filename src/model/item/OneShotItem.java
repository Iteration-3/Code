package model.item;

import model.entity.Entity;
import model.event.EventManager;
import model.event.HealthModifierEvent;
import model.event.LivesModifierEvent;
import model.event.ManaModifierEvent;
import model.event.MovementModifierEvent;
import model.event.StatisticModifierEvent;
import model.map.tile.ItemTile;
import model.statistics.EntityStatistics;
import utilities.structuredmap.StructuredMap;
import view.item.ItemView;

public class OneShotItem extends Item {
	private EntityStatistics modifiers;

	public OneShotItem(ItemView itemView, EntityStatistics modifiers) {
		super(itemView);
		this.modifiers = modifiers;
	}
	
	public OneShotItem(StructuredMap map) {
	    //TODO verify saving and loading
	    super(map);
	    this.modifiers = new EntityStatistics(map.getStructuredMap("modifiers"));
	}

	@Override
	public void touch(Entity entity) {
		use(entity);
		itemView.removeFromMap();
	}

	@Override
	public void use(Entity entity) {
		EventManager.getSingleton().addEvent(new StatisticModifierEvent(modifiers, entity, 0));
		EventManager.getSingleton().addEvent(new LivesModifierEvent(modifiers.getLivesLeft(), entity, 0));
		EventManager.getSingleton().addEvent(new HealthModifierEvent(modifiers.getCurrentHealth(), entity, 0));
		EventManager.getSingleton().addEvent(new MovementModifierEvent(modifiers.getMovement(), entity, 0));
		EventManager.getSingleton().addEvent(new ManaModifierEvent(modifiers.getCurrentMana(), entity, 0));
	}

	@Override
	public String getInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void attemptRemoveFrom(ItemTile itemTile) {
		itemTile.remove(this);
	}

    @Override
    public StructuredMap getStructuredMap() {
       StructuredMap map = new StructuredMap();
       map.put("modifiers", modifiers.getStructuredMap());
       return map;
    }

	@Override
	protected String getType() {
		return "oneShot";
	}

}
