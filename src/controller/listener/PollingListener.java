package controller.listener;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import view.layout.Layout;
import controller.KeyState;

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
            }

        });

        keyUpState = new KeyState(new AbstractAction() {

            @Override
            public void actionPerformed(ActionEvent e) {
                down = false;
            }

        });

        // Register KeyDown Event
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                getKey(), keyDownState);
        panel.getActionMap().put(keyDownState, keyDownState.getAction());
        
        // Register KeyReleased Event
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke(getKey().toString().replaceAll("(pressed|typed) ", "released ")),
                keyUpState);
        panel.getActionMap().put(keyUpState, keyUpState.getAction());

    }

    private boolean isPressed() {
        return down;
    }

    @Override
    public boolean activate() {
        if (isPressed()) {
            getGameAction().perform();
            return true;
        }
        return false;
    }

}
