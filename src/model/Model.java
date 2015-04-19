package model;

import model.entity.Entity;
import model.entity.EntityManager;
import model.entity.Mount;
import model.entity.dialog.DialogManager;
import model.states.StateMachine;
import model.states.gamestates.GameState;
import view.View;
import view.layout.Layout;

public class Model extends StateMachine<GameState> {
    private View view;
    private KeyPreferences preferences;
    private Mount currentMount;

    public Model() {
        view = new View();
        DialogManager.getSingleton().setModel(this);
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

    public Entity getCurrentUnit() {
    	return currentMount == null ? EntityManager.getSingleton().getAvatar() : currentMount;
    }
    
    public void setMount(Mount mount) {
    	this.currentMount = mount;
    }
    
    public void clearMount() {
    	if (this.currentMount != null) {
    		this.currentMount.dismount();
    		this.currentMount = null;
    	}
    }

    public void setPreferences(KeyPreferences preferences) {
        this.preferences = preferences;
    }

    public KeyPreferences getPreferences() {
        return this.preferences;
    }
}
