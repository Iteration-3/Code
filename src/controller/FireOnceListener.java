package controller;

import gameactions.GameAction;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import view.Layout;

public class FireOnceListener extends Listener {

    public FireOnceListener(KeyStroke keystroke, GameAction gameAction) {
        super(keystroke, gameAction);
    }
    @Override
    public void addAsBinding(Layout panel) {
        
        @SuppressWarnings("serial")
        KeyState keyUpState = new KeyState(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                active();
            }

        });
        
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(
                KeyStroke.getKeyStroke("released " + Character.toString(Character.toUpperCase(getKey().getKeyChar()))),
                keyUpState);
        panel.getActionMap().put(keyUpState, keyUpState.getAction());
    }
    
    public void active() {
       getGameAction().perform(); 
    }

}
