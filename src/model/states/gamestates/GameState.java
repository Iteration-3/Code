package model.states.gamestates;

import view.Layout;
import model.Model;
import model.states.State;
import model.states.StateMachine;

public abstract class GameState extends State {
    private Model model;

    @Override
    public void onEnter() {
        getContext().setLayout(getLayout());
    }

    @Override
    public void onPause() {
        getContext().removeLayout(getLayout());
    }

    @Override
    public void onResume() {
        getContext().setLayout(getLayout());
    }

    @Override
    public void onExit() {
        getContext().removeLayout(getLayout());
    }

    @Override
    public Model getContext() {
        return model;
    }

    public void setContext(Model model) {
    	this.model = model;
    }
    
    protected abstract Layout getLayout();
}
