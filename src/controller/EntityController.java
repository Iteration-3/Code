package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

import javax.swing.Timer;

import controller.listener.Listener;

public class EntityController implements ActionListener {
    private Collection<Listener> listeners = new ArrayList<Listener>();

    public EntityController() {
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
            listener.activate();
        }
    }

    public void removeListeners() {
        listeners = new ArrayList<Listener>();

    }

}
