package model.entity;




import gameactions.GameActionDismount;
import gameactions.GameActionMovement;

import java.util.ArrayList;
import java.util.Collection;

import model.KeyPreferences;
import model.Model;
import model.map.GameTerrain;
import model.map.ItemMap;
import utilities.Angle;
import controller.listener.Listener;
import controller.listener.PollingListener;

public class EntityMovementAssocation {
	private Entity entity;
	private GameTerrain terrain;
	private ItemMap itemMap;

	public EntityMovementAssocation(Entity entity, GameTerrain terrain, ItemMap itemMap) {
		this.entity = entity;
		this.terrain = terrain;
		this.itemMap = itemMap;

	}

	public Collection<Listener> getListeners(Model model) {
		KeyPreferences preferences = model.getPreferences();
		if (entity == null) {
			return new ArrayList<Listener>();
		} else {
			Collection<Listener> listeners = entity.getListeners(preferences);
			listeners.add(new PollingListener(preferences.getUpLeftKey(), new GameActionMovement(entity,terrain, itemMap, Angle.UP_LEFT)));
			listeners.add(new PollingListener(preferences.getDownKey(), new GameActionMovement(entity,terrain, itemMap, Angle.DOWN)));
			listeners.add(new PollingListener(preferences.getDownRightKey(), new GameActionMovement(entity,terrain, itemMap,Angle.DOWN_RIGHT)));
			listeners.add(new PollingListener(preferences.getDownLeftKey(), new GameActionMovement(entity,terrain, itemMap, Angle.DOWN_LEFT)));
			listeners.add(new PollingListener(preferences.getUpRightKey(), new GameActionMovement(entity,terrain, itemMap, Angle.UP_RIGHT)));
			listeners.add(new PollingListener(preferences.getUpKey(), new GameActionMovement(entity,terrain, itemMap, Angle.UP)));
			listeners.add(new PollingListener(preferences.getDismountKey(), new GameActionDismount(model)));
			return listeners;
		}
	}

}
