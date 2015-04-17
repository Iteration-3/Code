package model.states.gamestates;

import controller.Controller;
import view.Layout;
import model.Model;
import model.states.State;

public abstract class GameState extends State {
    private Model model;

    @Override
    public void onEnter() {
        getContext().setLayout(getLayout());
    }

    @Override
    public void onPause() { 
    	getController().toggle();
    }

    @Override
    public void onResume() {
    	getController().toggle();
    }

    @Override
    public void onExit() {
        getContext().removeLayout(getLayout());
    }

    public Model getContext() {
        return model;
    }

    public void setContext(Model model) {
    	this.model = model;
    }
    
    protected abstract Layout getLayout();
    
    protected abstract Controller getController();
}
