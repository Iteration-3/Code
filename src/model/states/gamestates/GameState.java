package model.states.gamestates;

import model.Model;
import model.states.State;
import view.layout.Layout;
import controller.Controller;

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

    public void update() {
        // Defaults to polling nothing, overridden where neded.
    }
}
