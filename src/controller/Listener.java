package controller;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import view.Layout;

public class Listener {
    private KeyStroke key;
    private GameAction gameAction;
    private boolean down = false;
    private KeyState keyDownState;
    private KeyState keyUpState;

    public Listener(KeyStroke keystroke, GameAction gameAction) {
        key = keystroke;
        this.gameAction = gameAction;
    }

    @SuppressWarnings("serial")
    public void addAsBinding(Layout panel) {

        // Anonymous Classes...
        keyDownState = new KeyState(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                down = true;
                // System.out.println("I've been pressed down=" + down);
                // gameAction.perform();
            }

        });

        keyUpState = new KeyState(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                down = false;
                // System.out.println("I've been released.  down=" + down);
            }

        });

        // Register KeyDown Event
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("typed " + Character.toString(key.getKeyChar())), keyDownState);
        panel.getActionMap().put(keyDownState, keyDownState.getAction());

        // Register KeyReleased Event
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("released " + Character.toString(Character.toUpperCase(key.getKeyChar()))),
                keyUpState);
        panel.getActionMap().put(keyUpState, keyUpState.getAction());

    }

    public boolean isPressed() {
        return down;
    }

    public void activate() {
        if (isPressed()) {
            gameAction.perform();
        }
    }

}
