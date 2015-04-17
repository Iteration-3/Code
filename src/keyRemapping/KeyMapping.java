package keyRemapping;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.KeyPreferences;
import controller.KeyBindingsController;

public abstract class KeyMapping implements KeyListener {

    private KeyPreferences keyPreferences;
    private KeyBindingsController controller;

    public KeyMapping(KeyPreferences preferences, KeyBindingsController controller) {
        this.controller = controller;
        this.keyPreferences = preferences;
    }

    public KeyPreferences getKeyPreferences() {
        return keyPreferences;
    }

    public void setKeyPreferences(KeyPreferences keyPreferences) {
        this.keyPreferences = keyPreferences;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        System.out.println("Updating " + arg0.getKeyChar());
        updatePreferences(arg0);
        controller.removeKeyMapping(this);
    }

    protected abstract void updatePreferences(KeyEvent arg0);

    @Override
    public void keyReleased(KeyEvent arg0) {

    }

    @Override
    public void keyTyped(KeyEvent arg0) {

    }

}
