package controller;

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;

import model.entity.Avatar;
import controller.listener.Listener;

public class AvatarController {
    private Collection<Listener> listeners = new CopyOnWriteArrayList<Listener>();
    private Avatar avatar;
    private double tilesPerSecond = 0.0;
    private double previousTime = System.currentTimeMillis() / 1000.0;
    private boolean hasMoved = false;

    public AvatarController(Avatar avatar) {
    	this.avatar = avatar;
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    public void update() {
        for (Listener listener : listeners) {
        	if (movementOk()) {
        		boolean movementSuccess = listener.activate();
        		if (movementSuccess) {
        			movementNeedsToWait();
        		}
        	}
        }
    }

    public void removeListeners() {
        listeners.clear();
    }
    
    private boolean movementOk() {
    	double currentTime = System.currentTimeMillis() / 1000.0;
    	tilesPerSecond = avatar.getDerivedStats().getMovement();

    	// If we have waited enough time, we can say that we are free to move 
    	if (currentTime - previousTime >= (1.0 / tilesPerSecond)) {
    		hasMoved = false;
		    previousTime = currentTime;
    	}

    	return !hasMoved;
    }
    
    private void movementNeedsToWait() {
    	hasMoved = true;
    }

}
