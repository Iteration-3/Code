package model.states.gamestates;

import controller.Controller;
import view.layout.Layout;
import model.KeyPreferences;
import model.Model;
import model.states.State;

public abstract class GameState extends State {
    private Model model;
    private KeyPreferences prefrences;

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

    public KeyPreferences getPreferences() {
        return prefrences;
    }

    public void setPrefrences(KeyPreferences prefrences) {
        this.prefrences = prefrences;
    }

    protected abstract Layout getLayout();

    protected abstract Controller getController();

    public void update() {
        // Defaults to polling nothing, overridden where neded.
    }
}
