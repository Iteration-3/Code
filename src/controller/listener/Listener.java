package controller.listener;

import gameactions.GameAction;

import javax.swing.KeyStroke;

import view.layout.Layout;

public abstract class Listener {
    private KeyStroke key;
    private GameAction gameAction;

    public Listener(KeyStroke keystroke, GameAction gameAction) {
        key = keystroke;
        this.gameAction = gameAction;
    }

    public abstract void addAsBinding(Layout panel);

    public abstract boolean activate();

    public KeyStroke getKey() {
        return this.key;
    }

    public GameAction getGameAction() {
        return this.gameAction;
    }

}
