package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Timer;

import model.entity.Avatar;
import controller.listener.Listener;

public class AvatarController implements ActionListener {
    private Collection<Listener> listeners = new ArrayList<Listener>();
    private Avatar avatar;
    private double tilesPerSecond = 0.0;
    private double previousTime = System.currentTimeMillis() / 1000.0;
    private boolean hasMoved = false;

    public AvatarController(Avatar avatar) {
    	this.avatar = avatar;
        startTimer();
    }

    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    private void startTimer() {
        Timer t = new Timer(65, this);
        t.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
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
        listeners = new ArrayList<Listener>();
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
