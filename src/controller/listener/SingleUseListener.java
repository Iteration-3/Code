package controller.listener;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import view.layout.Layout;
import controller.KeyState;

public class SingleUseListener extends Listener {

    public SingleUseListener(KeyStroke keystroke, GameAction gameAction) {
        super(keystroke, gameAction);
    }

    @Override
    public void addAsBinding(Layout panel) {

        @SuppressWarnings("serial")
        KeyState keyUpState = new KeyState(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                activate();
            }

        });

        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("released " + getKey().toString().replaceAll("(pressed|typed) ", "")),
                keyUpState);
        panel.getActionMap().put(keyUpState, keyUpState.getAction());
    }

    @Override
    public void activate() {
        getGameAction().perform();
    }

}
