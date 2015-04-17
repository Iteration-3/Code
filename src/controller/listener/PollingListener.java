package controller.listener;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import controller.KeyState;
import view.Layout;

public class PollingListener extends Listener {

    private boolean down = false;
    private KeyState keyDownState;
    private KeyState keyUpState;

    public PollingListener(KeyStroke stroke, GameAction action) {
        super(stroke, action);
    }

    @SuppressWarnings("serial")
    @Override
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
                KeyStroke.getKeyStroke("pressed " + Character.toString(Character.toUpperCase(getKey().getKeyChar()))),
                keyDownState);
        panel.getActionMap().put(keyDownState, keyDownState.getAction());

        // Register KeyReleased Event
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("released " + Character.toString(Character.toUpperCase(getKey().getKeyChar()))),
                keyUpState);
        panel.getActionMap().put(keyUpState, keyUpState.getAction());

    }

    private boolean isPressed() {
        return down;
    }

    @Override
    public void activate() {
        if (isPressed()) {
            getGameAction().perform();
        }
    }

}
