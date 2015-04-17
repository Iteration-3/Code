package model;

import model.entity.Avatar;
import model.states.StateMachine;
import model.states.gamestates.GameState;
import view.View;
import view.layout.Layout;

public class Model extends StateMachine<GameState> {
    private View view;
    private KeyPreferences preferences;

    public Model() {
        view = new View();
    }

    @Override
    public void pushState(GameState state) {
        state.setContext(this); // must be called before super.pushState() so
                                // that the
                                // GameState may safely call getContext() in its
                                // onEnter()
        super.pushState(state);
    }

    @Override
    public void switchState(GameState state) {
        state.setContext(this); // same issue as above
        super.switchState(state);
    }

    public void setLayout(Layout layout) {
        view.addGameLayout(layout);
    }

    public void removeLayout(Layout layout) {
        view.removeGameLayout(layout);
    }

    public Avatar getAvatar() {
        // TODO link in when we have stuff for the model class
        return null;
    }

    public void update() {
        if (this.currentState() != null) {
            this.currentState().update();// Currently only updates the current
                                         // state.

        }

    }

    public void setPreferences(KeyPreferences preferences) {
        this.preferences = preferences;
    }

    public KeyPreferences getPreferences() {
        return this.preferences;
    }
}
