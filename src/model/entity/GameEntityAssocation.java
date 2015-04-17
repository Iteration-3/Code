package model.entity;




import gameactions.GameActionMovement;

import java.util.Collection;

import javax.swing.KeyStroke;

import utilities.Angle;
import controller.listener.Listener;
import controller.listener.PollingListener;
import model.KeyPreferences;
import model.map.GameTerrain;

public class GameEntityAssocation {
	private Entity entity;
	private GameTerrain terrain;
	public GameEntityAssocation(Entity entity, GameTerrain terrain){
		this.entity = entity;
		this.terrain = terrain;

	}
	public Collection<Listener> getListeners(KeyPreferences preferences){
		Collection<Listener> listeners = entity.getListeners();
		// TODO(jraviles) get these from the key preferences
		listeners.add(new PollingListener(preferences.getUpLeftKey(), new GameActionMovement(entity,terrain,Angle.UP_LEFT)));
		listeners.add(new PollingListener(preferences.getDownKey(), new GameActionMovement(entity,terrain,Angle.DOWN)));
		listeners.add(new PollingListener(preferences.getDownRightKey(), new GameActionMovement(entity,terrain,Angle.DOWN_RIGHT)));
		listeners.add(new PollingListener(preferences.getDownLeftKey(), new GameActionMovement(entity,terrain,Angle.DOWN_LEFT)));
		listeners.add(new PollingListener(preferences.getUpRightKey(), new GameActionMovement(entity,terrain,Angle.UP_RIGHT)));
		listeners.add(new PollingListener(preferences.getUpKey(), new GameActionMovement(entity,terrain,Angle.UP)));
		return listeners;
	}

}
